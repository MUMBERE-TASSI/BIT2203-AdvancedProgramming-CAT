package q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLogin {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/university_db";

    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "secure123";

    public static void main(String[] args) {

        String registrationNumber = "BIT/001/2026";
        String password = "student123";

        String sql =
                "SELECT registration_number " +
                "FROM students " +
                "WHERE registration_number = ? AND password = ?";

        try (
            Connection connection = DriverManager.getConnection(
                    DB_URL,
                    DB_USER,
                    DB_PASSWORD
            );

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(1, registrationNumber);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    System.out.println("Login successful.");
                    System.out.println(
                            "Student: "
                            + resultSet.getString("registration_number")
                    );
                } else {
                    System.out.println("Invalid registration number or password.");
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database error: " + e.getMessage()
            );
        }
    }
}

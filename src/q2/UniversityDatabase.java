package q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversityDatabase {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/university_db";

    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "secure123";

    public static void main(String[] args) {

        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS courses (" +
                "course_id INT PRIMARY KEY, " +
                "course_name VARCHAR(100) NOT NULL, " +
                "credits INT NOT NULL, " +
                "department VARCHAR(50) NOT NULL" +
                ")";

        String insertSQL =
                "INSERT INTO courses " +
                "(course_id, course_name, credits, department) " +
                "VALUES (?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "course_name = VALUES(course_name), " +
                "credits = VALUES(credits), " +
                "department = VALUES(department)";

        String selectSQL =
                "SELECT course_id, course_name, credits, department " +
                "FROM courses " +
                "WHERE department = ?";

        try (Connection connection = DriverManager.getConnection(
                DB_URL,
                DB_USER,
                DB_PASSWORD)) {

            System.out.println("Connected to university_db successfully.");

            // Create the courses table.
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Courses table created successfully.");
            }

            // Insert three sample courses.
            try (PreparedStatement statement =
                         connection.prepareStatement(insertSQL)) {

                addCourse(statement, 101, "Advanced Programming",
                        3, "Computer Science");

                addCourse(statement, 102, "Database Systems",
                        3, "Computer Science");

                addCourse(statement, 103, "Computer Networks",
                        4, "Information Technology");

                statement.executeBatch();

                System.out.println("Three sample courses inserted.");
            }

            // Retrieve Computer Science courses.
            try (PreparedStatement statement =
                         connection.prepareStatement(selectSQL)) {

                statement.setString(1, "Computer Science");

                try (ResultSet resultSet = statement.executeQuery()) {

                    System.out.println();
                    System.out.println(
                            "Courses in the Computer Science department:"
                    );

                    while (resultSet.next()) {

                        System.out.println(
                                "Course ID: "
                                + resultSet.getInt("course_id")
                        );

                        System.out.println(
                                "Course Name: "
                                + resultSet.getString("course_name")
                        );

                        System.out.println(
                                "Credits: "
                                + resultSet.getInt("credits")
                        );

                        System.out.println(
                                "Department: "
                                + resultSet.getString("department")
                        );

                        System.out.println("-------------------------");
                    }
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database error: " + e.getMessage()
            );
        }
    }

    private static void addCourse(
            PreparedStatement statement,
            int courseId,
            String courseName,
            int credits,
            String department) throws SQLException {

        statement.setInt(1, courseId);
        statement.setString(2, courseName);
        statement.setInt(3, credits);
        statement.setString(4, department);

        statement.addBatch();
    }
}

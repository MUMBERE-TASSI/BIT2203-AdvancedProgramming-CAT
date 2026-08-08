package q4;

import org.springframework.stereotype.Repository;

/**
 * Repository class responsible for user-related data access.
 *
 * The @Repository annotation tells Spring that this class
 * should be managed as a Spring bean.
 */
@Repository
public class UserRepository {

    /**
     * Finds a user by their ID.
     *
     * @param userId the ID of the user
     * @return a sample user name
     */
    public String findUserById(int userId) {
        return "User-" + userId;
    }
}

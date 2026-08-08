package q4;

import org.springframework.stereotype.Service;

/**
 * Service class demonstrating constructor-based
 * Dependency Injection in Spring.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor Injection.
     *
     * Spring provides the UserRepository dependency
     * when creating the UserService object.
     *
     * @param userRepository the repository dependency
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a user using the repository.
     *
     * @param userId the ID of the user
     * @return user information
     */
    public String getUser(int userId) {
        return userRepository.findUserById(userId);
    }
}

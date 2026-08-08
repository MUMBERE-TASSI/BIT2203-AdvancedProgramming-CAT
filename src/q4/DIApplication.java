package q4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates Spring Dependency Injection
 * using constructor injection.
 */
public class DIApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            UserService userService = context.getBean(UserService.class);

            String user = userService.getUser(101);

            System.out.println("Dependency Injection successful.");
            System.out.println("Retrieved user: " + user);
        }
    }
}

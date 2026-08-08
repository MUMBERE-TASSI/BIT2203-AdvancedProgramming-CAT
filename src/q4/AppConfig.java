package q4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration class.
 *
 * Component scanning allows Spring to discover
 * UserService and other annotated components.
 */
@Configuration
@ComponentScan("q4")
public class AppConfig {
}

package etc.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "etc.factory")
public class AppConfig {

    @Bean
    public AComponent aComponent() {
        return new AComponent();
    }

    @Bean
    public BComponent bComponent() {
        return new BComponent();
    }

}

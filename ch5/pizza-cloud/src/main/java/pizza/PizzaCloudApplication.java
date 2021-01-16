package pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pizza.controller.OrderController;

@SpringBootApplication
public class PizzaCloudApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PizzaCloudApplication.class, args);
    }

}

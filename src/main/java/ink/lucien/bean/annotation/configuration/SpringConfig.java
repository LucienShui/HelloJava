package ink.lucien.bean.annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Apple apple() {
        return new Apple();
    }
}

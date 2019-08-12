package ink.lucien.bean.annotation.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Apple apple = context.getBean(Apple.class);
        System.out.println(apple);
    }
}

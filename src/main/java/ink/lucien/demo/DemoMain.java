package ink.lucien.demo;

import ink.lucien.demo.main.Main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ink.lucien.demo")
public class DemoMain {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DemoMain.class).getBean(Main.class).main();
    }
}

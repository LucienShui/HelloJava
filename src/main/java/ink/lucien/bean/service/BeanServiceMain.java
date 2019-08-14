package ink.lucien.bean.service;

import ink.lucien.bean.service.runner.Runner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ink.lucien.bean.service")
public class BeanServiceMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanServiceMain.class);
        for (int i = 0; i < 10; i++) {
            // TODO NormalClass 也只被创建了一次
            System.out.println(context.getBean(Runner.class));
        }
    }
}

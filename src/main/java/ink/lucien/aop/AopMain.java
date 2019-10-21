package ink.lucien.aop;

import ink.lucien.aop.runner.Runner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Lucien on 2019/10/21 12:31
 */
@ComponentScan
public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopMain.class);
        Runner runner = context.getBean(Runner.class);
        System.out.println(runner.toUpper("Hello World!"));
        System.out.println(runner.toLower("Hello World!"));
    }
}

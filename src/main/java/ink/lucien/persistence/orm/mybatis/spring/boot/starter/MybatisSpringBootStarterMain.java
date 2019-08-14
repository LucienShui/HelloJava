package ink.lucien.persistence.orm.mybatis.spring.boot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisSpringBootStarterMain {
    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootStarterMain.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}

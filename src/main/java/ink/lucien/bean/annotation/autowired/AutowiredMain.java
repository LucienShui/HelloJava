package ink.lucien.bean.annotation.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        Store store = context.getBean(Store.class);
        System.out.println(store);
    }
}

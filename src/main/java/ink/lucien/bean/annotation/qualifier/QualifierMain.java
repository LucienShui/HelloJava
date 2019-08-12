package ink.lucien.bean.annotation.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        Store store = context.getBean(Store.class);
        System.out.println(store);
        context.close();
    }
}

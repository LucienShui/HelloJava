package ink.lucien.bean.service.model;

import org.springframework.stereotype.Component;

@Component
public class NormalClass {
    public NormalClass() {
        System.out.println("NormalClass Created");
    }

    public String toString() {
        return "World!";
    }
}

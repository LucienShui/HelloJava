package ink.lucien.bean.service.model;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public ServiceClass() {
        System.out.println("ServiceClass Created");
    }

    @Override
    public String toString() {
        return "Hello";
    }
}

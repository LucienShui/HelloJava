package ink.lucien.bean.service.runner;

import ink.lucien.bean.service.model.NormalClass;
import ink.lucien.bean.service.model.ServiceClass;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    private ServiceClass serviceClass;
    private NormalClass normalClass;

    public Runner(ServiceClass serviceClass, NormalClass normalClass) {
        this.serviceClass = serviceClass;
        this.normalClass = normalClass;
    }

    public String toString() {
        return serviceClass.toString() + " " + normalClass.toString();
    }
}

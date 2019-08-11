package ink.lucien.bean.annotation.autowired;

import ink.lucien.bean.annotation.autowired.inter.Fruit;
import org.springframework.stereotype.Component;

@Component
public class Store {

    // TODO 这里可以省略掉 Autowired，不知道为什么
    private final Fruit fruit;

    public Store(Fruit fruit) {
        this.fruit = fruit;
    }

    public String toString() {
        return fruit.toString();
    }
}

package ink.lucien.alibaba.fastjson;

import lombok.Data;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingyuan.sqy on 2019/9/4.
 */
public class FastJsonMain {

    @Data
    public static class Person {
        private String name;

        private Integer age;
    }

    public static void main(String[] args) {
        Person lucien = new Person();
        lucien.setName("Lucien");
        lucien.setAge(21);

        Person irene = new Person();
        irene.setName("Irene");
        irene.setAge(21);

        List<Person> personList = new ArrayList<Person>();
        personList.add(lucien);
        personList.add(irene);

        System.out.println(JSON.toJSON(lucien).toString());
        System.out.println(JSON.toJSON(personList).toString());
    }
}

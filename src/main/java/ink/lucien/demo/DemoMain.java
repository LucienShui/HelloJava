package ink.lucien.demo;

import ink.lucien.demo.model.Model;

public class DemoMain {
    public static void main(String[] args) {
        Model model = new Model();

        model.setId(0L);

        model.setDetail(new Model.InnerModel());

        model.getDetail().setName("Lucien");

        if (null == model.getDetail()) {
            System.out.println("null");
        }

        System.out.println(model);
    }
}

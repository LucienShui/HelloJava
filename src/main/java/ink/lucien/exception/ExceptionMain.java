package ink.lucien.exception;

import ink.lucien.exception.classes.Model;

public class ExceptionMain {
    public static void main(String[] args) {
        Model model = new Model();
        try {
            model.run();
        } catch (Exception e) {
            System.out.println("Main: " + e.toString());
        }
    }
}

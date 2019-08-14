package ink.lucien.exception.classes;

public class Model {
    private void method() throws Exception {
        throw new Exception("Hello World!");
    }

    public void run() {
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

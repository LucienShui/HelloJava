package ink.lucien.java.lang;

/**
 * Created by Lucien on 2019/11/18 09:11
 */
public class AutoCloseableMain {

    static class Test implements AutoCloseable {

        public void main() {
            System.out.println("Hello AutoCloseable");
        }

        @Override
        public void close() throws Exception {

        }
    }

    public static void main(String[] args) {
        try (Test test = new Test()) {
            test.main();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (AutoCloseable autoCloseable = new AutoCloseable() {

            public void main() {
                System.out.println("I can not be execute");
            }

            @Override
            public void close() throws Exception {
                System.out.println("I leave");
            }
        }) {
            System.out.println("In try catch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ink.lucien.java.io;

import java.io.Serializable;

/**
 * Created by qingyuan.sqy on 2019/8/21.
 */

public class SerializableMain {

    private static class Test implements Serializable {
        private String firstName;

        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String toString() {
            return String.format("%s %s", firstName, lastName);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setFirstName("Hello");
        test.setLastName("World!");
        System.out.println(test);
    }
}

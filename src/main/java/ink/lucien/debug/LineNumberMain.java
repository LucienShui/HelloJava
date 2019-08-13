package ink.lucien.debug;

import ink.lucien.debug.linenumber.LineNumber;

public class LineNumberMain {
    private static String test(String message) {
        return LineNumber.get() + " " + message;
    }
    public static void main(String[] args) {
        System.out.println(test("Hello World!"));
        System.out.println(test("Hi World!"));
        System.out.println(test("Hello Java!"));
    }

}

package ink.lucien.debug;

import ink.lucien.debug.linenumber.LineNumber;

public class LineNumberMain {
    private static String test() {
        return LineNumber.get();
    }
    public static void main(String[] args) {
        System.out.println(test()); // LineNumberMain.java.test:7
        System.out.println(LineNumber.get()); // LineNumberMain.java.main:11
        System.out.println((new LineNumber()).getLineNumber()); // LineNumberMain.java.main:12
        LineNumber lineNumber = new LineNumber();
        System.out.println(lineNumber.getLineNumber());
        lineNumber.main(); // LineNumber.java.main:27
    }
}

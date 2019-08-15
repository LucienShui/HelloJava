package ink.lucien.debug;

import ink.lucien.debug.linenumber.LineNumber;

public class LineNumberMain {
    private static String test() {
        return LineNumber.get();
    }
    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(LineNumber.get());
        System.out.println((new LineNumber()).getLineNumber());
        LineNumber lineNumber = new LineNumber();
        lineNumber.main();
    }
}

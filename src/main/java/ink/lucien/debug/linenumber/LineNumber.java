package ink.lucien.debug.linenumber;

public class LineNumber {
    public static String get() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return "[" +
                stackTraceElement.getFileName() +
                "." +
                stackTraceElement.getMethodName() +
                ":" +
                stackTraceElement.getLineNumber() +
                "]";
    }

    public String getLineNumber() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return "[" +
                stackTraceElement.getFileName() +
                "." +
                stackTraceElement.getMethodName() +
                ":" +
                stackTraceElement.getLineNumber() +
                "]";
    }

    public void main() {
        System.out.println(getLineNumber());
        System.out.println("Hello World!");
        System.out.println(getLineNumber());
    }
}

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
}

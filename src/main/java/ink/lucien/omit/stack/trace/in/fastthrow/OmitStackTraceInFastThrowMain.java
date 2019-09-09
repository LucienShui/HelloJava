package ink.lucien.omit.stack.trace.in.fastthrow;

/**
 * Created by Lucien on 2019/8/27.
 */
public class OmitStackTraceInFastThrowMain {
    public static void main(String[] args) {
        String str = null;
        int n = 118700;
        while (n-- != 0) {
            try {
                str.length();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

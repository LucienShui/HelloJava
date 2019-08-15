package ink.lucien.time;

import java.util.Date;

public class TimeMain {
    private static void sleep() {
        for (long i = 0; i < 8e8; i++) {
            new Date(); // 防止循环被优化
        }
    }
    public static void main(String[] args) {
        Date start = new Date();
        sleep();
        Date end = new Date();
        long delta = (end.getTime() - start.getTime() + 999) / 1000;
        System.out.println(delta);

        delta = System.currentTimeMillis();
        sleep();
        delta = (System.currentTimeMillis() - delta + 999) / 1000;
        System.out.println(delta);
    }
}

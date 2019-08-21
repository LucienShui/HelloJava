package ink.lucien.date;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Lucien on 2019/8/21.
 */
public class DateMain {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(DateUtils.addDays(date, -5)));
    }
}

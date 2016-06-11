import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAndCalendar {
    public static void main(String[] args) {
        // Modified example from JavaOne 2008
        Date date = new Date(107, 11, 13, 16, 40);
        TimeZone timeZone = TimeZone.getTimeZone("+08:00 - extended");
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat("HH:MM Z");
        String string = dateFormat.format(calendar.getTime());
        System.out.println(string); // 16:12 +0300
    }
}

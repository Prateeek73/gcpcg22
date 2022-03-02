package exp.newdatetimedemos;

import java.time.LocalDateTime;

public class LocalDateTimeEx {
    public static void main(String args[]) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("current day and time=" + now.getDayOfMonth() + "-" + now.getMonthValue() + "  " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
        LocalDateTime dateTime2 = LocalDateTime.of(2000, 7, 19, 8, 30, 35);
        System.out.println("birthday day and time=" + dateTime2.getDayOfMonth() + "-" + dateTime2.getMonthValue() + "-" + dateTime2.getYear() + "  " + dateTime2.getHour() + ":" + dateTime2.getMinute() + ":" + dateTime2.getSecond());

    }
}

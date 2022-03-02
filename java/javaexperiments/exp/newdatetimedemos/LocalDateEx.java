package exp.newdatetimedemos;

import java.time.LocalDate;

public class LocalDateEx {
    public static void main(String args[]) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        boolean isAfter = tomorrow.isAfter(today);
        System.out.println("tomorrow after today="+isAfter);
        LocalDate karthikDob = LocalDate.of(2000, 7, 19);
        System.out.println("year="+karthikDob.getYear()+"month="+karthikDob.getMonthValue()+" day="+karthikDob.getDayOfMonth());

       int compare= tomorrow.compareTo(today);
        System.out.println("compare="+compare);

    }
}

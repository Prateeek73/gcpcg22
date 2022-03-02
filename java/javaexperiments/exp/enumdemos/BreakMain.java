package exp.enumdemos;

public class BreakMain {
    public static void main(String args[]) {
        DayBreak lunchBreak1 = DayBreak.Lunch;
        DayBreak morningBreak = DayBreak.Morning;
        DayBreak lunchBreak2 = DayBreak.Lunch;
        System.out.println(lunchBreak1);
        boolean isSame=lunchBreak1==lunchBreak2;
        System.out.println("is same object="+isSame);
        System.out.println(morningBreak+"position="+morningBreak.ordinal());
        System.out.println(lunchBreak1+"position="+lunchBreak1.ordinal());

    }
}

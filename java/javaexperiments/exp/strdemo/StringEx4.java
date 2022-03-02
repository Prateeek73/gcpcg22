package exp.stringdemos;

public class StringEx4 {
    public static void main(String args[]){
        StringBuilder result=new StringBuilder();
        for(int i=1;i<=10;i++){
            result.append(i);
        }
        String resultString=result.toString();
        System.out.println(resultString);

        StringBuilder builder1=new StringBuilder("hi");
        builder1.append("ok").append("bye");
        System.out.println(builder1);

        builder1.reverse();
        System.out.println(builder1);
    }
}

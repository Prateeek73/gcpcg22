package exp.stringdemos;

public class StringEx5 {
    public static void main(String args[]){
        StringBuffer result=new StringBuffer();
        for(int i=1;i<=10;i++){
            result.append(i);
        }
        String resultString=result.toString();
        System.out.println(resultString);

        StringBuffer stringBuffer=new StringBuffer("hi");
        stringBuffer.append("ok").append("bye");
        System.out.println(stringBuffer);

        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }
}

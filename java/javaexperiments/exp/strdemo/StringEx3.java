package exp.stringdemos;

public class StringEx3 {
    public static void main(String[] args){
        String str1="goodmorning";
        char index4=str1.charAt(4);
        //iterate and print only if character is a or e
        for(int i=0;i<str1.length();i++){
           char ch= str1.charAt(i);
           if(ch=='a' || ch=='e'){
               System.out.println("character is aither a or e");
           }
        }
        //check mor exists in str1
        boolean contains=str1.contains("mor");
        //substring starting at index3
        String substring1=str1.substring(3);
        System.out.println("substring1="+substring1);
        //substring starting at index 2 and ending at 5, char at index5 is not part of substring
        String substring2=str1.substring(2,5);
        System.out.println(substring2);
        String str2="byebyeok";
        // index at which substring is starting
        int substringStartIndex=str2.indexOf("ye");
        System.out.println("first occurence of substring start index="+substringStartIndex);

        int substringLastIndex=str2.lastIndexOf("ye");
        System.out.println("last occurence of substring start index "+substringLastIndex);

        boolean isEqual1="hello".equals("HELLO");
        boolean isEqual2="hello".equalsIgnoreCase("HELLO");
        System.out.println("with case string equals="+isEqual1);
        System.out.println("without case string equals="+isEqual2);

        String str4="good,morning";
        String parts[]=str4.split(",");
        for (String part:parts){
            System.out.println("part="+part);
        }
        String str6=" hi ";
        String str7="hi";
        boolean isEqual5=str6.equals(str7);
        System.out.println(isEqual5);

        String str8WithoutWhitespace=str6.trim();
        boolean isEqual6=str8WithoutWhitespace.equals(str7);
        System.out.println("comparison after removing white space ="+isEqual6);
    }
}

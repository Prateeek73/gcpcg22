import java.util.*;

class ArrayListOps {
   public ArrayList<Integer> makeArrayListInt(int n) {
	   ArrayList<Integer> list = new ArrayList<Integer>();
	   for(int i=0; i<n; i++){
		   list.add(0);
	   }
	   return list;
   }
   public ArrayList<Integer> reverseList(ArrayList<Integer> list){
	   Collections.reverse(list);
	   return list;
   }
   public ArrayList<Integer> changeList(ArrayList<Integer> list, int m, int n){
	   for(int i=0; i<list.size(); i++){
		   if(list.get(i)==m){
			   list.set(i, n);
		   }
	   }
	   return list;
   } 
}

public class Solution{
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 25, 33, 28, 10, 12));
		System.out.println(list);
		ArrayListOps obj = new ArrayListOps();
		int m, n;
		n = 4;		
		list = obj.makeArrayListInt(n);
		m = 28;
		n = 20;
		System.out.println(list);
		list = obj.reverseList(list);
		System.out.println(list);
		list = obj.changeList(list, m, n);
		System.out.println(list);
	}
}
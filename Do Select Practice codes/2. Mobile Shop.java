import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Mobile{
	HashMap<String, ArrayList<String>> mobiles;
	Mobile(){
		mobiles = new HashMap<>();
	}
	public String addMobile(String company, String model){
		ArrayList<String>  models;
		if(mobiles.containsKey(company)){
			models = mobiles.get(company);
		}
		else{
			models = new ArrayList<String>();
		}
		models.add(model);
		mobiles.put(company, models);
		return "model successfully added";
	}
	public ArrayList<String> getModels(String company){
		if(mobiles.containsKey(company))
			return mobiles.get(company);
		return null;
	}
	public String buyMobile(String company, String model){
		if(mobiles.containsKey(company)){
			ArrayList<String> models = mobiles.get(company);
			if(models.contains(model)){
				models.remove(model);
				return "mobile sold successfully";
			}
			return "item not available";
		}
		return "item not available";
	}
}

public class Solution{
	public static void main(String args[] ) throws Exception {
		//Scanner sc = new Scanner(System.in);
		String mobile = "Oppo";
		String model = "K30";
		Mobile obj = new Mobile();
		System.out.println(obj.addMobile(mobile, model));
		System.out.println(obj.getModels(mobile));
		System.out.println(obj.buyMobile(mobile, model));
		//sc.close();
	}
}
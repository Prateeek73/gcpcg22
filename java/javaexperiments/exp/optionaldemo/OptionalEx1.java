package exp.optionaldemo;

import java.util.*;

public class OptionalEx1 {
	public static void main(String args[]) {
		String value = "hello";
		Optional<String> optional = Optional.empty();
		boolean exists = optional.isPresent();
		if (exists) {
			String fetched = optional.get();
			System.out.println("fetched=" + fetched);
		} else {
			System.out.println("value does not exist in optional");
		}
	}
}

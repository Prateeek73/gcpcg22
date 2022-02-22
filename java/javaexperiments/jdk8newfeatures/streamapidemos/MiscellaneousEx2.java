package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MiscellaneousEx2 {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(1);

		Comparator<Integer> comparator = Integer::compare;
		Optional<Integer> minOptional = list.stream().min(comparator);
		if (minOptional.isPresent()) {
			int val = minOptional.get();
			System.out.println("min number=" + val);
		}
		Optional<Integer> maxOptional = list.stream().max(comparator);
		if (maxOptional.isPresent()) {
			int val = maxOptional.get();
			System.out.println("max number=" + val);
		}
	}
}

package generics;

import java.util.*;

public class GenericVarargs {
	public static <T> List<T> makeLise(T... args){
		List<T> result = new ArrayList<T>();
		for (T item : args) {
			result.add(item);
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> ls = makeLise("A");
		System.out.println(ls);
		ls = makeLise("A", "B", "C");
		System.out.println(ls);
		ls = makeLise("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
}

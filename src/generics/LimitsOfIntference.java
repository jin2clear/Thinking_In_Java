package generics;
import typeinfo.pets.*;
import java.util.*;

import net.mindview.util.New;
public class LimitsOfIntference {
	static void f(Map<Person, List<? extends Pet>> petPerson){
	}
	public static void main(String[] args) {
		//f(New.map()); //Dose not compile
	}
}

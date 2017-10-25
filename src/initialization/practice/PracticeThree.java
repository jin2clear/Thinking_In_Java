package initialization.practice;

public class PracticeThree {
	public PracticeThree() {
		System.out.println("PracticeThree default constructor.");
	}
	
	public PracticeThree(String s){
		System.out.println("PracticeThree constructor argument:" + s);
	}
	
	public static void main(String[] args) {
		PracticeThree p = new PracticeThree("hello");
	}
}

package initialization.practice;

public class PracticeFive {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.bark(1, 1.0);
		d.bark(1.0, 1);
	}
}

class Dog {
	void bark(int i, double d) {
		System.out.println("int,double barking..." + i);
	}

	void bark(double d, int i) {
		System.out.println("double,int howling..." + d);
	}
}
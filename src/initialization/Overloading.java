package initialization;

import static net.mindview.util.Print.*;

public class Overloading {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Tree t = new Tree(i);
			t.info();
			t.info("overloaded method");
		}
		// Overloaded Construtor:
		new Tree();
	}
}

class Tree {
	int height;

	Tree() {
		print("Planting a seedling");
	}

	Tree(int initialHight) {
		height = initialHight;
		print("Creating new Tree that is " + height + " feet tall");
	}

	void info() {
		print("Tree is " + height + " feet tall");
	}

	void info(String s) {
		print(s + ": Tree is " + height + " feet tall");
	}
}
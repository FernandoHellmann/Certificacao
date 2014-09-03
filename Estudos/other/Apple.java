package other;

import food.Fruit;

public abstract class Apple extends Fruit {

	public static void main(String[] args) {
		print(1,2,3,4,5,6);
	}

	public static void print(int... x) {
		for (int i : x) {
			System.out.println(i);
		}
	}


	public String nome() {
		return "iPhone";
	}

}

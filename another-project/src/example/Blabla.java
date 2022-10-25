package example;

public class Blabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		int y = getRandomNr();
		if(x < y) {
			System.out.println("Small");
		} else {
			System.out.println("Big");
		}
	}

	public static int getRandomNr() {
		int x = 10;
		return (int) (Math.random() * x);
	}
}

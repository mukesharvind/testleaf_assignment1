package assignment1;

public class SqrRoot1 {

	public int squareroot(int x) {
		return x;
	}

	public static void main(String[] args) {

		SqrRoot1 s1 = new SqrRoot1();

		{
			int y = s1.squareroot(3);
			int sqrt = (int) Math.sqrt(y);

			System.out.println("The square root of " + y + " is " + sqrt);
		}

	}

}

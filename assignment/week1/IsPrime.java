package week1.assignment;

public class IsPrime {

	public static void main(String[] args) {

		int i = 13;
		System.out.println("The number entered is " + i);
		boolean flag = true;
		for (int n = 2; n <= i / 2; ++n) {
			if (i % n == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(i + " is a prime number");
		}

		else {
			System.out.println(i + " is not a prime number");
		}
	}

}

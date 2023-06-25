package week1.day1;

public class IsPrime {

	public static void main(String[] args) {

		int i = 13;
		System.out.println("The number entered is " + i);
		boolean flag = false;
		for (int n = 2; n <= i / 2; ++n) {
			if (i % n == 0) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println(i + " is a prime number");
		}

		else {
			System.out.println(i + " is not a prime number");
		}
	}

}

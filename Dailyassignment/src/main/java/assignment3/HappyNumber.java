package assignment3;

public class HappyNumber {

	public static void main(String[] args) {

		// n= 19
		// 1+81=82
		// 64+4=68
		// 36+64=100
		// 1+0=1

		int n = 19;

		System.out.println("Entered number is " + n);
		boolean falg = true;

		int sum = 0;

		// System.out.println(rem);

		// System.out.println(quo);

		for (int i = 0; i <= n; i++) {
			int rem = n % 10;
			int quo = n / 10;
			sum = (rem * rem) + (quo * quo);
			System.out.println("The number is " + sum);
			n = sum;

			sum = (int) (sum + Math.pow(rem, 2));
			System.out.println("The number is " + sum);
		}

	}
}

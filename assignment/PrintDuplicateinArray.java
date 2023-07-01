package week1.assignment;

public class PrintDuplicateinArray {
	public static void main(String[] args) {

		int num[] = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20 };
		int count = num.length;
		System.out.println("The length of the array " + count);
		for (int i = 0; i <= (num.length - 1); i++) {
			count = 0;

			for (int j = i + 1; j < num.length; j++) {
				if (num[i] == num[j]) {
					System.out.println("The element that is repeated is " + num[i]);

				}

			}

		}

	}

}

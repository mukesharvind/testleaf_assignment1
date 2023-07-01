package week1.assignment;

public class FibonacciSeries {
	public static void main(String[] args) {

		int firstNum = 0;
		int secNum = 1;
		int sum = 0;
		System.out.println(firstNum);
		for (int i = 0; i <= 11; i++) {
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;

			System.out.println("The fibbonacci sereis is :" + sum);
		}

	}

}

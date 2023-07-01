package week1.assignment;

import java.util.Arrays;

public class FindSecondLargestinArray {

	public static void main(String[] args) {
		int[] data = { 3, 2, 11, 4, 6, 7 };
		int i = data.length;
		System.out.println("Length of the array is " + i);
		Arrays.sort(data);
		String sortedarray = Arrays.toString(data);
		System.out.println("the sorted array is " + sortedarray);
		for (int j = 0; (j <= (data.length - 1)); j++) {
			System.out.println(data[j]);
			if (j == data.length - 2) {

				System.out.println("The second largest number is " + data[j]);
				break;
			}
		}
	}
}

package week1.assignment;

public class FindIntersectionArrays {

	public static void main(String[] args) {

		int a[] = { 3, 2, 11, 4, 6, 7 }; // length 6
		int b[] = { 1, 2, 8, 4, 9, 7 }; // length 6

		for (int i = 0; i < b.length; i++) // compare the length starting from 1-->3
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);

				}

			}

	}

}

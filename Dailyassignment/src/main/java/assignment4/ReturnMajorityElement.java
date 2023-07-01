/**
 * 
 */
/**
 * @author Mukesh
 *
 */
package assignment4;

public class ReturnMajorityElement {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 3 };
		int arraylength = arr.length;
		System.out.println("the length of the array is " + arraylength);

		for (int i = 0; i < arr.length; i++) {// i=0
			// System.out.println(arr[i]);

			for (int j = 1 + i; j < arr.length; j++) // j=1
			{
				// System.out.println(arr[j]);

				if (arr[i] == arr[j]) {

					System.out.println(j);
				}

			}

		}
	}

}
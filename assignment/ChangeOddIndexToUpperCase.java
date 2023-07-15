package week3.day2.assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String test = "changeme";
		String upperCase = test.toUpperCase();
		char[] charArray = upperCase.toCharArray();
		System.out.println(charArray);
		for (int i = 0; i <charArray.length; i++) {
			
			if(i%2!=0) {
				
				System.out.println(charArray[i]);
			}
}
	}

}

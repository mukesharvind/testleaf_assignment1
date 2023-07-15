package week3.day2.assignments;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

	public static void main(String[] args) {
		 
		String str ="madam";
		String rev = "";
		char[] charArray = str.toCharArray();
		System.out.println(str);
		for (int i = str.length()-1; i>=0; i--) {
			System.out.println(charArray[i]);
			//rev=rev+charArray[i];
		}
		//converting character to string using valueof method and storing in rev
		String valueOf = rev.valueOf(charArray);
		System.out.println(valueOf);
		
		boolean equals = str.equals(valueOf);
		if (equals) {
			System.out.println("Given string "+str+" is palindrome");
		}
		else {
			System.out.println("Not a palindrome");
		}
//	List<Character> str2 = new ArrayList<Character>();
//	for (char each : charArray ) {
//		str2.add(each);
//	}
//	System.out.println(str2);
//	if
	}
}

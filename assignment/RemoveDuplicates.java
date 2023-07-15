package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates { 

	public static void main(String[] args) {
		
		String str = "PayPal India";
		
		//converted to char array
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		
		//empty sets 
		Set<Character> charSet  = new LinkedHashSet<Character>();
		
		
		//using for each to iterate in charset
		for (Character eachname1 : charArray) {
			
			charSet.add(eachname1);
		
		}
	System.out.println(charSet);
	
	
	}

}

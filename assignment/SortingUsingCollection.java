package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SortingUsingCollection {
	
	public static void main(String[] args) {
		String[] str = {"HCL","Wipro","Aspire Systems","CTS"};

		List<String> str1= new ArrayList<String>();
		for (String string : str) {
			str1.add(string);
		}
		System.out.println(str1);
		Collections.sort(str1);
		System.out.println(str1);
		
	}

}

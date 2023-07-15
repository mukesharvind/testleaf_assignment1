package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbersInArrayUsingSet {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5,7,8};
		
		Set<Integer> number = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
		
		number.add(arr[i]);
	}
	System.out.println(number);
	
	//converting set to list to get size
	
		List<Integer>missingelement = new ArrayList<Integer>(number);
//		for (Integer integer : number) {
//
//		
//	}

	
	for (int j = 0; j < missingelement.size(); j++) {
		
	if (missingelement.get(j)!=j+1) {
		
		System.out.println("The missing element is " +(j+1));
	break;
	}	
	}
	}	
}

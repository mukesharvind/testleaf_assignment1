package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindTheLargestSecondNumber {
	
	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		int legnthofthearray = data.length;
		Set<Integer> number = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			number.add(data[i]);
			//System.out.print(number);
			
		}
		//System.out.print(number);
		List<Integer> numlist = new ArrayList<Integer>(number);
		System.out.println(numlist);
		
		Integer integer = numlist.size();
		System.out.println(integer);
		
		System.out.println("The second largest number is " +numlist.get(numlist.size()-2));
		
		//int size = numlist.size()-2;
		
		
		
		
	}

}

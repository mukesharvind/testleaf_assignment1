package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
	String text = "We learn java basics as part of java sessions in java week1";
	
	String[] split = text.split(" ");
	String string = Arrays.toString(split);
	
//	System.out.println(string);
//	int length = string.length();
//	System.out.println(length);
	
	List<String> arr = new ArrayList<String>();
	
	for (String string2 : split) {
		arr.add(string2);
	}
	System.out.println(arr);

	Set<String>duplicate = new TreeSet<String>(arr);
		boolean addAll = duplicate.addAll(arr);
		System.out.println(duplicate);
		
}
	
	
}

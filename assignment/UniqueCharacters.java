package week3.day2.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

	public static void main(String[] args) {
		
		String str = "MukeshArvindh";
//		String[] split = str.split("");
//		String stringtoarray = Arrays.toString(split);
//		System.out.println(stringtoarray);
		
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		
		Set<Character> name = new HashSet<Character>();
//		for (int i = 0; i < charArray.length; i++) {
//			name.add(charArray[i]);
//		}
		for (Character newname : charArray) {
			name.add(newname);
		}
		System.out.println(name);
	}

}

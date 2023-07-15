package week3.day2.assignments;

import java.util.Iterator;

public class ReverseEvenWords {
 
	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] split = test.split(" ");
		for (int i = 0; i <= split.length-1; i++) //to sort even number 
			{
			
			if (i%2!=0) {
				
				char[] charArray = split[i].toCharArray();
				for (int j = charArray.length-1; j >= 0; j--) {
				System.out.print(charArray[j]);
			}
							
			               	
				}
			else {
				System.out.print(" "+split[i]+" ");//
			}
		}

	}

}

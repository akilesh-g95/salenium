package FiledTrackingApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array");
		String arr = sc.nextLine();
		
		char[] ch = arr.toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : ch) {
			
			 if(map.containsKey(c)) {
				 
				 map.put(c, map.get(c)+1);
				 
			 }else {
				 map.put(c, 1);
			 }
		}
		for(Character c : map.keySet()) {
			if(map.get(c)>1) {
				System.out.println("character "+c+"  is repaeated "+ map.get(c) + " Times");
			}
			
		}
	}

}

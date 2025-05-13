package FiledTrackingApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class charcaterfrequencycount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the charachters  : ");
		String str1 = sc.nextLine();

		char[] ch = str1.toCharArray();
		
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		
		for (char c : ch) {
			
			if (m.containsKey(c)) {
			    m.put(c, m.get(c) + 1);
			} else {
			    m.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
	
	}

}

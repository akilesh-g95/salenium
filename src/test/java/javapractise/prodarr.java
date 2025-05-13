package javapractise;

import java.util.Arrays;

public class prodarr {

	public static void main(String[] args) {

		int []a = {1,2,3,4};
		int []b = new int [a.length];
		
		for(int i=0; i<a.length; i++) {
			int prod =1;
			for(int j=0; j<a.length; j++) {
 				if(i==j) {
					continue;
				}else{
					prod = prod*a[j];
				}
			}
			b[i]=prod;
			System.out.println(prod);
		}
		 System.out.println(Arrays.toString(b));
		
	
	
	
	
	}	
}

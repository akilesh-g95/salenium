package javapractise;

public class maxvalue {

	public static void main(String[] args) {
		int []a= {20, 30,40,50};
		int max= a[0];
		
		for(int i=1; i<a.length; i++) {
			if(a[i]>max) {
				max= a[i];
			}
			
		}
		System.out.println(max);
	}

}

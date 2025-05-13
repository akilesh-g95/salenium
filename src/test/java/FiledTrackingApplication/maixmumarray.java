package FiledTrackingApplication;

public class maixmumarray {

	public static void main(String[] args) {

	int number[] = {10, 25, 34, 21};
	
	int max = number[0];
	
	for (int i=1; i<number.length; i++) {
		
		if(number[i]>max) {
		max = number[i];
	}
		
	}
	System.out.println("Maximum value of the array is  "+max);
	}

}

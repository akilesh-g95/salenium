package FiledTrackingApplication;

public class stringint {

	public static void main(String[] args) {

		int num[] = {1, -1, 2, -2}; 
		int target = -1;
		
		for(int i=0; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				for(int k=j+1; k<num.length; k++ ) {
					if(num[i]+num[j]+num[k]==target) {
						System.out.println(num[i]+" "+num[j]+" "+num[k]+" ");
					}
				}
			}
		}
	}

}

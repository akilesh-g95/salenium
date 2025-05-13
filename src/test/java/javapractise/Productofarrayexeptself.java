package javapractise;

public class Productofarrayexeptself {

	public static int[] productofarrayself(int[] nums) {
		int n = nums.length;

		int answer[] = new int[n];

		answer[0] = 1;
		for (int i = 1; i < n; i++) {

			answer[i] = nums[i - 1] * answer[i - 1];
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			answer[i] = answer[i] * right;
			right = right * nums[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] nums = { 4,5,6 };

		int[] result = productofarrayself(nums);
		System.out.println("Product of array except self");

		for (int val : result) {
			System.out.println("val is  -->" + val);
		}

	}

}

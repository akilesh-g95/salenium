package javapractise;

import java.util.Arrays;
import java.util.Scanner;

public class reverseString1 {

	public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] output = new int[n];

        // Step 1: Fill left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Step 2: Fill right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Step 3: Build output array
        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        // Print the output array
        System.out.println(Arrays.toString(output));
    }

}

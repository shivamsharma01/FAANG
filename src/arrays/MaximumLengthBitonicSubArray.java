package arrays;

/*
 * https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 * N = 6
 * Arr[] = {12, 4, 78, 90, 45, 23}
 * Output: 5
 * Explanation: In the given array, 
 * bitonic subarray is 4 <= 78 <= 90
 * >= 45 >= 23.
 */
public class MaximumLengthBitonicSubArray {

	int bitonic(int[] arr, int n) {
		int[] left = new int[n];
		left[0] = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] <= arr[i])
				left[i] = left[i - 1] + 1;
			else
				left[i] = 1;
		}
		int right = 1, max = left[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= arr[i + 1]) {
				max = Math.max(max, left[i] + right);
				right++;
			} else {
				max = Math.max(max, left[i]);
				right = 1;
			}
		}
		return max;
	}
}

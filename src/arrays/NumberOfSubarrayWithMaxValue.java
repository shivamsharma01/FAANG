package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
 */
public class NumberOfSubarrayWithMaxValue {
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 0, 11, 3, 0 }; // {2}, {2, 0}, {3}, {3, 0} == 4
		String input = Arrays.toString(arr);
		int L = 1, R = 10;
		long noSubarrays = maxNum(arr, arr.length, L, R);
		System.out.println(
				"Number of subarrays in " + input + " with sum between [" + L + "," + R + "] = " + noSubarrays);
	}

	private static long maxNum(int[] arr, int length, int L, int R) {
		long sum = 0, exc = 0, inc = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] > R) {
				sum += countSubArrays(inc) - countSubArrays(exc);
				inc = 0;
				exc = 0;
			} else if (arr[i] < L) {
				inc++;
				exc++;
			} else {
				sum -= countSubArrays(exc);
				exc = 0;
				inc++;
			}
		}
		return sum + (countSubArrays(inc) - countSubArrays(exc));
	}

	private static long countSubArrays(long n) {
		return n * (n + 1) / 2;
	}

}

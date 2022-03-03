package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 */
public class MinMergeToMakePalindrome {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 4, 5, 9, 1 }; // {1, 9, 9, 1}
		String input = Arrays.toString(arr);
		int minOp = findMinOps(arr, arr.length);
		System.out.println("MinOp to make " + input + " a palindrome = " + minOp);
	}

	static int findMinOps(int[] arr, int n) {
		int ans = 0, left = 0, right = n - 1;

		while (left < right) {
			if (arr[left] == arr[right]) {
				left++;
				right--;
			} else if (arr[left] < arr[right]) {
				left++;
				arr[left] += arr[left - 1];
				ans++;
			} else {
				right--;
				arr[right] += arr[right + 1];
				ans++;
			}
		}
		return ans;
	}
}

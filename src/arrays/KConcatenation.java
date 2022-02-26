package arrays;

import java.util.Scanner;

/*
 * https://www.codechef.com/JAN18/problems/KCON/
 * 
*/
public class KConcatenation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), n, k;
		int[] arr;
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			getKSum(arr, k);
		}
	}

	private static void getKSum(int[] arr, int k) {
		int n = arr.length;
		if (k == 1) {
			// Kadane's on a single array
			long maxSum = Long.MIN_VALUE, curSum = 0;
			for (int ele : arr) {
				curSum += ele;
				maxSum = Math.max(maxSum, curSum);
				curSum = Math.max(curSum, 0);
			}
			System.out.println(curSum);
		} else {
			// Kadane's on any length > 1
			long maxSum = Long.MIN_VALUE, curSum = 0, totalSum = 0;
			for (int i = 0; i < 2 * n; i++) {
				int ele = arr[i % n];
				curSum += ele;
				maxSum = Math.max(maxSum, curSum);
				curSum = Math.max(curSum, 0);
				if (i < n)
					totalSum += ele;
			}
			if (totalSum >= 0)
				System.out.println(maxSum + (k - 2) * totalSum);
			else
				System.out.println(maxSum);
		}
	}
}

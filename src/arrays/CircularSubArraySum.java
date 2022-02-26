package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 * 
 * 22
 * 20 28 2 6 18 12 -28 3 -3 -26 1 6 6 -27 -6 -7 28 -26 13 30 -5 -6
 * #120
 * 
 * 8
 * 10 -3 -4 7 6 5 -4 -1
 * #23
 */
public class CircularSubArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println(maximumCircularSubArraySum(arr, n));
	}

	private static long maximumCircularSubArraySum(int[] arr, int n) {
		if (n == 1)
			return arr[0];
		long sum = Arrays.stream(arr).asLongStream().sum();
		long maxSum = arr[0], curMaxSum = arr[0], minSum = arr[0], curMinSum = arr[0];
		for (int i = 1; i < n; i++) {
			curMaxSum = Math.max(curMaxSum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, curMaxSum);
			curMinSum = Math.min(curMinSum + arr[i], arr[i]);
			minSum = Math.min(minSum, curMinSum);
		}
		return minSum == sum ? maxSum : Math.max(maxSum, sum - minSum);
	}
}

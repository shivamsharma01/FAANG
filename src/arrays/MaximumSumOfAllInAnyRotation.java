package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
 */
public class MaximumSumOfAllInAnyRotation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaximumSumOfAllInAnyRotation.txt"))));
		int q = Integer.parseInt(read.readLine());
		while (q-- > 0) {
			int n = Integer.parseInt(read.readLine());
			int[] arr = new int[n];
			String[] data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			findMaxSum(arr, arr.length);
		}
	}

	private static void findMaxSum(int[] arr, int n) {
		long sum = Arrays.stream(arr).sum(), maxSum;
		long formulaSum = 0;
		for (int i = 0; i < n; i++) {
			formulaSum += (i * arr[i]);
		}
		maxSum = formulaSum;
		for (int i = 1; i < n; i++) {
			formulaSum = formulaSum - (sum - arr[i - 1]) + arr[i - 1] * (n - 1);
			maxSum = Math.max(formulaSum, maxSum);
		}
		System.out.println(maxSum);
	}
}

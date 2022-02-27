package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class PairInSortedAndRotated {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/PairInSortedAndRotated.txt"))));
		int q = Integer.parseInt(read.readLine());
		while (q-- > 0) {
			int n = Integer.parseInt(read.readLine());
			int[] arr = new int[n];
			String[] data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			int sum = Integer.parseInt(read.readLine());
			findPair(arr, arr.length - 1, sum);
		}
	}

	private static void findPair(int[] arr, int n, int sum) {
		int start = -1, end = n - 1, curSum;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (min > arr[i]) {
				min = arr[i];
				start = i;
			}
		}
		end = start - 1;
		if (end < 0)
			end += n;
		while (end != start) {
			curSum = arr[start] + arr[end];
			if (curSum == sum) {
				System.out.println("There is a pair (" + arr[start] + ", " + arr[end] + ") with sum " + sum);
				return;
			}
			if (curSum < sum) {
				start++;
			} else {
				end--;
			}
			start %= n;
			if (end < 0)
				end += n;
		}
		System.out.println("There is no such pair that sum up to " + sum);
	}

}

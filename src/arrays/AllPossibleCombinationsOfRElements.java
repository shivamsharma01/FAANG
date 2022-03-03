package arrays;

import java.io.IOException;
import java.util.Arrays;

/*
 * geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class AllPossibleCombinationsOfRElements {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = { 1, 2, 4, 3, 2 };
		int r = 2;
		printUtils(arr, arr.length, r);
	}

	private static void printUtils(int[] arr, int length, int r) {
		Arrays.sort(arr);
		print(arr, new int[r], length, r, 0, 0);
	}

	private static void print(int[] arr, int[] data, int n, int r, int i, int ri) {
		if (ri == r) {
			System.out.println(Arrays.toString(data));
			return;
		}
		if (i == n)
			return;
		data[ri] = arr[i];
		print(arr, data, n, r, i + 1, ri + 1);
		while (i != n - 1 && arr[i] == arr[i + 1])
			i++;
		print(arr, data, n, r, i + 1, ri);
	}

}

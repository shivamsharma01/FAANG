package searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/sort-array-according-count-set-bits/
 */
public class SortArrayAccordingToCountBitSet {
	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		countBitSet(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int countBits(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1)
				count++;
			num >>= 1;
		}
		return count;
	}

	private static void countBitSet(int[] arr) {
		ArrayList<Integer>[] bitList = new ArrayList[32];
		for (int i = 0; i < 32; i++)
			bitList[i] = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int bits = countBits(arr[i]);
			bitList[bits].add(arr[i]);
		}
		int idx = 0;
		for (int i = 31; i >= 0; i--) {
			for (Integer elem : bitList[i]) {
				arr[idx++] = elem;
			}
		}
	}
}

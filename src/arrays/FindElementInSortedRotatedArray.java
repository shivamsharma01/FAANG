package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class FindElementInSortedRotatedArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/FindElementInSortedRotatedArray.txt"))));
		int q = Integer.parseInt(read.readLine());
		while (q-- > 0) {
			int n = Integer.parseInt(read.readLine());
			int[] arr = new int[n];
			String[] data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			int key = Integer.parseInt(read.readLine());
			int i = findElement(arr, 0, arr.length - 1, key);
			System.out.println(i);
		}
	}

	private static int findElement(int[] A, int l, int h, int key) {
		if (A.length == 1) {
			return A[0] == key ? 0 : -1;
		}
		int mid;
		while (l < h) {
			mid = l + (h - l) / 2;
			if (A[mid] == key)
				return mid;
			if (A[h] == key)
				return h;
			if (A[l] == key)
				return l;
			if (key < A[l]) {
				if (key < A[mid]) {
					if (A[mid] > A[l])
						l = mid + 1;
					else
						h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (key < A[mid]) {
					h = mid - 1;
				} else {
					if (A[mid] < A[l])
						h = mid - 1;
					else
						l = mid + 1;
				}
			}
		}
		return -1;
	}

}

package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/counting-inversions/
 */
public class CountInversions {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/CountInversions.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		long fileAnswer, codeAnswer;
		long[] arr;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			arr = new long[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			fileAnswer = Long.parseLong(read.readLine());
			codeAnswer = inversionCount(arr, n);
			System.out.println(Arrays.toString(arr) + " --> " + fileAnswer);
			if (fileAnswer != codeAnswer) {
				System.out.println(String.format("Your Answer is %d", codeAnswer));
			}
			System.out.println("\n");
		}
		read.close();
	}

	static long inversionCount(long arr[], long N) {
		return mergeSort(arr, 0, (int) (N - 1));
	}

	static long mergeSort(long[] arr, int i, int j) {
		if (i < j) {
			int mid = i + (j - i) / 2;
			long leftInversions = mergeSort(arr, i, mid);
			long rightInversions = mergeSort(arr, mid + 1, j);
			return merge(arr, i, mid, j) + leftInversions + rightInversions;
		}
		return 0;
	}

	static long merge(long[] arr, int start, int mid, int end) {
		long[] left = new long[mid - start + 1], right = new long[end - mid];
		for (int i = 0; i < left.length; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < right.length; i++)
			right[i] = arr[mid + i + 1];
		int i = start, i1 = 0, i2 = 0;
		long countInversions = 0;
		while (i1 != left.length && i2 != right.length) {
			if (left[i1] <= right[i2])
				arr[i++] = left[i1++];
			else {
				countInversions += (left.length - i1);
				arr[i++] = right[i2++];
			}
		}
		while (i1 != left.length)
			arr[i++] = left[i1++];
		while (i2 != right.length)
			arr[i++] = right[i2++];
		return countInversions;
	}
}

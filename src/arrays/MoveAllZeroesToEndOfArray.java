package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1/
 */
public class MoveAllZeroesToEndOfArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MoveAllZeroesToEndOfArray.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			data = read.readLine().split(" ");
			n = Integer.parseInt(data[0]);
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			System.out.println(Arrays.toString(arr));
			pushZerosToEnd(arr, n);
			System.out.println(Arrays.toString(arr));
			System.out.println("\n");
		}
		read.close();
	}

	static void pushZerosToEnd(int[] arr, int n) {
		int i = 0, idx = 0;
		while (i < n) {
			if (arr[i] != 0)
				arr[idx++] = arr[i];
			i++;
		}
		while (idx < n)
			arr[idx++] = 0;
	}

}

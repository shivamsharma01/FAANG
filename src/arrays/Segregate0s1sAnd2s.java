package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class Segregate0s1sAnd2s {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/Segregate0s1sAnd2s.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			System.out.println(Arrays.toString(arr));
			segregate012(arr, n);
			System.out.println(Arrays.toString(arr));
			System.out.println("\n");
		}
		read.close();
	}

	private static void segregate012(int[] arr, int n) {
		int idx = 0, i = 0;
		while (i < n) {
			if (arr[i] == 0) {
				arr[i] = arr[idx];
				arr[idx++] = 0;
			}
			i++;
		}
		i = idx = n - 1;
		while (i >= 0 && arr[i] != 0) {
			if (arr[i] == 2) {
				arr[i] = arr[idx];
				arr[idx--] = 2;
			}
			i--;
		}
	}
}

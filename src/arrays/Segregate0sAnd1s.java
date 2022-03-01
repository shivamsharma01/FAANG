package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 */
public class Segregate0sAnd1s {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/Segregate0sAnd1s.txt"))));
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
			segregate(arr, n);
			System.out.println(Arrays.toString(arr));
			System.out.println("\n");
		}
		read.close();
	}

	private static void segregate(int[] arr, int n) {
		int left = 0, right = n - 1, temp;
		while (left < right) {
			if (arr[left] == 1) {
				temp = right;
				while (temp != left) {
					if (arr[temp] == 0)
						break;
					temp--;
				}
				if (temp == left)
					break;
				right = temp - 1;
				arr[left] = 0;
				arr[temp] = 1;
			}
			left++;
		}
	}
}

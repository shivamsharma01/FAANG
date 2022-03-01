package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 */
public class MinimizeTheMaxDifferenceBetweenHeights {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("src/arrays/MinimizeTheMaxDifferenceBetweenHeights.txt"))));
		int q = Integer.parseInt(read.readLine()), n, k, fileOutput;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			k = Integer.parseInt(read.readLine());
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			fileOutput = Integer.parseInt(read.readLine());
			System.out.println(k + " " + Arrays.toString(arr) + " -> " + fileOutput);
			int ans = getMinDiff(arr, n, k);
			if (ans != fileOutput)
				System.out.println("Incorrect output -> " + ans);
			System.out.println("\n");
		}
		read.close();
	}

	static int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int ans = arr[n - 1] - arr[0], left = arr[0] + k, right = arr[n - 1] - k;
		int min, max;
		System.out.println("smallest is " + arr[0] + ", largest is " + arr[n - 1]);
		System.out.println("ans at start is " + ans);
		for (int i = 1; i < n; i++) {
			min = Math.min(left, arr[i] - k);
			System.out.println(
					"min(left: " + left + ", arr[" + i + "] - " + k + " = " + arr[i] + " - " + k + ") = " + min);
			max = Math.max(arr[i - 1] + k, right);
			System.out.println("max(arr[" + (i - 1) + "] +" + k + ", right :" + right + ")");
			System.out.println(String.format("min(%d, %d)", ans, max - min));
			ans = Math.min(ans, max - min);
		}
		return ans;
	}
}

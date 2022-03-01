package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
 */
public class MinSwapsToBringAllEleTillKTogether {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("src/arrays/MinSwapsToBringAllEleTillKTogether.txt"))));
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
			System.out.println("k -> " + k + " " + Arrays.toString(arr) + " -> " + fileOutput);
			int ans = minSwap(arr, n, k);
			if (ans != fileOutput)
				System.out.println("Incorrect output -> " + ans);
			System.out.println("\n");
		}
		read.close();
	}

	public static int minSwap(int arr[], int n, int k) {
		int count = 0, bad = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= k)
				count++;
		}
		for (int i = 0; i < count; i++) {
			if (arr[i] > k)
				bad++;
		}
		int ans = bad;
		for (int i = 0, j = count; j < n; i++, j++) {
			if (arr[i] > k)
				bad--;
			if (arr[j] > k)
				bad++;
			ans = Math.min(ans, bad);
		}
		return ans;

	}
}

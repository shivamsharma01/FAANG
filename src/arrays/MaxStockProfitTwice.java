package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 */
public class MaxStockProfitTwice {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaxStockProfitTwice.txt"))));
		int q = Integer.parseInt(read.readLine()), n, fileOutput, ans;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			fileOutput = Integer.parseInt(read.readLine());
			System.out.println(Arrays.toString(arr));
			ans = getMaxProfit(arr, n);
			if (ans != fileOutput)
				System.out.println("Incorrect output " + ans);
			System.out.println("\n");
		}
		read.close();
	}

	private static int getMaxProfit(int[] arr, int n) {
		if (n <= 1)
			return 0;
		int[] maxProfit = new int[n];
		int min = arr[0];
		maxProfit[0] = 0;
		for (int i = 1; i < n; i++) {
			min = Math.min(min, arr[i]);
			maxProfit[i] = Math.max(arr[i] - min, maxProfit[i - 1]);
		}
		int max = maxProfit[n - 1], maxRight = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			max = Math.max(max, maxProfit[i] + maxRight - arr[i]);
			maxProfit[i] = Math.max(maxProfit[i + 1], maxRight - arr[i]);
			maxRight = Math.max(maxRight, arr[i]);
		}
		return max;
	}
}

package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * https://www.youtube.com/watch?v=oDhu5uGq_ic&ab_channel=TusharRoy-CodingMadeSimple
 */
public class MaxStockTwiceSellKTimes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaxStockTwiceSellKTimes.txt"))));
		int q = Integer.parseInt(read.readLine()), n, k, ans, profit;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			data = read.readLine().split(" ");
			n = Integer.parseInt(data[0]);
			k = Integer.parseInt(data[1]);
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			ans = Integer.parseInt(read.readLine());
			System.out.println(Arrays.toString(arr) + " -> " + ans);
			profit = maxProfit(k, n, arr);
			if (profit != ans)
				System.out.println("incorrect output -> " + profit);
			System.out.println("\n");
		}
		read.close();
	}

	/*
	 * 
	 */
	static int maxProfit(int K, int N, int A[]) {
		int[][] dp = new int[K + 1][N];
		int prevDiff;
		for (int i = 1; i <= K; i++) {
			prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < N; j++) {
				prevDiff = Math.max(prevDiff, dp[i - 1][j - 1] - A[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prevDiff + A[j]);
			}
		}
		return dp[K][N - 1];
	}
}

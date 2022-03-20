package strings;

/*
 * https://www.geeksforgeeks.org/count-binary-strings-k-times-appearing-adjacent-two-set-bits/
 */
public class CountBinaryStringsWithKAdjacent1 {
	public static void main(String[] args) {
		System.out.println(count(3, 0));
		System.out.println(count(3, 1));
		System.out.println(count(3, 2));
		System.out.println(count(5, 2));
		System.out.println(count(4, 1));
		System.out.println(count(185, 73));
	}

	private static int count(int n, int k) {
		int[][][] dp = new int[n + 1][k + 1][2];
		final int mod = 1000000000 + 7;
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i && j <= k; j++) {
				dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;

				dp[i][j][1] = dp[i - 1][j][0];
				if (j > 0)
					dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % mod;
			}
			System.out.println("==================");
		}

		return (dp[n][k][0] + dp[n][k][1]) % mod;
	}

}

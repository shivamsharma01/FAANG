package strings;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/count-distinct-subsequences/
 */
public class CountDistinctSubsequences {
	public static void main(String[] args) {
		System.out.println(distinctSubsequences("aaba"));
	}

	static int distinctSubsequences(String s) {
		final int n = s.length(), MOD = (int) (1e9 + 7);

		int[] dp = new int[n + 1];
		dp[0] = 1;
		int[] charIndex = new int[256];
		Arrays.fill(charIndex, -1);

		for (int i = 1; i <= n; i++) {
			dp[i] = (2 * dp[i - 1]) % MOD;

			if (charIndex[s.charAt(i - 1)] != -1)
				dp[i] = (dp[i] - dp[charIndex[s.charAt(i - 1)]] + MOD) % MOD;

			charIndex[s.charAt(i - 1)] = i - 1;
		}

		return dp[n];
	}
}

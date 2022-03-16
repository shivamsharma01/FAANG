package strings;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/
 */
public class DistinctCharacters {
	public static void main(String[] args) {
		int[] ans = new DistinctCharacters().SolveQueris("abcbaed", new int[][] { { 1, 4 }, { 2, 4 }, { 1, 7 } });
		System.out.println(Arrays.toString(ans));
	}

	public int[] SolveQueris(String str, int[][] Query) {
		int n = str.length();
		int[][] dp = new int[n][26];
		dp[0][str.charAt(0) - 'a'] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 26; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			dp[i][str.charAt(i) - 'a']++;
		}
		int[] out = new int[Query.length];
		n = 0;
		for (int[] q : Query) {
			int start = q[0] - 1, end = q[1] - 1, count = 0;
			int[] dp1 = dp[start], dp2 = dp[end];
			for (int i = 0; i < 26; i++) {
				if (dp2[i] - dp1[i] != 0 || i == str.charAt(start) - 'a') {
					count++;
				}
			}
			out[n++] = count;
		}
		return out;
	}

}

package strings;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 */
public class SmallestCommonSuperSequence {
	public static void main(String[] args) {
		String s1 = "AGGTAB", s2 = "GXTXAYB";// AGXGTXAYB
		printSmallestCommonSuperSequence(s1, s2);
		s1 = "HELLO";
		s2 = "GEEK";
		printSmallestCommonSuperSequence(s1, s2);
	}

	private static void printSmallestCommonSuperSequence(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		lcs(s1, s2, dp);
		System.out.println("Largest Common Subsequence -> ");
		String superSequence = getSuperSequence(s1, s2, dp);
		System.out.println("Smallest Common Supersequence -> " + superSequence);
	}

	private static String getSuperSequence(String s1, String s2, int[][] dp) {
		int n1 = s1.length(), n2 = s2.length();
		StringBuilder sb = new StringBuilder("");

		for (int[] row : dp)
			System.out.println(Arrays.toString(row));
		System.out.println();
		while (n1 > 0 && n2 > 0) {
			if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
				n1--;
				n2--;
				sb.append(s1.charAt(n1));
			} else if (dp[n1 - 1][n2] > dp[n1][n2 - 1])
				sb.append(s1.charAt(--n1));
			else
				sb.append(s2.charAt(--n2));
		}

		while (n1 > 0)
			sb.append(s1.charAt(--n1));

		while (n2 > 0)
			sb.append(s2.charAt(--n2));

		return sb.reverse().toString();
	}

	public static void lcs(String s1, String s2, int[][] dp) {
		int n1 = s1.length(), n2 = s2.length();
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
}

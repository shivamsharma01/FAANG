package strings;

/*
 * https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 */
public class FindNumberDistinctPalindromicSubstrings {
	public static void main(String[] args) {
		System.out.println(palindromeSubStrs("aabaa"));
		System.out.println(palindromeSubStrs("aaabaaa11211"));
		System.out.println(palindromeSubStrs("bbabb"));
	}

	static int palindromeSubStrs(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			if (i < n - 1)
				dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i + len <= n; i++) {
				dp[i][i + len - 1] = dp[i + 1][i + len - 2] && (s.charAt(i) == s.charAt(i + len - 1));
			}
		}

		int[] kmp = new int[n];
		for (int i = 0; i < n; i++) {
			int j = 0, k = 1;
			while (i + k < n) {
				if (s.charAt(i + j) == s.charAt(i + k)) {
					dp[i + k - j][i + k] = false;
					kmp[k++] = ++j;
				} else if (j > 0) {
					j = kmp[j - 1];
				} else {
					kmp[k++] = 0;
				}
			}
		}
		return count(dp);
	}

	static private int count(boolean[][] dp) {
		int n = dp.length, count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (dp[i][j])
					count++;
			}
		}
		return count;
	}
}

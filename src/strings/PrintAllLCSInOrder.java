package strings;

/*
 * https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
 */
public class PrintAllLCSInOrder {
	static int[][] dp;
	static int len;

	public static void main(String[] args) {
		String s1 = "acbacba", s2 = "abcabcaa";
		len = lcsCompute(s1, s2);
		char[] data = new char[len];
		printAll(s1, s2, s1.length(), s2.length(), data, 0, 0, 0);
	}

	private static void printAll(String s1, String s2, int n1, int n2, char[] data, int i1, int i2, int lenCovered) {
		if (lenCovered == len) {
			System.out.println(new String(data));
			return;
		}
		if (i1 == n1 || i2 == n2)
			return;

		for (char ch = 'a'; ch <= 'z'; ch++) {
			outer: for (int i = i1; i < n1; i++) {
				if (ch == s1.charAt(i)) {
					for (int j = i2; j < n2; j++) {
						if (ch == s2.charAt(j) && dp[i][j] == len - lenCovered) {
							data[lenCovered] = ch;
							printAll(s1, s2, n1, n2, data, i + 1, j + 1, lenCovered + 1);
							break outer; // if we don't break, we do unnecessary computations and might also print
											// duplicates
						}
					}
				}
			}
		}
	}

	private static int lcsCompute(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		dp = new int[n1 + 1][n2 + 1];

		// we have filled from end to start so that we can check condition
		// dp[i][j] == len - lenCovered
		// while printing
		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j))
					dp[i][j] = dp[i + 1][j + 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		return dp[0][0];
	}

}

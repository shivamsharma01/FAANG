package strings;

/*
 * https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
 */
public class NumTimesStringOccursAsASubsequence {
	public static void main(String[] args) {
		System.out.println(numTimes("GeeksforGeeks", "Gks"));
		System.out.println(numTimes("ababa", "aa"));
	}

	private static int numTimes(String s1, String s2) {
		return count(s1, s2, s1.length(), s2.length(), 0, 0);
	}

	private static int count(String s1, String s2, int n1, int n2, int i1, int i2) {
		if (i2 == n2)
			return 1;
		if (i1 == n1)
			return 0;
		int ans = 0;
		for (int i = i1; i < n1; i++) {
			if (s1.charAt(i) == s2.charAt(i2))
				ans += count(s1, s2, n1, n2, i + 1, i2 + 1);
		}
		return ans;
	}
}

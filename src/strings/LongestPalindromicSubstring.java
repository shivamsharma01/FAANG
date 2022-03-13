package strings;

/*
 * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalin("aaaabbaa"));
		System.out.println(longestPalin("abc"));
	}

	static String longestPalin(String S) {
		int n = S.length();
		if (n == 1)
			return S.substring(0, 1);
		String ans = "";
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + ans.length(); j < n; j++) {
				if (isPalindrome(S, i, j)) {
					ans = S.substring(i, j + 1);
				}
			}
		}

		return ans;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}

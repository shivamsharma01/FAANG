package strings;

/*
 * https://www.geeksforgeeks.org/longest-non-palindromic-substring/
 */
public class LongestNonPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestNonPalindromicString("abba"));
		System.out.println(longestNonPalindromicString("a"));
		System.out.println(longestNonPalindromicString("aa"));
		System.out.println(longestNonPalindromicString("aab"));
		System.out.println(longestNonPalindromicString("aabb"));
		System.out.println(longestNonPalindromicString("ababa"));
	}

	private static int longestNonPalindromicString(String s) {
		int longest = 0, n = s.length();
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i + longest; j--) {
				if (!isPalindrome(s, i, j)) {
					longest = j - i + 1;
					break;
				}
			}
		}
		return longest;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}

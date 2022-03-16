package strings;

/*
 * https://www.geeksforgeeks.org/make-largest-palindrome-changing-k-digits/
 */
public class LargestPalindromeChangeMaxK {
	public static void main(String[] args) {
		largestPalindrome("43435", 3);
		largestPalindrome("43435", 1);
		largestPalindrome("12345", 1);
		largestPalindrome("43435", 4);
		largestPalindrome("44", 2);
		largestPalindrome("1835482", 4);
	}

	static void largestPalindrome(String s, int k) {
		int n = s.length(), count = 0;
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				count++;
		}
		if (count > k) {
			System.out.println("Not Possible");
			return;
		}
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				if (k > count) {
					count--;
					if (s.charAt(i) == '9' || s.charAt(j) == '9')
						k--;
					else
						k -= 2;
					sb.setCharAt(i, '9');
					sb.setCharAt(j, '9');
				} else {
					if (s.charAt(i) > s.charAt(j)) {
						sb.setCharAt(j, s.charAt(i));
					} else {
						sb.setCharAt(i, s.charAt(j));
					}
					k--;
					count--;
				}
			} else {
				if (k - count >= 2) {
					sb.setCharAt(i, '9');
					sb.setCharAt(j, '9');
					k -= 2;
				}
			}
		}
		if ((n & 1) == 1 && k != 0) {
			sb.setCharAt(n / 2, '9');
		}
		System.out.println(sb);
	}
}

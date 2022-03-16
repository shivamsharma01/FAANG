package strings;

/*
 * https://www.geeksforgeeks.org/count-words-whose-th-letter-either-1-th-th-i1-th-letter-given-word/
 */
public class CountOfWordsFormedUsingCurrentOfAdjacentLetters {
	public static void main(String[] args) {
		System.out.println(count("a"));
		System.out.println(count("aa"));
		System.out.println(count("ab"));
		System.out.println(count("abb"));
		System.out.println(count("abc"));
	}

	private static long count(String s) {
		int n = s.length();
		if (n <= 1)
			return n;

		if (n == 2)
			if (s.charAt(0) == s.charAt(1))
				return 1;
			else
				return 4;

		long ans = 0;
		if (s.charAt(0) == s.charAt(1))
			ans = 1;
		else
			ans = 2;

		for (int i = 1; i < n - 1; i++)
			ans *= countUnique(s.charAt(i - 1), s.charAt(i), s.charAt(i + 1));

		if (s.charAt(n - 2) != s.charAt(n - 1))
			ans *= 2;
		return ans;
	}

	private static int countUnique(char a, char b, char c) {
		if (a == b) {
			if (a == c)
				return 1;
			return 2;
		} else {
			if (a == c || b == c)
				return 2;
			else
				return 3;
		}
	}
}

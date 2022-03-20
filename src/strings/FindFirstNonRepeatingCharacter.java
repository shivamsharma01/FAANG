package strings;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */
public class FindFirstNonRepeatingCharacter {
	public static void main(String[] args) {
		findFirst("GeeksforGeeks");
		findFirst("GeeksQuiz");
	}

	private static void findFirst(String s) {
		int[] charArr = new int[256];
		int n = s.length();
		Arrays.fill(charArr, -n);
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (charArr[c] == -n)
				charArr[c] = i;
			else
				charArr[c] = -i;
		}
		int ans = n;
		for (int i = 0; i < 256; i++) {
			if (charArr[i] >= 0 && charArr[i] < ans)
				ans = charArr[i];
		}
		if (ans != n)
			System.out.println(s.charAt(ans));
		else
			System.out.println("No Non-repeating character");
	}
}

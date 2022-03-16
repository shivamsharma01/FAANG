package strings;

/*
 * https://www.geeksforgeeks.org/lexicographically-first-palindromic-string/
 */
public class SmallestPalindromicString {
	public static void main(String[] args) {
		smallestPalindrome("malayalam");
		smallestPalindrome("apple");
	}

	public static void smallestPalindrome(String s) {
		int[] arr = new int[26];

		int n = s.length();
		for (int i = 0; i < n; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		int idx = -1, odd = -1, j;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				if (odd == -1) {
					odd = arr[i];
					idx = i;
					arr[i] = 0;
				} else {
					System.out.println("Not Possible");
					return;
				}
			}
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			if (arr[i] == 0)
				continue;
			char c = (char) ('a' + i);
			j = arr[i] / 2;
			while (arr[i] > j) {
				sb.append(c);
				arr[i]--;
			}
		}
		if (idx != -1) {
			char c = (char) (idx + 'a');
			while (odd != 0) {
				sb.append(c);
				odd--;
			}
		}
		for (int i = 25; i >= 0; i--) {
			if (arr[i] == 0)
				continue;
			char c = (char) ('a' + i);
			while (arr[i] != 0) {
				sb.append(c);
				arr[i]--;
			}
		}
		System.out.println(sb.toString());
	}
}

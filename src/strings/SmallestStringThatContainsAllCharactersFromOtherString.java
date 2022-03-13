package strings;

/*
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 */
public class SmallestStringThatContainsAllCharactersFromOtherString {
	public static void main(String[] args) {
		System.out.println(smallestWindow("timetopractice", "toc"));
	}

	public static String smallestWindow(String s, String p) {
		int n1 = s.length(), n2 = p.length();
		if (n1 < n2) {
			return "-1";
		}
		int[] count = new int[26], other = new int[26];
		for (char c : p.toCharArray()) {
			count[c - 'a']++;
		}
		int startIndex = -1, start = 0, win = n1, idx;
		for (int i = 0; i < n1; i++) {
			char c = s.charAt(i);
			other[c - 'a']++;
			if (other[c - 'a'] >= count[c - 'a'] && allHigh(count, other)) {
				idx = s.charAt(start++) - 'a';
				while (other[idx] > count[idx]) {
					other[idx]--;
					idx = s.charAt(start++) - 'a';
				}
				start--;
				int win_len = i - start + 1;
				if (win_len < win) {
					win = win_len;
					startIndex = start;
				}
			}
		}
		return startIndex == -1 ? "-1" : s.substring(startIndex, startIndex + win);
	}

	private static boolean allHigh(int[] count, int[] other) {
		for (int i = 0; i < 26; i++) {
			if (count[i] > other[i])
				return false;
		}
		return true;
	}

}

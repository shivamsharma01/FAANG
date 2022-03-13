package strings;

/*
 * Smallest window that contains all characters of string itself
 */
public class SmallestWindowThatContainsAll {
	public static void main(String[] args) {
		System.out.println(smallestWindow("babac"));
		System.out.println(smallestWindow("blacla"));
		System.out.println(smallestWindow("aabcbcdbca"));
	}

	private static String smallestWindow(String input) {
		if (input.length() <= 1)
			return input;

		int minWindow = input.length(), start = 0, startIndex = -1, unique = 0, uCount = 0, windowLen;

		boolean[] visited = new boolean[256];
		int[] lookup = new int[256];

		for (char c : input.toCharArray()) {
			if (!visited[c]) {
				unique++;
				visited[c] = true;
			}
		}
		for (int i = 0; i < input.length(); i++) {
			lookup[input.charAt(i)]++;

			if (lookup[input.charAt(i)] == 1)
				uCount++;

			if (uCount == unique) {
				while (lookup[input.charAt(start)] > 1) {
					lookup[input.charAt(start++)]--;
				}
				windowLen = i - start + 1;
				if (windowLen <= minWindow) {
					minWindow = windowLen;
					startIndex = start;
				}
			}
		}
		return input.substring(startIndex, startIndex + minWindow);
	}
}

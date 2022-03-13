package strings;

/*
 * https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */
public class AnagramSubstringSearch {
	public static void main(String[] args) {
		printAllOccurrences("BACDGABCDA", "ABCD");
		printAllOccurrences("AAABABAA", "AABA");
	}

	private static void printAllOccurrences(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[] l1 = new int[256], l2 = new int[256];

		for (int i = 0; i < n2; i++)
			l2[s2.charAt(i)]++;

		for (int i = 0; i < n2; i++)
			l1[s1.charAt(i)]++;

		if (isMatch(l1, l2))
			System.out.println("Found at " + 0);

		for (int i = n2; i < n1; i++) {
			l1[s1.charAt(i)]++;
			l1[s1.charAt(i - n2)]--;
			if (isMatch(l1, l2))
				System.out.println("Found at " + (i - n2 + 1));
		}

	}

	private static boolean isMatch(int[] count, int[] other) {
		for (int i = 0; i < 256; i++) {
			if (count[i] != other[i])
				return false;
		}
		return true;
	}
}

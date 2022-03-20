package strings;

/*
 * https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
 */
public class FindLargestWordInDictionaryByDeletingFew {
	public static void main(String[] args) {
		String[] arr = { "ale", "apple", "monkey", "plea" };
		String str = "abpcplea";
		System.out.println(largestWord(arr, str));
	}

	private static String largestWord(String[] arr, String str) {
		String ans = null;
		int len = 0;
		for (String word : arr) {
			if (word.length() > len && isSubSequence(word, str)) {
				len = word.length();
				ans = word;
			}
		}
		return ans;
	}

	static boolean isSubSequence(String A, String B) {
		int n1 = A.length(), n2 = B.length(), i1 = 0, i2 = 0;
		while (i1 != n1 && i2 != n2) {
			if (A.charAt(i1) == B.charAt(i2)) {
				i1++;
				i2++;
			} else {
				i2++;
			}
		}
		return i1 == n1;
	}
}

package strings;

/*
 * /*
 * https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
 */
public class CheckIfString1SubSequenceOfString2 {
	public static void main(String[] args) {
		System.out.println(isSubSequence("gksrek", "geeksforgeeks"));
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

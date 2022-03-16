package strings;

/*
 * https://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
 */
public class FindKthCharacterOfDecryptedString {
	public static void main(String[] args) {
		System.out.println(findKth("ab2cd2", 4));
		System.out.println(findKth("abc3d1e2", 10));
		System.out.println(findKth("abc3d1e2", 12));
		System.out.println(findKth("abc3d1e2", 13)); // outside the range of string
	}

	private static char findKth(String s, int k) {
		char ans = '\0';
		String copy = s;
		s = s.toLowerCase();
		int startChar = 0, endChar = 0, startDigit, endDigit = 0, n = s.length(), len;

		while (startChar != n) {
			endChar = findEnd(s, startChar, true);
			startDigit = endChar;
			endDigit = findEnd(s, startDigit, false);
			len = Integer.parseInt(s.substring(startDigit, endDigit)) * (endChar - startChar);
			if (len >= k) {
				k = (k - 1) % (endChar - startChar);
				ans = copy.charAt(startChar + k);
				break;
			} else {
				k -= len;
			}
			startChar = endDigit;
		}

		return ans;
	}

	private static int findEnd(String s, int startIndex, boolean isSearchingChar) {
		int n = s.length();
		if (isSearchingChar) {
			while (startIndex != n && s.charAt(startIndex) >= 'a' && s.charAt(startIndex) <= 'z') {
				startIndex++;
			}
		} else {
			while (startIndex != n && s.charAt(startIndex) >= '0' && s.charAt(startIndex) <= '9') {
				startIndex++;
			}
		}
		return startIndex;
	}
}

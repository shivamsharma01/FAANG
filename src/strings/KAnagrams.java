package strings;

/*
 * https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/
 */
public class KAnagrams {
	public static void main(String[] args) {
		System.out.println(areKAnagrams("fodr", "gork", 2));
		System.out.println(areKAnagrams("abbcc", "cabbb", 1));
		System.out.println(areKAnagrams("ukdbgygrsjlaukwsgc", "memdwhetaewfahkc", 14));
	}

	static boolean areKAnagrams(String s1, String s2, int k) {
		int n1 = s1.length(), n2 = s2.length();
		if (n1 != n2) {
			return false;
		}
		int[] l1 = new int[26], l2 = new int[26];

		for (int i = 0; i < n1; i++)
			l1[s1.charAt(i) - 'a']++;
		for (int i = 0; i < n2; i++)
			l2[s2.charAt(i) - 'a']++;

		int dif1 = 0;
		for (int i = 0; i < 26; i++) {
			if (l1[i] <= l2[i])
				dif1 += l2[i] - l1[i];
		}
		return k >= dif1;
	}
}

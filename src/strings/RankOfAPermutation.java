package strings;

/*
 * https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
 */
public class RankOfAPermutation {
	public static void main(String[] args) {
		System.out.println(rank("dbca"));
		System.out.println(rank("string"));
		System.out.println(rank("xzbcoejuvp"));
	}

	static int MOD = (int) 1e6 + 3;

	static int rank(String string) {
		int n = string.length();

		if (n == 1)
			return 1;

		int[] arr = new int[26];

		for (int i = 0; i < n; i++)
			arr[string.charAt(i) - 'a']++;

		StringBuilder rank1String = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			if (arr[i] > 1)
				return 0;
			if (arr[i] == 1)
				rank1String.append((char) (i + 'a'));
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (rank1String.charAt(0) != string.charAt(i)) {
				int temp = returnPlace(arr, string.charAt(i) - 'a');
				ans = (ans + (temp * fact(n - (i + 1)) % MOD)) % MOD;
			}

			arr[string.charAt(i) - 'a'] = 0;
			rank1String.deleteCharAt(rank1String.indexOf("" + string.charAt(i)));
		}
		return ans + 1;
	}

	private static int fact(int n) {
		int ans = 1;
		for (int i = 2; i <= n; i++)
			ans = (ans * i) % MOD;
		return ans;
	}

	private static int returnPlace(int[] arr, int letterIndex) {
		int ans = -1;
		for (int i = 0; i < 26; i++) {
			if (arr[i] == 1)
				ans++;
			if (i == letterIndex) {
				return ans;
			}
		}
		return ans;
	}
}

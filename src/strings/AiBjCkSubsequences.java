package strings;

/*
 * https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 */
public class AiBjCkSubsequences {
	public static void main(String[] args) {
		System.out.println(getCount("aacc"));
	}

	public static int getCount(String s) {
		int aCount = 0, bCount = 0, cCount = 0, MOD = 1000000000 + 7;
		for (char c : s.toCharArray()) {
			if (c == 'a')
				aCount = (1 + (2 * aCount) % MOD) % MOD;
			else if (c == 'b')
				bCount = (aCount + (2 * bCount) % MOD) % MOD;
			else
				cCount = (bCount + (2 * cCount) % MOD) % MOD;
		}
		return cCount;
	}
}

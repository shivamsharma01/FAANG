package strings;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/count-ways-increase-lcs-length-two-strings-one/
 */
public class IncreaseLCSByOne {
	public static void main(String[] args) {
		String s1 = "mugfybtzr", s2 = "bdvslnymhdwwsimmictgglp";
		System.out.println(waysToIncreaseLCSBy(s1, s2));
		s1 = "ab";
		s2 = "abcc";
		System.out.println(waysToIncreaseLCSBy(s1, s2));
	}

	static int waysToIncreaseLCSBy(String s1, String s2) {
		int N1 = s1.length(), N2 = s2.length();
		return waysToIncreaseLCSBy2(N1, s1, N2, s2);
	}

	static int waysToIncreaseLCSBy2(int N1, String s1, int N2, String s2) {
		final int MAX = 26;
		ArrayList<Integer>[] l = new ArrayList[MAX];
		for (int i = 0; i < MAX; i++)
			l[i] = new ArrayList<>();

		for (int i = 0; i < N2; i++)
			l[s2.charAt(i) - 'a'].add(i + 1);

		int[][] lcsl = new int[N1 + 2][N2 + 2], lcsr = new int[N1 + 2][N2 + 2];

		for (int i1 = 1; i1 <= N1; i1++) {
			for (int i2 = 1; i2 <= N2; i2++) {
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
					lcsl[i1][i2] = lcsl[i1 - 1][i2 - 1] + 1;
				else
					lcsl[i1][i2] = Math.max(lcsl[i1 - 1][i2], lcsl[i1][i2 - 1]);
			}
		}

		for (int i1 = N1; i1 >= 1; i1--) {
			for (int i2 = N2; i2 >= 1; i2--) {
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
					lcsr[i1][i2] = lcsr[i1 + 1][i2 + 1] + 1;
				else
					lcsr[i1][i2] = Math.max(lcsr[i1 + 1][i2], lcsr[i1][i2 + 1]);
			}
		}

		int lcs = lcsl[N1][N2], ways = 0;

		for (int i = 0; i <= N1; i++) {
			for (int c = 0; c < MAX; c++) {
				if (l[c].size() == 0)
					continue;
				for (int pos : l[c]) {
					if (lcsl[i][pos - 1] + lcsr[i + 1][pos + 1] == lcs) {
						ways++;
						break;
					}
				}
			}
		}
		return ways;
	}
}

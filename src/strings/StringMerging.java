package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codechef.com/JAN18/problems/STRMRG
 */
public class StringMerging {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static int[][][] dp = new int[5001][5001][2];

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int q = fr.nextInt(), n, m;
		String s1, s2;
		while (q-- > 0) {
			n = fr.nextInt();
			m = fr.nextInt();
			s1 = compressString(fr.nextLine());
			s2 = compressString(fr.nextLine());
			System.out.println(sMerge(s1, s2));
		}
	}

	private static int sMerge(String a, String b) {
		int[][] m = new int[a.length() + 1][b.length() + 1];

		for (int row = 0; row < m.length; row++) {
			m[row][0] = row;
		}

		for (int col = 0; col < m[0].length; col++) {
			m[0][col] = col;
		}

		for (int row = 1; row < m.length; row++) {
			for (int col = 1; col < m[0].length; col++) {
				// because of compressString method any two consequent characters in a or b are
				// different and (row-1)'th and (col-1)'th characters are same. therefore at the
				// cost of 1 we add both these characters
				if (a.charAt(row - 1) == b.charAt(col - 1)) {
					m[row][col] = 1 + m[row - 1][col - 1];
				} else {
					m[row][col] = 1 + ((m[row - 1][col] < m[row][col - 1]) ? (m[row - 1][col]) : (m[row][col - 1]));
				}
			}
		}

		return (m[(m.length - 1)][(m[0].length - 1)]);
	}

	private static String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		int i = 1;
		while (i < s.length()) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				sb.append(s.charAt(i));
			}
			i++;
		}
		return sb.toString();
	}
}

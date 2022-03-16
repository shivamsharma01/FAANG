package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * https://www.codechef.com/submit/PERMPAL
 */
public class PermutationAndPalindrome {
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

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int q = fr.nextInt();
		while (q-- > 0) {
			permAndPal(fr.nextLine());
		}
	}

	private static void permAndPal(String s) {
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			list.add(new ArrayList<>());

		int n = s.length();
		for (int i = 0; i < n; i++) {
			list.get(s.charAt(i) - 'a').add(i + 1);
		}
		int idx = -1, j;
		for (int i = 0; i < 26; i++) {
			if (list.get(i).size() % 2 == 1) {
				if (idx == -1) {
					idx = i;
				} else {
					System.out.println("-1");
					return;
				}
			}
		}
		ArrayList<Integer> odd = null, cur;
		if (idx != -1) {
			odd = list.get(idx);
			list.set(idx, new ArrayList<>());
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 26; i++) {
			cur = list.get(i);
			int size = cur.size();
			if (size == 0)
				continue;
			j = size - 1;
			size /= 2;
			while (j >= size) {
				sb.append(cur.remove(j--) + " ");
			}
		}
		if (idx != -1) {
			j = odd.size() - 1;
			while (j >= 0) {
				sb.append(odd.remove(j--) + " ");
			}
		}
		for (int i = 25; i >= 0; i--) {
			cur = list.get(i);
			int size = cur.size();
			if (size == 0)
				continue;
			while (size > 0) {
				sb.append(cur.remove(--size) + " ");
			}
		}
		System.out.println(sb.toString());
	}
}

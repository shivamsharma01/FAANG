package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.codechef.com/JAN18/problems/MAXSC/
 */
public class MaximumScore {

	static int[][] matrix;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader s = new FastReader();
		int test = s.nextInt();
		int arr[][];
		while (test-- > 0) {
			int n = s.nextInt();
			arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = s.nextInt();
				}
				Arrays.sort(arr[j]);
			}
			long sum = 0;
			int num = arr[n - 1][n - 1] + 1, ans = -1;
			for (int row = n - 1; row >= 0; row--) {
				num--;
				ans = -1;
				int left = 0, right = n - 1, mid;
				while (left <= right) {
					mid = left + (right - left) / 2;
					if (arr[row][mid] == num) {
						ans = num;
						break;
					} else if (arr[row][mid] > num) {
						right = mid - 1;
					} else {
						left = mid + 1;
						ans = arr[row][mid];
					}
				}
				if (ans == -1)
					break;
				sum += ans;
				num = ans;
			}
			if (ans == -1)
				System.out.println(-1);
			else
				System.out.println(sum);
		}
	}

}

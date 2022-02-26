package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * 
 * 4
 * 1 2 3 3
 * #YES, it is index 2
 */
public class EquilibriumIndex {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split(" ");
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(str[i]);
			}

			String ans = equilibrium(a, n);
			System.out.println(ans);
		}
	}

	static String equilibrium(int arr[], int n) {
		long[] sum = new long[n];
		sum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sum[i] += sum[i - 1] + arr[i];
		}
		for (int i = 1; i < n - 1; i++) {
			if (sum[i - 1] == sum[n - 1] - sum[i])
				return "YES";
		}
		return "NO";
	}
}

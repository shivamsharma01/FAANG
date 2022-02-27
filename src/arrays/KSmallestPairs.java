package arrays;

/*
 * https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/
 */
public class KSmallestPairs {
	public static void main(String[] args) {
		int[] a = { 1, 7, 11 }, b = { 2, 4, 6 };
		int k = 3;
		getPairs(a, b, k);
	}

	private static void getPairs(int[] a, int[] b, int k) {
		int i = 0, j = 0, n = a.length, m = b.length;
		if (k > n * m) {
			System.out.println("Not Possible");
			return;
		}
		while (k != 0) {
			k--;
			System.out.println("[" + a[i] + ", " + b[j] + "]");
			if (i < n - 1 && j < m - 1) {
				if (a[i + 1] <= b[j + 1])
					i++;
				else
					j++;
			} else if (i < n - 1)
				i++;
			else
				j++;
		}
	}
}

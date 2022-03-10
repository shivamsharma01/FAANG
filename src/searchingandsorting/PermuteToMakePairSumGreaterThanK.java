package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/
 */
public class PermuteToMakePairSumGreaterThanK {
	public boolean isPossible(long a[], long b[], long n, long k) {
		Arrays.sort(a);
		for (int i = 0; i < n; i++)
			b[i] *= -1;
		Arrays.sort(b);
		for (int i = 0; i < n; i++)
			b[i] *= -1;
		for (int i = 0; i < n; i++)
			if (a[i] + b[i] < k)
				return false;
		return true;
	}
}

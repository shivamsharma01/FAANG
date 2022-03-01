package arrays;

/*
 * https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
 */
public class LargestSumSubarrayWithAtLeastKElements {

	public long maxSumWithK(long a[], long n1, long k1) {
		int n = (int) n1, k = (int) k1;
		long curSum = 0, max, prev = 0;
		for (int i = 0; i < k; i++)
			curSum += a[i];

		max = curSum;
		for (int i = k, j = 0; i < n; i++) {
			curSum += a[i];
			prev += a[j++];
			if (prev < 0) {
				curSum -= prev;
				prev = 0;
			}
			max = Math.max(max, curSum);
		}
		return max;
	}
}

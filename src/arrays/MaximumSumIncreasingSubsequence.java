package arrays;

/*
 * https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
 */
public class MaximumSumIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(new MaximumSumIncreasingSubsequence().maxSumIS(new int[] { 1, 101, 2, 3, 100 }, 5));
	}

	public int maxSumIS(int arr[], int n) {
		int[] sumArr = new int[n];
		sumArr[0] = arr[0];
		int max = sumArr[0];
		for (int i = 1; i < n; i++) {
			sumArr[i] = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i])
					continue;
				else {
					sumArr[i] = Math.max(sumArr[j] + arr[i], sumArr[i]);
				}
			}
			max = Math.max(max, sumArr[i]);
		}
		return max;
	}
}

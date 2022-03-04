package searchingandsorting;

public class MaxSumAdjacent {
	public static void main(String[] args) {
		System.out.println(findMaxSum(new int[] { 5, 5, 10, 100, 10, 5 }, 6));
	}

	static int findMaxSum(int arr[], int n) {
		if (n == 1)
			return arr[0];
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < n; i++)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
		return dp[n - 1];
	}
}

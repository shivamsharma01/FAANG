package arrays;

/*
 * https://www.geeksforgeeks.org/trappicg-rain-water/
 */
public class RainWater {
	static long trappingWater(int arr[], int n) {
		if (n <= 2)
			return 0;
		int[] leftMax = new int[n];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}
		long ans = 0;
		int rightMax = arr[n - 1], min;
		for (int i = n - 2; i >= 1; i--) {
			min = Math.min(rightMax, leftMax[i - 1]);
			if (min > arr[i])
				ans += min - arr[i];
			rightMax = Math.max(rightMax, arr[i]);
		}
		return ans;
	}
}

package arrays;

/*
 * https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
public class MaxJMinI {
	int maxIndexDiff(int arr[], int n) {
		int[] maxRight = new int[n];
		maxRight[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			maxRight[i] = Math.max(arr[i], maxRight[i + 1]);

		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			int left = i + 1, right = n - 1, mid, ans = i;
			while (left <= right) {
				mid = left + (right - left) / 2;
				if (arr[i] <= maxRight[mid]) {
					ans = Math.max(ans, mid);
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			result = Math.max(result, ans - i);
		}
		return result;
	}
}

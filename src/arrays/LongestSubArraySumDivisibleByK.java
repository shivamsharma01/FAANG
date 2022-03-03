package arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
 */
public class LongestSubArraySumDivisibleByK {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = { 1, 2, 4, 3, 2 };
		int k = 3, ans = getLongestSubArray(arr, arr.length, k);
		System.out.println(ans);
	}

	private static int getLongestSubArray(int[] arr, int n, int k) {
		int ans = 0, sum = 0, mod;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			mod = ((sum % k) + k) % k;
			if (mod == 0)
				ans = i + 1;
			if (!map.containsKey(mod))
				map.put(mod, i);
			else
				ans = Math.max(ans, i - map.get(mod));
		}
		return ans;
	}

}

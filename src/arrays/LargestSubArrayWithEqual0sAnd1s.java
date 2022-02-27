package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * 4
 * 1 1 1 0
 * #2
 */
public class LargestSubArrayWithEqual0sAnd1s {
	int maxLen(int[] arr, int N) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, max = 0;
		map.put(0, 0);
		for (int i = 0; i < N; i++) {
			if (arr[i] == 1) {
				sum++;
			} else {
				sum--;
			}
			if (sum == 0)
				max = i + 1;
			else if (map.containsKey(sum)) {
				max = Math.max(i - map.get(sum), max);
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}
}

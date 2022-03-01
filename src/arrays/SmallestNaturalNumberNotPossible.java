package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
 * n = 6
 * 1, 10, 3, 11, 6, 15
 * #2
 */
public class SmallestNaturalNumberNotPossible {
	long smallestpositive(long[] array, int n) {
		long ans = 1;
		Arrays.sort(array);
		for (long num : array) {
			if (num > ans)
				return ans;
			ans += num;
		}
		return ans;
	}
}

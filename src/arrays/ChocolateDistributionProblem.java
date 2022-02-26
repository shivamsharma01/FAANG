package arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
 * 
 * Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
 * Output: Minimum Difference is 6 
 * The set goes like 3,4,7,9,9 and the output is 9-3 = 6
 *
 * Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7 
 * Output: Minimum Difference is 10 
 */
public class ChocolateDistributionProblem {
	public long findMinDiff(ArrayList<Long> a, long n, long m) {
		Collections.sort(a);
		long min = Long.MAX_VALUE;
		int start = (int) m;
		for (int i = start - 1; i < n; i++) {
			min = Math.min(min, a.get(i) - a.get(i - start + 1));
		}
		return min;
	}
}

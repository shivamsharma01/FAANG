package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-number-pairs-xy-yx/
 */
public class FindPairsWhereXpowYGRTYpowX {
	public static void main(String[] args) {
		int[] x = { 1, 2, 2, 8 }, y = { 1, 1, 2, 8 };
		System.out.println(countPairs(x, y));
	}

	private static int countPairs(int[] x, int[] y) {
		int[] yHelper = new int[5 + 1];
		for (int i : y) {
			if (i <= 5)
				yHelper[i]++;
		}
		int totalPairs = 0;
		for (int ele : x)
			totalPairs += countPairs(ele, y, yHelper);
		return totalPairs;
	}

	private static int countPairs(int ele, int[] y, int[] yHelper) {
		if (ele == 0)
			return 0;
		if (ele == 1)
			return yHelper[0];
		int idx = Arrays.binarySearch(y, ele), ans = 0;
		if (idx < 0) {
			idx = Math.abs(idx + 1);
			ans = y.length - idx;
		} else {
			while (idx != y.length && ele == y[idx])
				idx++;
			ans = y.length - idx;
		}
		ans += yHelper[0] + yHelper[1];
		if (ele == 2)
			ans -= (yHelper[3] + yHelper[4]);

		if (ele == 3)
			ans -= yHelper[2];

		return ans;
	}
}

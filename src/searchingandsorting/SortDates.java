package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/how-to-efficiently-sort-a-big-list-dates-in-20s/
 */
public class SortDates {
	public static void main(String[] args) {
		int[][] dates = new int[][] { { 1, 4, 2005 }, { 10, 12, 2015 }, { 15, 10, 2018 }, { 10, 11, 2009 },
				{ 15, 2, 2005 }, { 20, 10, 2009 } };
		sortDates(dates);
		print(dates);
	}

	private static void sortDates(int[][] dates) {
		sort(dates, 0);
		sort(dates, 1);
		sort(dates, 2);
	}

	private static void sort(int[][] dates, int idx) {
		int max = getMax(dates, idx);
		int p = 1, n = dates.length, lastDigit;
		int[] count = new int[10];
		int[][] ans = new int[n][3];
		while (max > 0) {
			Arrays.fill(count, 0);
			for (int[] date : dates)
				count[(date[idx] / p) % 10]++;

			for (int i = 1; i < 10; i++)
				count[i] += count[i - 1];

			for (int i = n - 1; i >= 0; i--) {
				lastDigit = (dates[i][idx] / p) % 10;
				for (int q = 0; q <= 2; q++)
					ans[count[lastDigit] - 1][q] = dates[i][q];
				count[lastDigit]--;
			}

			for (int i = 0; i < n; i++) {
				for (int q = 0; q <= 2; q++)
					dates[i][q] = ans[i][q];
			}
			p *= 10;
			max /= 10;
		}
	}

	private static int getMax(int[][] dates, int i) {
		int max = dates[0][i];
		for (int[] date : dates)
			if (max < date[i])
				max = date[i];
		return max;
	}

	private static void print(int[][] dates) {
		for (int[] date : dates)
			System.out.println(String.format("%d-%d-%d", date[0], date[1], date[2]));
		System.out.println();
	}
}

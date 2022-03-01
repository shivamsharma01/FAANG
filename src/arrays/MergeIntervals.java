package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/merging-intervals/
 */
public class MergeIntervals {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MergeIntervals.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		int[][] in, out, ans;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			in = new int[n][2];
			for (int i = 0; i < n; i++) {
				data = read.readLine().trim().split(" ");
				in[i][0] = Integer.parseInt(data[0]);
				in[i][1] = Integer.parseInt(data[1]);
			}
			n = Integer.parseInt(read.readLine());
			out = new int[n][2];
			for (int i = 0; i < n; i++) {
				data = read.readLine().trim().split(" ");
				out[i][0] = Integer.parseInt(data[0]);
				out[i][1] = Integer.parseInt(data[1]);
			}
			System.out.println(display(in));
			ans = overlappedInterval(in);
			String s1 = display(out), s2 = display(ans);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s1.equals(s2) ? "Correct" : "Incorrect");
			System.out.println("\n");
		}
		read.close();
	}

	private static String display(int[][] d2) {
		StringBuilder sb = new StringBuilder("");
		for (int[] d1 : d2)
			sb.append(Arrays.toString(d1));
		return sb.toString();
	}

	public static int[][] overlappedInterval(int[][] intervals) {
		List<int[]> ans = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		ans.add(new int[] { intervals[0][0], intervals[0][1] });
		int[] topInterval;
		int len = 0;
		for (int i = 1; i < intervals.length; i++) {
			topInterval = ans.get(len);
			if (topInterval[1] >= intervals[i][0]) {
				topInterval[1] = Math.max(topInterval[1], intervals[i][1]);
			} else {
				ans.add(new int[] { intervals[i][0], intervals[i][1] });
				len++;
			}
		}
		int[][] out = new int[len + 1][];
		len = 0;
		for (int[] interval : ans)
			out[len++] = interval;
		return out;
	}
}

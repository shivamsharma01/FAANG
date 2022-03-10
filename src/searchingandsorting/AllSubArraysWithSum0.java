package searchingandsorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */
public class AllSubArraysWithSum0 {
	public static void main(String[] args) {
		int[] arr = new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		List<Pair> ans = findSubArrays(arr, arr.length);
		long count = findSubarrayCount(arr, arr.length);
		System.out.println("total number of zero sum subarryas = " + count);
		print(ans, arr);
	}

	private static void print(List<Pair> list, int[] arr) {
		for (Pair p : list) {
			for (int i = p.a; i <= p.b; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}

	public static long findSubarrayCount(int[] arr, int n) {
		Map<Long, Integer> map = new HashMap<>();
		long ans = 0, sum = 0;
		int temp;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum == 0)
				ans += 1;

			if (map.containsKey(sum)) {
				temp = map.get(sum) + 1;
			} else {
				temp = 0;
			}
			map.put(sum, temp);
		}
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			temp = entry.getValue();
			if (temp >= 1)
				ans += temp * (temp + 1) / 2;
		}
		return ans;
	}

	private static List<Pair> findSubArrays(int[] arr, int n) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Pair> out = new ArrayList<>();

		int sum = 0;

		List<Integer> temp;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum == 0)
				out.add(new Pair(0, i));

			if (map.containsKey(sum)) {
				temp = map.get(sum);
				for (int k : temp) {
					out.add(new Pair(k + 1, i));
				}
			} else {
				temp = new ArrayList<>();
			}
			temp.add(i);
			map.put(sum, temp);
		}

		return out;
	}
}

class Pair {
	int a, b;

	Pair(int x, int y) {
		a = x;
		b = y;
	}
}
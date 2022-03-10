package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/minimum-swaps-to-make-two-array-identical/
 */
public class MinSwapsToMakeTwoArraysEqual {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 10, 20, 30, 40, 50, 60 };
		int[] arr2 = new int[] { 10, 30, 20, 40, 60, 50 };
		System.out.println(minSwaps(arr1, arr2));
	}

	private static int minSwaps(int[] arr1, int[] arr2) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr1.length; i++)
			m.put(arr1[i], i);
		for (int i = 0; i < arr1.length; i++)
			arr2[i] = m.get(arr2[i]);
		return countMinSwaps(arr2);
	}

	private static int countMinSwaps(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
			list.get(i).add(arr[i]);
			list.get(i).add(i);
		}
		Collections.sort(list, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		boolean[] visited = new boolean[n];
		int ans = 0, cycleSize = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] || list.get(i).get(1) == i)
				continue;
			int j = i;
			cycleSize = 0;
			while (!visited[j]) {
				visited[j] = true;
				j = list.get(j).get(1);
				cycleSize++;
			}
			if (cycleSize > 0)
				ans += cycleSize - 1;
		}
		return ans;
	}
}

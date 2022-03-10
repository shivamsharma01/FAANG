package searchingandsorting;

import java.util.Arrays;
import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 */
public class MinSwaps {
	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2 };
		System.out.println(minSwaps(a));
	}

	public static int minSwaps(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);

		int ans = 0;
		for (int i = 0; i < len; i++) {
			if (visited[i] || map.get(nums[i]) == i)
				continue;

			int j = i, cycle_size = 0;
			while (!visited[j]) {
				System.out.println("j = " + j + " " + nums[j] + " " + map.get(nums[j]));
				visited[j] = true;
				j = map.get(nums[j]);
				cycle_size++;
			}
			System.out.println(cycle_size);
			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}
		return ans;
	}
}
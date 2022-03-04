package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 */
public class CountTriplets {
	public static void main(String[] args) {
		System.out.println(count(new int[] { -2, 0, 1, 3 }, 2));
	}

	static int count(int[] arr, int x) {
		Arrays.sort(arr);
		int n = arr.length, ans = 0, i1 = 0;
		for (int i = 0; i < n - 2; i++) {
			int target = x - arr[i];
			if (target < arr[i])
				break;
			for (int j = i + 1; j < n - 1; j++) {
				target = x - arr[i] - arr[j];
				if (target < arr[j])
					break;
				for (int k = j + 1; k < n; k++) {
					if (target > arr[k])
						ans++;
					else
						break;
				}
			}
		}
		return ans;
	}
}

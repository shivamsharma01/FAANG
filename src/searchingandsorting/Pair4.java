package searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 */
public class Pair4 {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 5, 9, 8, 7 };
		int x = 23;
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, x);
		System.out.println(ans);
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
		int n = arr.length;
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int target2 = k - arr[i] - arr[j];
				int left = j + 1;
				int right = n - 1;
				while (left < right) {
					int two_sum = arr[left] + arr[right];
					if (two_sum < target2)
						left++;
					else if (two_sum > target2)
						right--;
					else {
						int le = arr[left];
						int ri = arr[right];
						ArrayList<Integer> entry = new ArrayList<>();
						entry.add(arr[i]);
						entry.add(arr[j]);
						entry.add(arr[left]);
						entry.add(arr[right]);
						ans.add(entry);
						// this will not allow repeated 3rd element
						while (left < right && arr[left] == le)
							left++;
						// this will not allow repeated 4th element
						while (left < right && arr[right] == ri)
							right--;
					}
				}
				// this will not allow repeated 2nd element
				while (j + 1 < n && arr[j + 1] == arr[j])
					j++;
			}
			// this will not allow repeated 1st element
			while (i + 1 < n && arr[i + 1] == arr[i])
				i++;
		}
		return ans;
	}
}

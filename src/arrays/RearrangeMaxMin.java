package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 */
public class RearrangeMaxMin {
	public static void main(String[] args) {
		rearrange(new int[] { 10, 20, 30, 40, 50, 60, 70 });
		rearrange(new int[] { 10, 20, 30, 40, 50, 60, 70, 80 });
	}

	// input array will be sorted in non-descending
	static void rearrange(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		int max_idx = n - 1, min_idx = 0, max_val = arr[n - 1] + 1;

		for (int i = 0; i < n; i++) {
			if ((i & 1) == 0)
				arr[i] += (arr[max_idx--] % max_val) * max_val;
			else
				arr[i] += (arr[min_idx++] % max_val) * max_val;
		}
		for (int i = 0; i < n; i++)
			arr[i] /= max_val;

		System.out.println(Arrays.toString(arr) + "\n");
	}

}

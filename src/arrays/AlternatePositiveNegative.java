package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 */
public class AlternatePositiveNegative {
	public static void main(String[] args) {
		int[] arr = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
		new AlternatePositiveNegative().rearrange(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	int getIndexPos(int[] arr, int start, int n) {
		while (start != n) {
			if (arr[start] >= 0)
				return start;
			start++;
		}
		return start;
	}

	int getIndexNeg(int[] arr, int start, int n) {
		while (start != n) {
			if (arr[start] < 0)
				return start;
			start++;
		}
		return start;
	}

	void rightRotate(int arr[], int n, int outofplace, int cur) {
		int tmp = arr[cur];
		for (int i = cur; i > outofplace; i--)
			arr[i] = arr[i - 1];
		arr[outofplace] = tmp;
	}

	void rearrange(int arr[], int n) {
		int i = 0, start, temp;
		while (i < n) {
			if ((i & 1) == 1 && arr[i] >= 0 || (i & 1) == 0 && arr[i] < 0) {
				start = arr[i] >= 0 ? getIndexNeg(arr, i + 1, n) : getIndexPos(arr, i + 1, n);
				if (start == n)
					break;
				rightRotate(arr, n, i, start);
				i++;
			}
			i++;
		}
	}
}

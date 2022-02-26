package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * 
 * N = 7
 * Arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: 3 7 4 8 2 6 1
 */
public class ZigZag {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		int n = arr.length;
		zigZag(arr, n);
		System.out.println(Arrays.toString(arr));
	}

	static void zigZag(int arr[], int n) {
		char op = '<';
		int temp;
		for (int i = 0; i < n - 1; i++) {
			if (op == '<') {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				op = '>';
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				op = '<';
			}
		}
	}

}

package strings;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/
 */
public class PrintNumberInASCWith123 {
	public static void main(String[] args) {
		printOnly123(new int[] { 123, 1232, 456, 234, 32145 });
		printOnly123(new int[] { 9821, 627183, 12, 1234 });
		printOnly123(new int[] { 12, 232, 456, 234 });
	}

	public static void printOnly123(int[] arr) {
		int n = arr.length, count = 0;
		for (int i = 0; i < n; i++) {
			if (!has123(arr[i])) {
				arr[i] = -1;
			} else {
				count++;
			}
		}
		int[] out = new int[count];
		count = 0;
		for (int ele : arr) {
			if (ele != -1)
				out[count++] = ele;
		}
		Arrays.sort(out);
		System.out.println(Arrays.toString(out));
	}

	private static boolean has123(int num) {
		if (num < 123)
			return false;
		boolean hasOne = false, hasTwo = false, hasThree = false;
		while (num != 0) {
			int digit = num % 10;
			if (digit == 1)
				hasOne = true;
			if (digit == 2)
				hasTwo = true;
			if (digit == 3)
				hasThree = true;
			num /= 10;
		}
		return hasOne && hasTwo && hasThree;
	}
}

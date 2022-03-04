package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */
public class FindMissingAndRepeating {
	public static void main(String[] args) {
		int[] ans;
		ans = findTwoElement(new int[] { 1, 2, 2, 4 }, 4);
		System.out.println(Arrays.toString(ans));
		ans = findTwoElement(new int[] { 5, 1, 1, 4, 3 }, 5);
		System.out.println(Arrays.toString(ans));
	}

	static int[] findTwoElement(int arr[], int n) {
		int xor = 0;

		for (int ele : arr)
			xor ^= ele;

		for (int i = 1; i <= n; i++)
			xor ^= i;

		int rightMostBit = xor & ~(xor - 1);

		int x = 0, y = 0;

		for (int ele : arr)
			if ((ele & rightMostBit) != 0)
				x ^= ele;
			else
				y ^= ele;

		for (int i = 1; i <= n; i++)
			if ((i & rightMostBit) != 0)
				x ^= i;
			else
				y ^= i;

		boolean isPresent = false;
		for (int ele : arr)
			if (ele == x) {
				isPresent = true;
				break;
			}
		return isPresent ? new int[] { x, y } : new int[] { y, x };
	}
}

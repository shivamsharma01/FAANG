package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/
 */
public class CheckIfSubArrayReverseMakesArraySorted {
	public static void main(String[] args) {
		System.out.println(checkReverse(new int[] { 1, 2, 3 }));
		System.out.println(checkReverse(new int[] { 2, 1, 3 }));
		System.out.println(checkReverse(new int[] { 2, 1, 0 }));
		System.out.println(checkReverse(new int[] { 2, 1, 2 }));
	}

	private static boolean checkReverse(int[] arr) {
		int n = arr.length;
		if (n <= 1)
			return true;

		int i, j, k;

		for (i = 1; i < n && arr[i] > arr[i - 1]; i++)
			;

		if (i == n) // no need to reverse, already sorted
			return true;

		j = i;
		// we are checking the possible reverse array but any of the elements in this
		// array should be greater than the previous increasing sequence
		while (j < n && arr[j] < arr[j - 1]) {
			if (i > 1 && arr[j] < arr[i - 2])
				return false;
			j++;
		}

		if (j == n) // array can be sorted by reversing from i to
			return true;

		k = j;

		System.out.println(k);
		if (arr[k] < arr[i - 1])
			return false;
		while (k < n) {
			if (arr[k] < arr[k - 1])
				return false;
			k++;
		}
		return true;
	}
}

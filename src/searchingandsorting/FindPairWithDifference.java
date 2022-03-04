package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 */
public class FindPairWithDifference {
	public static void main(String[] args) {
		System.out.println(findPair(new int[] { 5, 20, 3, 2, 5, 80 }, 6, 78));
	}

	public static boolean findPair(int arr[], int size, int n) {
		if (size == 1)
			return false;
		Arrays.sort(arr);
		int i = 0, j = 1, diff;
		while (j != size && i != j) {
			diff = arr[j] - arr[i];
			if (diff == n)
				return true;
			else if (diff < n)
				j++;
			else
				i++;
			if (i == j)
				j++;
		}
		return false;
	}

}

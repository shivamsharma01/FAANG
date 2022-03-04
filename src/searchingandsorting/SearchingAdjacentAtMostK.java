package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
 */
public class SearchingAdjacentAtMostK {
	public static void main(String[] args) {
		System.out.println(findIndex(new int[] { 20, 40, 50, 70, 70, 60 }, 20, 60));
	}

	private static int findIndex(int[] arr, int k, int x) {
		int i = 0, n = arr.length;

		while (i < n) {
			if (arr[i] == x)
				return i;
			i += Math.max(1, Math.abs(x - arr[i]) / k); // max(1, abs(x-arr[i]/k)) important else if x - arr[i]/k == 0
														// then loop will stuck at this value
		}
		return -1;
	}
}

package searchingandsorting;

import java.util.Arrays;
import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/
 */
public class PairWithGreatestProduct {
	public static void main(String[] args) {
		int[] arr = { 1, 1 };
		System.out.println(findGreatest(arr, 2));
		arr = new int[] { 5, 1, 25 };
		System.out.println(findGreatest(arr, 3));
	}

	public static int findGreatest(int arr[], int n) {
		HashMap<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (m.containsKey(arr[i]))
				m.put(arr[i], m.get(arr[i]) + 1);
			else
				m.put(arr[i], 1);
		}
		Arrays.sort(arr);
		int sqrt, result;
		for (int i = n - 1; i >= 1; i--) {
			sqrt = (int) Math.sqrt(arr[i]);
			for (int j = 0; j < i && arr[j] <= sqrt; j++) {
				if (arr[i] % arr[j] == 0) {
					result = arr[i] / arr[j];
					if (result != arr[i] && result != arr[j] && m.get(result) != null)
						return arr[i];
					else if (result == arr[i] && result != arr[j] && m.get(result) > 1)
						return arr[i];
					else if (result == arr[i] && m.get(result) > 2)
						return arr[i];
					else if (result != arr[i] && result == arr[j] && m.get(result) > 1)
						return arr[i];
				}
			}
		}
		return -1;
	}
}

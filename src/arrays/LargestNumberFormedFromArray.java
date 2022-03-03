package arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
 * geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
*/

public class LargestNumberFormedFromArray {
	public static void main(String[] args) {
		String[] arr = new String[] { "3", "30", "34", "5", "9" };
		System.out.println(printLargest(arr));
	}

	static String printLargest(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -1 * o1.concat(o2).compareTo(o2.concat(o1));
			}
		});
		return String.join("", arr);
	}
}

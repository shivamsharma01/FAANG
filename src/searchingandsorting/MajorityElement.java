package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/majority-element/
 */
public class MajorityElement {
	public static void main(String[] args) {
		int[] arr;
		arr = new int[] { 1, 1, 1, 2, 3, 4 };
		System.out.println(majorityElement(arr, arr.length));
		arr = new int[] { 1, 1, 1, 2, 3, 1 };
		System.out.println(majorityElement(arr, arr.length));
		arr = new int[] { 1, 2, 3, 4, 4, 4 };
		System.out.println(majorityElement(arr, arr.length));
		arr = new int[] { 4, 2, 3, 4, 4, 4 };
		System.out.println(majorityElement(arr, arr.length));
		arr = new int[] { 1, 2, 3, 1 };
		System.out.println(majorityElement(arr, arr.length));
		arr = new int[] { 1, 2, 1 };
		System.out.println(majorityElement(arr, arr.length));
	}

	private static int majorityElement(int arr[], int n) {
		int cur = arr[0], count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == cur)
				count++;
			else
				count--;
			if (count < 0) {
				count = 1;
				cur = arr[i];
			}
		}
		if (count <= 0)
			return -1;
		else {
			count = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == cur)
					count++;
			}
			if (count > n / 2)
				return cur;
			else
				return -1;
		}
	}
}

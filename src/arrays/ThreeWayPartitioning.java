package arrays;

/*
 * 
 * https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
 * 
 * n = 5
 * A[] = {1, 2, 3, 3, 4}
 * [a, b] = [1, 2]
 */
public class ThreeWayPartitioning {
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void threeWayPartition(int arr[], int a, int b) {
		int i = 0, start = 0, end = arr.length - 1;
		while (i <= end) {
			if (arr[i] < a) {
				if (i == start) {
					i++;
					start++;
				} else {
					swap(arr, i++, start++);
				}
			} else if (arr[i] > b) {
				swap(arr, i, end--);
			} else {
				i++;
			}
		}
	}
}

package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
 */
public class CeilingOfANumber {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 8, 10, 10, 12, 19 };
		floorAndCeil(arr, 0);
		floorAndCeil(arr, 1);
		floorAndCeil(arr, 5);
		floorAndCeil(arr, 20);
	}

	private static void floorAndCeil(int[] arr, int x) {
		int floor = getFloor(arr, arr.length, x), ceil = getCeil(arr, arr.length, x);
		System.out.print(String.format("For x = %d:\t", x));
		if (floor == -1)
			System.out.print("floor doesn't exist in array");
		else
			System.out.print(String.format("floor = %d", floor));
		if (ceil == -1)
			System.out.print(", ceil doesn't exist in array");
		else
			System.out.print(String.format(", ceil = %d", ceil));
		System.out.println("\n");
	}

	private static int getFloor(int[] arr, int n, int x) {
		int left = 0, right = n - 1, mid, ans = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] > x)
				right = mid - 1;
			else {
				ans = arr[mid];
				left = mid + 1;
			}
		}
		return ans;
	}

	private static int getCeil(int[] arr, int n, int x) {
		int left = 0, right = n - 1, mid, ans = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] < x)
				left = mid + 1;
			else {
				ans = arr[mid];
				right = mid - 1;
			}
		}
		return ans;
	}
}

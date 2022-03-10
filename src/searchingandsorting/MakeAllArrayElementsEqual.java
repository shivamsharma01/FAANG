package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/
 */
public class MakeAllArrayElementsEqual {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 3, 3 };
		System.out.println(minCost(arr));
		System.out.println(minCostToMakeElementEqual(arr, arr.length));
	}

	private static long cost(int[] arr, int val) {
		long sum = 0;
		for (int ele : arr)
			sum += Math.abs(val - ele);
		return sum;
	}

	public static long minCost(int[] arr) {
		int n = arr.length, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

		for (int ele : arr) {
			if (ele > high)
				high = ele;
			if (ele < low)
				low = ele;
		}
		int mid1, mid2;
		long min = Math.min(cost(arr, low), cost(arr, high)), cost1, cost2;
		while ((high - low) > 2) {
			mid1 = low + (high - low) / 3;
			mid2 = high - (high - low) / 3;
			cost1 = cost(arr, mid1);
			cost2 = cost(arr, mid2);
			if (cost1 < cost2)
				high = mid2;
			else
				low = mid1;
			min = Math.min(Math.min(min, cost1), cost2);
		}
		return Math.min(min, cost(arr, (high + low) / 2));
	}

	public static int minCostToMakeElementEqual(int a[], int n) {
		int y = n % 2 == 1 ? a[n / 2] : (a[n / 2] + a[(n - 2) / 2]) / 2;
		System.out.println("y = " + y);
		int s = 0;

		for (int i = 0; i < n; i++)
			s += Math.abs(a[i] - y);

		return s;
	}

}

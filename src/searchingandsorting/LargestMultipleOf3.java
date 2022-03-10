package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/
 */
public class LargestMultipleOf3 {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 5, 5, 5, 5, 1 };
		findLargest(arr);
	}

	private static void countSort(int[] arr) {
		int[] count = new int[10];
		for (int i : arr)
			count[i]++;
		int idx = arr.length - 1;
		for (int i = 0; i <= 9; i++) {
			while (count[i] != 0) {
				arr[idx--] = i;
				count[i]--;
			}
		}
	}

	private static void removeAndPrint(int[] arr, int i1, int i2) {
		for (int i = 0; i < arr.length; i++) {
			if (i != i1 && i != i2) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}

	private static int sum(int[] digits) {
		int s = 0;
		for (int i : digits)
			s += i;
		return s;
	}

	private static void findLargest(int[] digits) {
		countSort(digits);
		int n = digits.length, s = sum(digits);
		if (s % 3 == 0) {
			removeAndPrint(digits, -1, -1);
			return;
		}
		int remainder = s % 3;
		int[] r = new int[2];
		if (remainder == 1) {
			for (int i = n - 1; i >= 0; i--) {
				if (digits[i] % 3 == 1) {
					removeAndPrint(digits, i, -1);
					return;
				} else if (digits[i] % 3 == 2) {
					if (r[0] == -1)
						r[0] = i;
					else
						r[1] = i;
				}
			}
			if (r[0] != -1 && r[1] != -1) {
				removeAndPrint(digits, r[0], r[1]);
				return;
			}
		} else {
			for (int i = n - 1; i >= 0; i--) {
				if (digits[i] % 3 == 2) {
					removeAndPrint(digits, i, -1);
					return;
				} else if (digits[i] % 3 == 1) {
					if (r[0] == -1)
						r[0] = i;
					else
						r[1] = i;
				}
			}
			if (r[0] != -1 && r[1] != -1) {
				removeAndPrint(digits, r[0], r[1]);
				return;
			}
		}
		System.out.println("not possible");
	}
}

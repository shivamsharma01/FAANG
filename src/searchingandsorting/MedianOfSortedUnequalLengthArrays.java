package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 */
public class MedianOfSortedUnequalLengthArrays {
	public static void main(String[] args) {
		int[] A = new int[] { 5 };
		int[] B = new int[] { 10 };
		System.out.println(findMedian(A, B));
		System.out.println("\n");

		B = new int[] { 2, 8 };
		System.out.println(findMedian(A, B));
		B = new int[] { 5, 8 };
		System.out.println(findMedian(A, B));
		B = new int[] { 6, 8 };
		System.out.println(findMedian(A, B));
		B = new int[] { 1, 2 };
		System.out.println(findMedian(A, B));
		System.out.println("\n");

		B = new int[] { 2, 8, 12 };
		System.out.println(findMedian(A, B));
		B = new int[] { 6, 8, 12 };
		System.out.println(findMedian(A, B));
		B = new int[] { 2, 3, 4 };
		System.out.println(findMedian(A, B));
		B = new int[] { 2, 4, 6 };
		System.out.println(findMedian(A, B));

		A = new int[] { 5, 10, 15 };
		B = new int[] { 20, 25, 35 };
		System.out.println(findMedian(A, B));
		B = new int[] { 12, 25, 35 };
		System.out.println(findMedian(A, B));
		B = new int[] { 10, 12, 35 };
		System.out.println(findMedian(A, B));
		B = new int[] { 1, 2, 35 };
		System.out.println(findMedian(A, B));

		A = new int[] { 5, 10, 15 };
		B = new int[] { 20, 25, 35, 45 };
		System.out.println(findMedian(A, B));
		B = new int[] { 5, 12, 25, 35 };
		System.out.println(findMedian(A, B));
		B = new int[] { 10, 12, 35 };
		System.out.println(findMedian(A, B));
		B = new int[] { 1, 2, 35 };
		System.out.println(findMedian(A, B));
	}

	static double findMedian(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		if (n > m)
			return findMedian(B, A); // Swapping to make A smaller

		int start = 0;
		int end = n;
		int realmidinmergedarray = (n + m + 1) / 2;

		while (start <= end) {
			int mid = (start + end) / 2;
			int leftAsize = mid;
			int leftBsize = realmidinmergedarray - mid;
			int leftA = (leftAsize > 0) ? A[leftAsize - 1] : Integer.MIN_VALUE; // checking overflow of indices
			int leftB = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
			int rightA = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
			int rightB = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;

			// if correct partition is done
			if (leftA <= rightB && leftB <= rightA) {
				if ((m + n) % 2 == 0)
					return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
				return Math.max(leftA, leftB);
			} else if (leftA > rightB) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return 0.0;
	}
}

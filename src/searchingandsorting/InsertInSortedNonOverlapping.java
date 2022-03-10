package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
 */
public class InsertInSortedNonOverlapping {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 2, 4 }, { 8, 10 }, { 11, 13 }, { 17, 20 } };
		int[] nw;
		int[][] up;
		/*
		nw = new int[] { 0, 2 };
		up = merge(arr, nw);
		for (int[] e : up) {
			System.out.println(e[0] + " : " + e[1]);
		}
		nw = new int[] { 0, 1 };
		up = merge(arr, nw);
		for (int[] e : up) {
			System.out.println(e[0] + " : " + e[1]);
		}
		
		nw = new int[] { 5, 7 };
		up = merge(arr, nw);
		for (int[] e : up) {
			System.out.println(e[0] + " : " + e[1]);
		}
		*/
		nw = new int[] { 8, 16 };
		up = merge(arr, nw);
		for (int[] e : up) {
			System.out.println(e[0] + " : " + e[1]);
		}
	}

	static int[][] merge(int[][] ori, int[] nw) {
		int n = ori.length;
		int[][] uArr;
		int iFirst = -1, // useful when new interval is not part of any interval
				iLast = n;
		for (int i = 0; i < n; i++) {
			if (ori[i][1] == nw[0]) {
				// [2, 4] new: [4, 7] -> [2, 7]
				if (iFirst == -1)
					iFirst = i;
				iLast = i;
			}
			if (nw[0] <= ori[i][0] && nw[1] >= ori[i][1]) {
				// [2, 4] new: [1, 5] -> [1, 5]
				if (iFirst == -1)
					iFirst = i;
				iLast = i;
			}
			if (ori[i][0] <= nw[0] && ori[i][1] >= nw[0] ||
			// [2, 4] new: [3, _] -> [2, max(4, _)]
					ori[i][0] <= nw[1] && ori[i][1] >= nw[1]) {
				// [2, 4] new: [_, 3] -> [min(2,_), 4]
				if (iFirst == -1)
					iFirst = i;
				iLast = i;
			}
			if (ori[i][0] >= nw[1]) {
				// [4, 8] new[2, 4], we can end here
				if (iFirst == -1)
					iFirst = i;
				if (iLast == n)
					iLast = i;
				break;
			}
		}
		if (iFirst == iLast) {
			// iFirst and iLast can be equal in the following cases
			// when new interval starts when old interval ends
			if (ori[iFirst][1] == nw[0]) {
				ori[iFirst][1] = nw[1];
			}
			// when new interval completely span an old interval
			else if (nw[0] <= ori[iFirst][0] && nw[1] >= ori[iFirst][1]) {
				ori[iFirst][0] = nw[0];
				ori[iFirst][1] = nw[1];
			}
			// when starting of new interval in between a previous interval
			else if (ori[iFirst][0] <= nw[0] && ori[iFirst][1] >= nw[0]) {
				ori[iFirst][1] = nw[1];
			}
			// when ending of new interval in between a previous interval
			else if (ori[iFirst][0] <= nw[1] && ori[iFirst][1] >= nw[1]) {
				ori[iFirst][0] = nw[0];
			}
			// when interval is not part of any interval
			else if (ori[iFirst][0] == nw[1]) {
				ori[iFirst][0] = nw[0];
			} else {
				uArr = new int[n + 1][2];
				for (int i = 0; i < iFirst; i++) {
					uArr[i][0] = ori[i][0];
					uArr[i][1] = ori[i][1];
				}
				uArr[iFirst][0] = nw[0];
				uArr[iFirst][1] = nw[1];
				for (int i = iFirst + 1; i <= n; i++) {
					uArr[i][0] = ori[i - 1][0];
					uArr[i][1] = ori[i - 1][1];
				}
				ori = uArr;
			}
			return ori;
		} else {
			iFirst = iFirst == -1 ? n : iFirst;
			if (iFirst == n)
				uArr = new int[n + 1][2];
			else
				uArr = new int[n - (iLast - iFirst)][2];
			for (int i = 0; i < iFirst; i++) {
				uArr[i][0] = ori[i][0];
				uArr[i][1] = ori[i][1];
			}
			if (iLast == n) {// last
				uArr[n][0] = nw[0];
				uArr[n][1] = nw[1];
			} else {
				uArr[iFirst][0] = Math.min(nw[0], ori[iFirst][0]);
				uArr[iFirst][1] = Math.max(nw[1], ori[iLast][1]);
			}
			int idx = iFirst + 1;
			for (int i = iLast + 1; i < n; i++) {
				uArr[idx][0] = ori[i][0];
				uArr[idx++][1] = ori[i][1];
			}
			return uArr;
		}

	}
}

package searchingandsorting;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
 */
public class CommonElements {
	public static void main(String[] args) {
		int[] A, B, C;
		A = new int[] { 1, 5, 10, 20, 40, 80 };
		B = new int[] { 6, 7, 20, 80, 100 };
		C = new int[] { 3, 4, 15, 20, 30, 70, 80, 120 };
		System.out.println(commonElements(A, B, C, A.length, B.length, C.length));
	}

	static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
		int i1 = 0, i2 = 0, i3 = 0;
		ArrayList<Integer> out = new ArrayList<>();
		while (i1 < n1 && i2 < n2 && i3 < n3) {
			int num1 = A[i1], num2 = B[i2], num3 = C[i3];
			if (num1 > num2) {
				i2++;
			} else if (num1 > num3) {
				i3++;
			} else {
				if (num1 == num2 && num1 == num3) {
					out.add(num1);
					i1++;
					i2++;
					i3++;
					while (i1 < n1 && A[i1] == num1)
						i1++;
					while (i2 < n2 && B[i2] == num2)
						i2++;
					while (i3 < n3 && C[i3] == num3)
						i3++;
				} else if (num2 > num3)
					i3++;
				else if (num3 > num2)
					i2++;
				else
					i1++;
			}
		}
		return out;
	}
}

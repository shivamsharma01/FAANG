package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/
 */
public class AllSubsetsWithAlternatingElementsFromAB {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("src/arrays/AllSubsetsWithAlternatingElementsFromAB.txt"))));
		int q = Integer.parseInt(read.readLine()), n1, n2;
		String[] data;
		int[] A, B;
		while (q-- > 0) {
			data = read.readLine().split(" ");
			n1 = Integer.parseInt(data[0].trim());
			A = new int[n1];
			n2 = Integer.parseInt(data[1].trim());
			B = new int[n2];
			data = read.readLine().split(" ");
			for (int i = 0; i < n1; i++)
				A[i] = Integer.parseInt(data[i]);
			data = read.readLine().split(" ");
			for (int i = 0; i < n2; i++)
				B[i] = Integer.parseInt(data[i]);
			System.out.println("input arr A -> " + Arrays.toString(A));
			System.out.println("input arr B -> " + Arrays.toString(B));
			int[] AB = new int[n1 + n2];
			generateAllSubsets(A, B, AB, n1, n2, 0, 0, 0, true);
			System.out.println("\n");
		}
		read.close();
	}

	private static void generateAllSubsets(int[] a, int[] b, int[] c, int n1, int n2, int i, int j, int k,
			boolean flag) {
		if (flag) {
			if (k != 0)
				display(c, k);
			for (int idx = i; idx < n1; idx++) {
				if (k == 0) {
					c[k] = a[idx];
					generateAllSubsets(a, b, c, n1, n2, idx + 1, j, k, !flag);
				} else if (c[k] < a[idx]) {
					c[k + 1] = a[idx];
					generateAllSubsets(a, b, c, n1, n2, idx + 1, j, k + 1, !flag);
				}

			}
		} else {
			for (int idx = j; idx < n2; idx++) {
				if (b[idx] > c[k]) {
					c[k + 1] = b[idx];
					generateAllSubsets(a, b, c, n1, n2, i, idx + 1, k + 1, !flag);
				}
			}
		}

	}

	private static void display(int[] arr, int len) {
		for (int i = 0; i <= len; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

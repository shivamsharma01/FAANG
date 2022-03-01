package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 */
public class MaximumProductSubArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaximumProductSubArray.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		long fileAnswer, codeAnswer;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine());
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			fileAnswer = Long.parseLong(read.readLine());
			codeAnswer = new MaximumProductSubArray().maxProduct(arr, n);
			System.out.println(Arrays.toString(arr) + " --> " + fileAnswer);
			if (fileAnswer != codeAnswer) {
				System.out.println(String.format("Your Answer is %d", codeAnswer));
			}
			System.out.println("\n");
		}
		read.close();
	}

	public long maxProduct(int[] arr, int n) {
		if (n == 1)
			return arr[0];
		long max = arr[0], posMax = 1, negMax = 1, temp;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				max = Math.max(0, max);
				posMax = 1;
				negMax = 1;
				continue;
			} else if (arr[i] < 0) {
				if (negMax < 0) {
					temp = posMax * arr[i];
					posMax = negMax * arr[i];
					negMax = temp;
				} else {
					posMax = 1;
					negMax *= arr[i];
				}
			} else {
				posMax *= arr[i];
				negMax *= arr[i];
			}
			max = Math.max(posMax, max);
		}
		return max;
	}
}

package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class MaximumDifference {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaximumDifference.txt"))));
		int q = Integer.parseInt(read.readLine()), n, ans, fileOutput;
		int[] arr;
		String[] data;
		while (q-- > 0) {
			data = read.readLine().split(" ");
			n = Integer.parseInt(data[0]);
			arr = new int[n];
			data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			fileOutput = Integer.parseInt(read.readLine());
			System.out.println(Arrays.toString(arr) + " -> " + fileOutput);
			ans = findMaxDiff(arr, n);
			if (fileOutput != ans)
				System.out.println("incorrect output -> " + ans);
			System.out.println("\n");
		}
		read.close();
	}

	static int findMaxDiff(int arr[], int n) {
		Stack<Integer> s = new Stack<>();
		int[] l = new int[n];
		l[0] = 0;
		s.add(arr[0]);
		for (int i = 1; i < n; i++) {
			while (!s.isEmpty() && s.peek() >= arr[i])
				s.pop();
			l[i] = s.isEmpty() ? 0 : s.peek();
			s.push(arr[i]);
		}
		s = new Stack<>();
		int max = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() >= arr[i])
				s.pop();
			l[i] -= s.isEmpty() ? 0 : s.peek();
			max = Math.max(max, Math.abs(l[i]));
			s.push(arr[i]);
		}
		return max;
	}

}

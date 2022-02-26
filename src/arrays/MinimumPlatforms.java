package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinimumPlatforms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MinimumPlatforms.txt"))));
		int n = Integer.parseInt(read.readLine());
		int[] arr = new int[n];
		String[] data = read.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(data[i]);
		}
		int[] dep = new int[n];
		data = read.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			dep[i] = Integer.parseInt(data[i]);
		}
		read.close();
		System.out.println(findPlatform(arr, dep, n));
	}

	static int findPlatform(int arr[], int dep[], int n) {
		Stack<Integer> mainStack = new Stack<>(), tempStack = new Stack<>();
		mergeSort(arr, dep, 0, n - 1);
		int maxPlatforms = 1;
		mainStack.push(dep[0]);
		for (int i = 1; i < n; i++) {
			while (!mainStack.isEmpty() && mainStack.peek() < arr[i]) {
				mainStack.pop();
			}
			while (!mainStack.isEmpty() && mainStack.peek() < dep[i]) {
				tempStack.push(mainStack.pop());
			}
			mainStack.push(dep[i]);
			while (!tempStack.isEmpty()) {
				mainStack.push(tempStack.pop());
			}
			maxPlatforms = Math.max(maxPlatforms, mainStack.size());
		}
		return maxPlatforms;
	}

	private static void mergeSort(int[] arr, int[] dep, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(arr, dep, start, mid);
			mergeSort(arr, dep, mid + 1, end);
			merge(arr, dep, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] dep, int start, int mid, int end) {
		int[] arrLeft = new int[mid - start + 1], arrRight = new int[end - mid];
		int[] depLeft = new int[mid - start + 1], depRight = new int[end - mid];
		for (int i = 0; i < mid - start + 1; i++) {
			arrLeft[i] = arr[start + i];
			depLeft[i] = dep[start + i];
		}
		for (int i = 0; i < end - mid; i++) {
			arrRight[i] = arr[mid + i + 1];
			depRight[i] = dep[mid + i + 1];
		}
		int i = start, i1 = 0, i2 = 0;
		while (i1 != arrLeft.length && i2 != arrRight.length) {
			if (arrLeft[i1] < arrRight[i2]) {
				arr[i] = arrLeft[i1];
				dep[i++] = depLeft[i1++];
			} else if (arrLeft[i1] > arrRight[i2]) {
				arr[i] = arrRight[i2];
				dep[i++] = depRight[i2++];
			} else {
				if (depLeft[i1] <= depRight[i2]) {
					arr[i] = arrLeft[i1];
					dep[i++] = depLeft[i1++];
				} else {
					arr[i] = arrRight[i2];
					dep[i++] = depRight[i2++];
				}
			}
		}
		while (i1 != arrLeft.length) {
			arr[i] = arrLeft[i1];
			dep[i++] = depLeft[i1++];
		}
		while (i2 != arrRight.length) {
			arr[i] = arrRight[i2];
			dep[i++] = depRight[i2++];
		}
	}
}

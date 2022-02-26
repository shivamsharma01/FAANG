package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * https://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), s = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		subarraySum(arr, n, s);
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int i = 0, j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		while (i != n && j != n) {
			sum += arr[j++];
			if (sum == s) {
				list.add(i + 1);
				list.add(j);
				break;
			} else if (sum > s) {
				sum -= arr[i++];
			}
			if (sum == s) {
				list.add(i + 1);
				list.add(j);
				break;
			}
		}
		while (i != n) {
			sum -= arr[i++];
			if (sum == s) {
				list.add(i);
				list.add(j);
				break;
			}
		}
		if (list.size() == 0)
			list.add(-1);
		return list;
	}
}

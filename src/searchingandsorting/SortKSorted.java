package searchingandsorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
   9
   3 2 4 1 6 5 7 9 8 
   3
   
   output: 1 2 3 4 5 6 7 8 9
 */
public class SortKSorted {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int k = Integer.parseInt(br.readLine());
		// write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i = 0;
		for (i = 0; i <= k; i++)
			pq.add(arr[i]);
		for (; i < arr.length; i++) {
			arr[i - (k + 1)] = pq.poll();
			pq.add(arr[i]);
			System.out.println(arr[i - (k + 1)]);
		}
		i = arr.length - k - 1;
		while (i != arr.length) {
			arr[i] = pq.poll();
			System.out.println(arr[i++]);
		}
	}

}

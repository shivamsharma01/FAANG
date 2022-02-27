package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class MaxProfitSellMultipleTimes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/MaxProfitSellMultipleTimes.txt"))));
		int q = Integer.parseInt(read.readLine());
		while (q-- > 0) {
			int n = Integer.parseInt(read.readLine());
			int[] arr = new int[n];
			String[] data = read.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(data[i]);
				System.out.println(i + " " + arr[i]);

			}
			new MaxProfitSellMultipleTimes().stockBuySell(arr, arr.length);
		}
	}

	public void stockBuySell(int[] price, int n) {
		int left = 0, min = price[0], max = Integer.MIN_VALUE, i = 1;
		while (i != n) {
			if (price[i] > min) {
				if (price[i] >= max) {
					max = price[i];
				} else {
					System.out.print("(" + left + " " + (i - 1) + ") ");
					left = i;
					min = price[i];
					max = Integer.MIN_VALUE;
				}
			} else {
				if (i == left + 1) {
					left = i;
					min = price[i];
				} else {
					System.out.print("(" + left + " " + (i - 1) + ") ");
					left = i;
					min = price[i];
					max = Integer.MIN_VALUE;
				}
			}
			i++;
		}
		if (left != n - 1 && price[n - 1] != price[left])
			System.out.print("(" + left + " " + (n - 1) + ")");
	}
}

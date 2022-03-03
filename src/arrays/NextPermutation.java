package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/NextPermutation.txt"))));
		int q = Integer.parseInt(read.readLine()), n;
		String[] data;
		int[] fileIn, fileAnswer;
		while (q-- > 0) {
			n = Integer.parseInt(read.readLine().trim());
			data = read.readLine().split(" ");
			fileIn = new int[n];
			for (int i = 0; i < n; i++)
				fileIn[i] = Integer.parseInt(data[i]);
			data = read.readLine().split(" ");
			fileAnswer = new int[n];
			for (int i = 0; i < n; i++)
				fileAnswer[i] = Integer.parseInt(data[i]);
			System.out.println(Arrays.toString(fileIn));
			getNextPermutation(fileIn);
			if (!Arrays.toString(fileAnswer).equals(Arrays.toString(fileIn)))
				System.out.println("Invalid solution -> " + Arrays.toString(fileIn));
			System.out.println("\n");
		}
		read.close();
	}

	public static void getNextPermutation(int[] nums) {
		int n = nums.length, index = -1, temp, i = n;
		if (n <= 1)
			return;
		while (--i > 0) {
			if (nums[i] > nums[i - 1]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			i = -1;
			while (++i < n / 2) {
				temp = nums[i];
				nums[i] = nums[n - i - 1];
				nums[n - i - 1] = temp;
			}
		} else {
			int left = index - 1, right = index;
			i = index;
			while (++i < n) {
				if (nums[left] >= nums[i])
					break;
				right = i;
			}
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;

			left = index;
			right = n - 1;
			while (left < right) {
				temp = nums[left];
				nums[left++] = nums[right];
				nums[right--] = temp;
			}
		}
	}
}

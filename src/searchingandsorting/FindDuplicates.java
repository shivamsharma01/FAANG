package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 */
public class FindDuplicates {
	public static void main(String[] args) {
		int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
		findDuplicates(numRay);
	}

	public static void findDuplicates(int[] numRay) {

		for (int i = 0; i < numRay.length; i++) {
			System.out.println(Arrays.toString(numRay));
			numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
			System.out.println(Arrays.toString(numRay));
			System.out.println("==========================");
		}
		System.out.println("The repeating elements are : ");
		for (int i = 0; i < numRay.length; i++) {
			if (numRay[i] >= numRay.length * 2) {
				System.out.println(i + " ");
			}
		}
	}
}

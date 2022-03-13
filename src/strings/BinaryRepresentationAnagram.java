package strings;

/*
 * https://www.geeksforgeeks.org/check-binary-representations-two-numbers-anagram/
 */
public class BinaryRepresentationAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram(4, 8));
		System.out.println(isAnagram(5, 4));
	}

	private static boolean isAnagram(int num1, int num2) {
		int countOneInNum1 = 0, countOneInNum2 = 0;

		while (num1 != 0) {
			if ((num1 & 1) == 1)
				countOneInNum1++;
			num1 /= 2;
		}
		while (num2 != 0) {
			if ((num2 & 1) == 1)
				countOneInNum2++;
			num2 /= 2;
		}

		return countOneInNum1 == countOneInNum2;
	}
}

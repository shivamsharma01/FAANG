package strings;

/*
 * https://www.geeksforgeeks.org/min-flips-of-continuous-characters-to-make-all-characters-same-in-a-string/
 */
public class MinFlips {
	public static void main(String[] args) {
		System.out.println(countMinFlips("0"));
		System.out.println(countMinFlips("1"));
		System.out.println(countMinFlips("00"));
		System.out.println(countMinFlips("11"));
		System.out.println(countMinFlips("0110"));
		System.out.println(countMinFlips("1001"));
		System.out.println(countMinFlips("10101"));
		System.out.println(countMinFlips("01010"));
		System.out.println(countMinFlips("01000010"));
		System.out.println(countMinFlips("01110000"));
		System.out.println(countMinFlips("01110000111"));
	}

	private static int countMinFlips(String s) {
		System.out.print(s + "-> ");
		int oneFlips = 0, zeroFlips = 0, i = 0, n = s.length();
		boolean isRunningZero = s.charAt(0) == '0';
		if (isRunningZero)
			oneFlips = 1;
		else
			zeroFlips = 1;
		while (i < n) {
			if (s.charAt(i++) == '0') {
				if (isRunningZero)
					continue;
				else {
					oneFlips++;
					isRunningZero = true;
				}
			} else {
				if (isRunningZero) {
					zeroFlips++;
					isRunningZero = false;
				} else {
					continue;
				}
			}
		}
		return Math.min(oneFlips, zeroFlips);
	}
}

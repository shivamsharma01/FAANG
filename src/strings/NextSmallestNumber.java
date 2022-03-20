package strings;

/*
 * https://www.geeksforgeeks.org/binary-representation-next-greater-number-number-1s-0s/
 */
public class NextSmallestNumber {
	public static void main(String[] args) {
		System.out.println(nextSmallest("10010"));
		System.out.println(nextSmallest("111000011100111110"));
	}

	private static String nextSmallest(String s) {
		int n = s.length(), oneCount = 0, zeroCount = 0, i = n - 1;
		StringBuilder sb = new StringBuilder(s);
		while (i >= 0 && s.charAt(i) == '0') {
			i--;
			zeroCount++;
		}
		// all zeroes
		if (i == -1)
			return "Not Possible";

		while (i >= 0 && s.charAt(i) == '1') {
			i--;
			oneCount++;
		}
		// binary number of pattern 1111xxxxx
		if (i == -1)
			return "Not Possible";
		sb.setCharAt(i++, '1');
		oneCount--;
		zeroCount++;
		while (zeroCount-- != 0)
			sb.setCharAt(i++, '0');
		while (oneCount-- != 0)
			sb.setCharAt(i++, '1');
		return sb.toString();
	}
}

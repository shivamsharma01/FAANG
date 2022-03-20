package strings;

/*
 * https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 */
public class ConcatenationOfZigZagNRows {
	public static void main(String[] args) {
		System.out.println(convert("ACEGBDFH", 2));
		System.out.println(convert("GEEKSFORGEEKS", 3));
	}

	static String convert(String s, int n) {
		int len = s.length(), i;
		if (n == 1 || len <= 2)
			return s;

		StringBuilder[] sb = new StringBuilder[n];
		for (i = 0; i < n; i++)
			sb[i] = new StringBuilder("");

		i = 0;
		while (i < len) {
			for (int j = 0; j < n && i < len; j++, i++)
				sb[j].append(s.charAt(i));
			for (int j = n - 2; j > 0 && i < len; j--, i++)
				sb[j].append(s.charAt(i));
		}
		for (i = 1; i < n; i++)
			sb[0].append(sb[i]);

		return sb[0].toString();
	}
}

package strings;

/*
 * https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1/#
 */
public class RecursivelyRemoveAdjacentDuplicates {
	public static void main(String[] args) {
		String s = "mississipie";
		char c = '$';
		System.out.println(removeDuplicates(s, c));
		System.out.println("==============");
		s = "abccbccba";
		System.out.println(removeDuplicates(s, c));
		System.out.println("==============");
		s = "abaccddab";
		System.out.println(removeDuplicates(s, c));
		System.out.println("==============");
	}

	private static String removeDuplicates(String s, char ch) {
		if (s == null || s.length() <= 1)
			return s;
		int i = 0;
		while (i < s.length()) {
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				int j = i;
				while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1))
					j++;
				char lastChar = i > 0 ? s.charAt(i - 1) : ch;
				String remStr = removeDuplicates(s.substring(j + 1, s.length()), lastChar);
				s = s.substring(0, i);
				while (remStr.length() > 0 && s.length() > 0 && remStr.charAt(0) == s.charAt(s.length() - 1)) {
					while (remStr.length() > 0 && remStr.charAt(0) != ch
							&& remStr.charAt(0) == s.charAt(s.length() - 1))
						remStr = remStr.substring(1, remStr.length());
					s = s.substring(0, s.length() - 1);
				}
				s = s + remStr;
				i = j;
			} else
				i++;
		}
		return s;
	}
}

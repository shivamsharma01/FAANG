package searchingandsorting;

/*
 * https://www.geeksforgeeks.org/wildcard-character-matching/
 */
public class StringMatchingWithWildCardCharacters {
	public static void main(String[] args) {
		String s1 = "", s2 = "";
		s1 = "g*ks";
		s2 = "geeks"; // Yes
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "ge?ks*";
		s2 = "geeksforgeeks"; // Yes
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "g*k";
		s2 = "gee"; // No because 'k' is not in second
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "*pqrs";
		s2 = "pqrst"; // No because 't' is not in first
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "abc*bcd";
		s2 = "abcdhghgbcd"; // Yes
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "abc*c?d";
		s2 = "abcd"; // No because second must have 2 instances of 'c'
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "*c*d";
		s2 = "abcd"; // Yes
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
		s1 = "*?c*d";
		s2 = "abcd"; // Yes
		System.out.println(isMatch(s1, s2) ? "Yes" : "No");
	}

	private static boolean isMatch(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		if (n1 == 0) {
			if (n2 == 0)
				return true;
			else
				return false;
		}
		if (n1 == 1) {
			if (n2 == 0)
				return s1.charAt(0) == '*';
			else if (n2 == 1)
				return s1.charAt(0) == '*' || s1.charAt(0) == '?' || s1.charAt(0) == s2.charAt(0);
			else
				return s1.charAt(0) == '*';
		}
		if (n2 == 0) {
			return false;
		}
		if (s1.charAt(0) == '?' || s1.charAt(0) == s2.charAt(0))
			return isMatch(s1.substring(1), s2.substring(1));

		return s1.charAt(0) == '*' ? isMatch(s1.substring(1), s2) || isMatch(s1, s2.substring(1)) : false;
	}
}

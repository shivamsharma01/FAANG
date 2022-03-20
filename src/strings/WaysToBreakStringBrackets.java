package strings;

/*
 * https://www.geeksforgeeks.org/print-ways-break-string-bracket-form/
 */
public class WaysToBreakStringBrackets {
	public static void main(String[] args) {
		generateAll("abcde");
	}

	private static void generateAll(String s) {
		int n = s.length();
		generate(s, n, 0, "", ')');
	}

	private static void generate(String s, int n, int i, String startString, char prev) {
		if (i == n) {
			System.out.println(startString + ")");
			return;
		}
		if (prev == '(') {
			generate(s, n, i + 1, startString + ")(" + s.charAt(i), prev);
			generate(s, n, i + 1, startString + s.charAt(i), prev);
		} else {
			generate(s, n, i + 1, startString + "(" + s.charAt(i), '(');
		}
	}
}

package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
 */
public class GenerateAllBinaryStrings {
	public static void main(String[] args) {
		generateWrapper("1??0?101");
	}

	private static void generateWrapper(String input) {
		List<String> l = new ArrayList<>();
		generate(input, input.length(), 0, l, "");
		for (String s : l)
			System.out.println(s);
	}

	private static void generate(String input, int n, int i, List<String> list, String s) {
		if (i == n) {
			list.add(s);
			return;
		}
		char c = input.charAt(i);
		if (c == '?') {
			generate(input, n, i + 1, list, s + "0");
			generate(input, n, i + 1, list, s + "1");
		} else
			generate(input, n, i + 1, list, s + "" + c);
	}
}

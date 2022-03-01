package arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 */
public class FormMinimumUsingIDSequence {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/arrays/FormMinimumUsingIDSequence.txt"))));
		int q = Integer.parseInt(read.readLine());
		String[] data;
		String sequenceFile, answerFile, answerCode;
		while (q-- > 0) {
			data = read.readLine().split(" ");
			sequenceFile = data[0].trim();
			answerFile = data[1].trim();
			answerCode = formMinimum(sequenceFile);
			System.out.println(sequenceFile + " -> " + answerFile);
			if (!answerFile.equals(answerCode)) {
				System.out.println(String.format("Your Answer '%s' is incorrect", answerCode));
			}
			System.out.println("\n");
		}
		read.close();
	}

	private static char intToChar(int i) {
		return (char) (i + '0');
	}

	public static String formMinimum(String input) {
		StringBuilder sb = new StringBuilder("");
		int max = 1, n = input.length();
		Stack<Character> s = new Stack<>();
		if (input.charAt(0) == 'D')
			s.push(intToChar(max++));
		else
			sb.append(intToChar(max++));

		for (int i = 0; i < n;) {
			char c = input.charAt(i);
			if (c == 'I') {
				while (!s.isEmpty())
					sb.append(s.pop());
				int count = 1;
				i++;
				while (i != n && input.charAt(i) == 'I') {
					i++;
					count++;
				}
				if (i == n) {
					for (int j = 1; j <= count; j++)
						sb.append(intToChar(max++));
					count = 0;
				} else {
					for (int j = 1; j < count; j++)
						sb.append(intToChar(max++));
					s.add(intToChar(max++));
				}
			} else {
				s.add(intToChar(max++));
				i++;
			}
		}
		while (!s.isEmpty())
			sb.append(s.pop());
		return sb.toString();
	}
}

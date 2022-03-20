package strings;

import java.util.HashSet;
import java.util.Set;

/*
 * https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 */
public class NumberCustomersThatDidntGetComputer {
	public static void main(String[] args) {
		String s;
		int k;
		s = "ABBAJJKZKZ";
		k = 1;
		System.out.println(getCount(s, k));
	}

	private static int getCount(String s, int k) {
		Set<Character> st = new HashSet<Character>(), ignored = new HashSet<Character>();
		int i = 0, n = s.length(), count = 0;

		while (i != n) {
			char c = s.charAt(i++);
			if (ignored.contains(c)) {
				ignored.remove(c);
				continue;
			} else if (st.contains(c))
				st.remove(c);
			else if (st.size() < k) {
				st.add(c);
			} else {
				count++;
				ignored.add(c);
			}
		}

		return count;
	}
}

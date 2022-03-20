package strings;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
public class LengthOfLongestValidSubstring {
	public static void main(String[] args) {
		System.out.println(getLongest("((()"));
		System.out.println(getLongest(")()())"));
		System.out.println(getLongest("()(()))))"));
		System.out.println(getLongest("((()))"));

	}

	private static int getLongest(String s) {
		int n = s.length();
		int[] dp = new int[n];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				st.push(i);
				dp[i] = n;
			} else {
				dp[i] = st.isEmpty() ? -1 : st.pop();
			}
		}
		int i = n - 1, max = 0, cur = 0;
		while (i > 0) {
			if (dp[i] == n || dp[i] == -1) {
				dp[i] = -1;
				cur = 0;
			} else {
				cur += i - dp[i] + 1;
				i = dp[i];
				max = Math.max(max, cur);
			}
			i--;
		}
		return max;
	}
}

package strings;

/*
 * https://www.geeksforgeeks.org/find-patterns-101-given-string/
 */
public class FindPattern101 {
	public static void main(String[] args) {
		System.out.println(count("100001a11b1011001c101"));
	}

	private static int count(String s) {
		int n = s.length(), i = 0, j = 0, ans = 0;

		while (i < n) {
			while (i < n && s.charAt(i) != '1')
				i++;
			if (i == n)
				break;
			while (i < n && s.charAt(i) == '1')
				i++;
			if (i == n)
				break;
			j = i;
			while (j < n && s.charAt(j) == '0')
				j++;
			if (j == i)
				continue;
			i = j;
			if (i == n)
				break;
			if (s.charAt(i) == '1')
				ans++;
		}
		return ans;
	}
}

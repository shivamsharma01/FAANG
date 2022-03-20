package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/count-total-anagram-substrings/
 */
public class CountTotalAnagrams {
	public static void main(String[] args) {
		System.out.println(countAnagrams("kkkk"));
		System.out.println(countAnagrams("xyyx"));
	}

	private static int countAnagrams(String string) {
		Map<String, Integer> map = new HashMap<>();
		int n = string.length();
		String tempString;
		char[] tempArray;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				tempArray = string.substring(i, j).toCharArray();
				Arrays.sort(tempArray);
				tempString = new String(tempArray);
				map.put(tempString, map.getOrDefault(tempString, 0) + 1);
			}
		}
		int count = 0;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			count += e.getValue() * (e.getValue() - 1) / 2;
		}
		return count;
	}
}

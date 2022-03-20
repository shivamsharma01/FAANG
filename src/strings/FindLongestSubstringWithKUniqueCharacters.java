package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 */
public class FindLongestSubstringWithKUniqueCharacters {
	public static void main(String[] args) {
		System.out.println(getLongestSubstring("aabbcc", 1));
		System.out.println(getLongestSubstring("aabbcc", 2));
		System.out.println(getLongestSubstring("aabbcc", 3));
		System.out.println(getLongestSubstring("aabbcc", 4));
		System.out.println(getLongestSubstring("aaabbbcc", 3));
		System.out.println(getLongestSubstring("aaabbb", 3));
		System.out.println(getLongestSubstring("aaabbbcc", 4));
		System.out.println(getLongestSubstring("aaaa", 2));
		System.out.println(getLongestSubstring("aabacbebebe", 3));
		System.out.println(getLongestSubstring("pxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtacio", 2));
	}

	private static int getLongestSubstring(String s, int k) {
		int[] index = new int[26];
		Arrays.fill(index, -1);
		Set<Character> inSubstring = new HashSet<Character>();
		// start and end instead of length so that we can even print one of the longest
		// substring
		int i = 0, n = s.length(), bestRangeStart = -1, bestRangeEnd = -2, start = 0;
		while (i != n) {
			char c = s.charAt(i);
			if (index[c - 'a'] != -1 || inSubstring.size() < k) {
				// c part of current substring of k unique characters
				inSubstring.add(c);
				index[c - 'a'] = i;
			} else {
				if (inSubstring.size() == k && i - start > bestRangeEnd - bestRangeStart) {
					bestRangeEnd = i;
					bestRangeStart = start;
				}
				start = fillArr(inSubstring, index);
				inSubstring.add(c);
				index[c - 'a'] = i;
			}
			i++;
		}
		if (inSubstring.size() == k && i - start > bestRangeEnd - bestRangeStart) {
			bestRangeEnd = i;
			bestRangeStart = start;
		}
		return bestRangeEnd - bestRangeStart;
	}

	private static int fillArr(Set<Character> inSubstring, int[] index) {
		int j = Integer.MAX_VALUE;
		char toRemove = '\0';
		for (char c : inSubstring) {
			if (index[c - 'a'] < j) {
				j = index[c - 'a'];
				toRemove = c;
			}
		}
		index[toRemove - 'a'] = -1;
		inSubstring.remove(toRemove);
		return j + 1;
	}
}

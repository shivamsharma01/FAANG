package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */
public class SortedDictionaryOfAlienLanguage {
	public static void main(String[] args) {
		String[] words = new String[] { "baa", "abcd", "abca", "cab", "cad" };
		System.out.println(findOrder(words, 5, 4));
		words = new String[] { "caa", "aaa", "aab" };
		System.out.println(findOrder(words, 3, 3));
	}

	public static String findOrder(String[] words, int N, int K) {
		Map<Character, HashSet<Character>> map = new HashMap<>();

		for (int i = 0; i < N - 1; i++) {
			fill(words[i], words[i + 1], map);
		}

		boolean[] visited = new boolean[256];
		Stack<Character> stack = new Stack<>();
		for (Map.Entry<Character, HashSet<Character>> e : map.entrySet()) {
			char cur = e.getKey();
			if (visited[cur] || map.get(cur) == null)
				continue;
			else
				getNodes(visited, cur, map, stack);
		}

		StringBuilder sb = new StringBuilder("");
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	private static void getNodes(boolean[] visited, char curNode, Map<Character, HashSet<Character>> map,
			Stack<Character> stack) {
		visited[curNode] = true;
		for (char later : map.get(curNode)) {
			if (!visited[later] && map.get(later) != null)
				getNodes(visited, later, map, stack);
		}
		stack.add(curNode);
	}

	private static void fill(String s1, String s2, Map<Character, HashSet<Character>> map) {
		int n1 = s1.length(), n2 = s2.length();
		int i1 = 0, i2 = 0;
		char a, b;
		HashSet<Character> set;
		while (i1 != n1 && i2 != n2) {
			a = s1.charAt(i1++);
			b = s2.charAt(i2++);
			if (a != b) {
				set = map.getOrDefault(a, new HashSet<>());
				set.add(b);
				map.put(a, set);
				map.put(b, map.getOrDefault(b, new HashSet<>()));
				return;
			}
		}
	}
}

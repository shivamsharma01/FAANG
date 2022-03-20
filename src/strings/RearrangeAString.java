package strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
 */
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}

public class RearrangeAString {
	public static void main(String[] args) {
		System.out.println(rearrange("geeksforgeeks", 3));
		System.out.println(rearrange("aaa", 3));
	}

	private static String rearrange(String s, int d) {
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		char c;
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			c = s.charAt(i);
			sb.append('\0');
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>>(
				new Comparator<Pair<Character, Integer>>() {
					public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
						return p1.getValue() > p2.getValue() ? -1
								: p1.getValue() < p2.getValue() ? 1 : p1.getKey() - p2.getKey();
					}
				});
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			pq.add(new Pair<Character, Integer>(e.getKey(), e.getValue()));
		}

		Pair<Character, Integer> p;
		int i;
		while (!pq.isEmpty()) {
			p = pq.poll();
			i = 0;
			while (sb.charAt(i) != '\0')
				i++;
			for (int j = 0; j < p.getValue(); j++) {
				if (i + d * j >= n)
					return "Cannot be rearranged";
				sb.setCharAt(i + d * j, p.getKey());
			}
		}
		return sb.toString();
	}

}

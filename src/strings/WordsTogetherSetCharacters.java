package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://www.geeksforgeeks.org/print-words-together-set-characters/
 */
public class WordsTogetherSetCharacters {
	public static void main(String[] args) {
		String words[] = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat",
				"flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle" };
		getCommon(words);
	}

	private static String getMinRepresentation(String inp) {
		final int max = 26;
		boolean[] visited = new boolean[max];

		for (char c : inp.toCharArray())
			visited[c - 'a'] = true;

		StringBuilder key = new StringBuilder("");

		for (int i = 0; i < max; i++)
			if (visited[i])
				key.append((char) (i + 'a'));

		return key.toString();
	}

	private static void getCommon(String[] input) {
		Map<String, List<Integer>> hash = new HashMap<>();

		String key;
		List<Integer> arrList;
		for (int i = 0; i < input.length; i++) {
			key = getMinRepresentation(input[i]);
			if (hash.containsKey(key))
				arrList = hash.get(key);
			else
				arrList = new ArrayList<>();

			arrList.add(i);
			hash.put(key, arrList);

		}
		for (Entry<String, List<Integer>> e : hash.entrySet()) {
			arrList = e.getValue();
			for (Integer i : arrList)
				System.out.print(input[i] + ", ");
			System.out.println();
		}
	}
}

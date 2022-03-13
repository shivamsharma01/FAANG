package strings;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 */
public class FindAnagrams {
	private static ArrayList<ArrayList<String>> solver(ArrayList<String> list) {

		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
		ArrayList<String> tempList;
		for (String str : list) {
			HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				if (tempMap.containsKey(str.charAt(i)))
					tempMap.put(str.charAt(i), tempMap.get(str.charAt(i)) + 1);
				else
					tempMap.put(str.charAt(i), 1);
			}
			if (map.containsKey(tempMap))
				tempList = map.get(tempMap);
			else
				tempList = new ArrayList<String>();
			tempList.add(str);
			map.put(tempMap, tempList);
		}

		ArrayList<ArrayList<String>> result = new ArrayList<>();
		for (ArrayList<String> temp : map.values())
			result.add(temp);
		return result;
	}

	// Drivers Method
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("cat");
		list.add("dog");
		list.add("ogd");
		list.add("god");
		list.add("atc");

		System.out.println(solver(list));
	}
}

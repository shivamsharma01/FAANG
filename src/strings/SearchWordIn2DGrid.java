package strings;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
 */
public class SearchWordIn2DGrid {
	public static void main(String[] args) {
		char grid[][];
		String word;
		word = "GEEKS";
		int[][] ans;

		grid = new char[][] { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'd', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		ans = new Solution().searchWord(grid, word);
		for (int[] a : ans) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("\n\n");

		grid = new char[][] { { 'a' }, { 'd' }, { 'g' }, { 'e' }, { 'g' }, { 'e' } };
		word = "ead";
		ans = new Solution().searchWord(grid, word);
		for (int[] a : ans) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("\n\n");
		grid = new char[][] { { 'a', 'b', 'a', 'e', 'b', 'e', 'e', 'e', 'c', 'c' },
				{ 'a', 'b', 'e', 'c', 'b', 'd', 'e', 'c', 'a', 'd' },
				{ 'e', 'c', 'c', 'c', 'c', 'a', 'd', 'a', 'c', 'b' },
				{ 'e', 'e', 'a', 'd', 'd', 'd', 'c', 'b', 'b', 'b' },
				{ 'b', 'd', 'b', 'a', 'c', 'a', 'b', 'b', 'd', 'd' },
				{ 'c', 'c', 'c', 'd', 'a', 'e', 'a', 'c', 'e', 'b' } };
		word = "bed";
		ans = new Solution().searchWord(grid, word);
		for (int[] a : ans) {
			System.out.println(Arrays.toString(a));
		}
	}

}

class Solution {
	int[] xDir = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int[] yDir = { -1, -1, -1, 0, 0, 1, 1, 1 };

	public int[][] searchWord(char[][] grid, String word) {
		// Code here
		ArrayList<int[]> ans = new ArrayList<>();
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == word.charAt(0)) {
					if (search(grid, word.toCharArray(), 1, i, j, 0, 0))
						ans.add(new int[] { i, j });
				}
			}
		}
		int[][] out = new int[ans.size()][2];
		for (int i = 0; i < ans.size(); i++) {
			out[i][0] = ans.get(i)[0];
			out[i][1] = ans.get(i)[1];
		}
		return out;
	}

	public boolean search(char[][] grid, char[] word, int k, int i, int j, int direction, int m) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return false;
		if (k == word.length && grid[i][j] == word[k - 1])
			return true;

		if (word[k - 1] != grid[i][j])
			return false;

		if (direction == -1)
			return search(grid, word, k + 1, i + yDir[m], j + xDir[m], -1, m);
		boolean found = false;
		for (int pos = 0; pos < 8 && !found; pos++) {
			found = found || search(grid, word, k + 1, i + yDir[pos], j + xDir[pos], -1, pos);
		}
		return found;
	}
}

package arrays;

/*
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
public class RotateBy90AntiClockwise {
	public static void main(String[] args) {
		/*
		 * { 1, 2, 3, 4, 5 }, 
		 * { 6, 7, 8, 9, 10 }, 
		 * { 11, 12, 13, 14, 15 },
		 * { 16, 17, 18, 19, 20 }, 
		 * { 21, 22, 23, 24, 25 } };
		*/
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
		matrix = new int[][] { { 1, 2 }, { 3, 4 } };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
		display(matrix, matrix.length);
		matrix = new int[][] { { 1 } };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
		matrix = new int[][] { {} };
		display(matrix, matrix.length);
		rotateby90(matrix, matrix.length);
		display(matrix, matrix.length);
	}

	static void display(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	static void rotateby90(int matrix[][], int n) {
		for (int i = n - 1; i > (n + 1) / 2 - 1; i--) {
			int left = n - i - 1, right = i, top = left, bottom = right;
			for (int j = i; j >= n - i; j--) {
				int temp = matrix[bottom][right - (i - j)];
				matrix[bottom][right - (i - j)] = matrix[bottom - (i - j)][left];
				matrix[bottom - (i - j)][left] = matrix[top][left + (i - j)];
				matrix[top][left + (i - j)] = matrix[top + (i - j)][right];
				matrix[top + (i - j)][right] = temp;
			}
		}
	}
}

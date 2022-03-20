package strings;

/*
 * https://www.geeksforgeeks.org/find-excel-column-name-given-number/
 */
public class FindExcelColumnNameFromColumnNumber {
	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++)
			System.out.println(i + " -> " + findColName(i));
//		System.out.println(findColName(26));
//		System.out.println(findColName(705));
	}

	private static String findColName(int i) {
		if (i <= 26)
			return new Character((char) ((i - 1) + 'A')).toString();
		if (i % 26 == 0)
			return findColName((i - 1) / 26) + new Character('Z').toString();
		return findColName(i / 26) + findColName(i % 26);
	}
}

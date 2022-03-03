package arrays;

public class SpaceOptimizationBitManipulation {
	public static void main(String[] args) {
		getMultiplesOFAB(2, 10);
		getMultiplesOFAB(20, 150);
	}

	private static void getMultiplesOFAB(int a, int b) {
		if (a == b) {
			System.out.println(a);
			return;
		}
		int size = Math.abs(b - a);
		size = (int) Math.ceil(size / 32.0);
		int[] arrToStoreMultiples = new int[size];
		for (int i = a; i <= b; i++) {
			if (i % 2 == 0 || i % 5 == 0)
				setBit(arrToStoreMultiples, i - a);
		}
		for (int i = a; i <= b; i++) {
			if (checkBit(arrToStoreMultiples, i - a))
				System.out.print(i + " ");
		}
		System.out.println();
	}

	private static boolean checkBit(int[] arrToStoreMultiples, int i) {
		int val = arrToStoreMultiples[i >> 5] & (1 << (i & 31));
		return val == 0 ? false : true;
	}

	private static void setBit(int[] arrToStoreMultiples, int i) {
		arrToStoreMultiples[i >> 5] |= 1 << (i & 31);
	}
}

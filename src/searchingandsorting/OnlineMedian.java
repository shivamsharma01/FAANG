package searchingandsorting;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 */
public class OnlineMedian {

	public static void main(String[] args) {
		int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		printMedian(A, A.length);
	}

	static int signum(int a, int b) {
		return a == b ? 0 : a < b ? -1 : 1;
	}

	static int average(int a, int b) {
		return (a + b) / 2;
	}

	static int getMedian(int e, int m, Heap l, Heap r) {
		int sig = signum(l.getCount(), r.getCount());
		switch (sig) {
		case 0: // The left and right heaps contain same number of elements
			if (e < m) { // current element fits in left (max) heap
				l.insert(e);
				m = l.getTop();
			} else {
				r.insert(e); // current element fits in right (min) heap
				m = r.getTop();
			}
			break;
		case 1: // There are more elements in left (max) heap
			if (e < m) { // current element fits in left (max) heap
				r.insert(l.extractTop()); // Remove top element from left heap and insert into right heap
				l.insert(e); // current element fits in left (max) heap
			} else {
				r.insert(e); // current element fits in right (min) heap
			}
			m = average(l.getTop(), r.getTop()); // Both heaps are balanced
			break;
		case -1: // There are more elements in right (min) heap
			if (e < m) { // current element fits in left (max) heap
				l.insert(e);
			} else {
				l.insert(r.extractTop()); // Remove top element from right heap and insert into left heap
				r.insert(e); // current element fits in right (min) heap
			}
			m = average(l.getTop(), r.getTop()); // Both heaps are balanced
			break;
		}
		return m;
	}

	static void printMedian(int A[], int size) {
		int m = 0; // effective median
		Heap left = new MaxHeap(size / 2);
		Heap right = new MinHeap(size / 2);

		for (int i = 0; i < size; i++) {
			m = getMedian(A[i], m, left, right);
			System.out.println(m +" is median of array:\t"+Arrays.toString(Arrays.copyOf(A, i+1)));
		}
	}

}

// Heap abstract class to avoid code duplication
abstract class Heap {
	private int[] A;

	private int heapSize;

	public Heap(int size) {
		A = new int[size];
		heapSize = -1;
	}

	// We need only these four interfaces of Heap ADT
	abstract boolean insert(int e);

	abstract int getTop();

	abstract int extractTop();

	abstract int getCount();

	abstract boolean comp(int a, int b);

	// We are also using location 0 of array
	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * (i + 1);
	}

	private int parent(int i) {
		return i <= 0 ? -1 : (i - 1) / 2;
	}

	int top() {
		return heapSize >= 0 ? A[0] : -1;
	}

	int count() {
		return heapSize + 1;
	}

	// Heapification
	// Note that, for the current median tracing problem
	// we need to heapify only towards root, always
	void heapify(int i) {
		int p = parent(i);
		
		//minHeap and maxHeap have different comp function
		if (p >= 0 && comp(A[i], A[p])) {
			int temp = A[i];
			A[i] = A[p];
			A[p] = temp;
			heapify(p);
		}
	}

	// Deletes root of heap
	int deleteTop() {
		int del = -1;
		if (heapSize > -1) {
			del = A[0];
			A[0] = A[heapSize];
			A[heapSize] = del;
			heapSize--;
			heapify(parent(heapSize + 1));
		}
		return del;
	}

	// Helper to insert key into Heap
	boolean insertHelper(int key) {
		boolean ret = false;
		if (heapSize < A.length - 1) {
			ret = true;
			heapSize++;
			A[heapSize] = key;
			heapify(heapSize);
		}
		return ret;
	}
}

// Specialization of Heap to define MaxHeap
class MaxHeap extends Heap {

	public MaxHeap(int size) {
		super(size);
	}

	// Wrapper to return root of Max Heap
	int getTop() {
		return top();
	}

	@Override
	int extractTop() {
		return deleteTop();
	}

	@Override
	int getCount() {
		return count();
	}

	@Override
	boolean insert(int key) {
		return insertHelper(key);
	}

	@Override
	boolean comp(int a, int b) {
		return a > b;
	}

}

class MinHeap extends Heap {

	public MinHeap(int size) {
		super(size);
	}

	int getTop() {
		return top();
	}

	int extractTop() {
		return deleteTop();
	}

	int getCount() {
		return count();
	}

	@Override
	boolean insert(int key) {
		return insertHelper(key);
	}

	@Override
	boolean comp(int a, int b) {
		return a < b;
	}

}

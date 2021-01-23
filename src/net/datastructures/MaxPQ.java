package net.datastructures;

//Teacher's MaxPQ
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq; // heap
	private int N = 0; // size in pq[1..N] with pq[0] unused

	public Key[] getPQ() {
		return pq;
	}
	
	// initializes the heap array
	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	// returns if the heap is empty
	public boolean isEmpty() {
		return N == 0;
	}

	// returns size
	public int size() {
		return N;
	}

	// inserts value v into the heap
	public void insert(Key v) {
		pq[++N] = v;   // places at end of array
		swim(N);   // swims up array to proper place
	}

	// deletes and returns the max value
	public Key delMax() {
		Key max = pq[1];
		exch(1, N);
		pq[N] = null;
		N--;
		sink();
		return max;
	}

	// checks if the value at index i is less than the value at index j
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	// exchanges values at index i and j
	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	// brings the item at index k up to its rightful position in heap
	private void swim(int k) {
		// checks when this item is larger than its parent
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}
		
	// sinks the value at index 1 (in the max position
	private void sink() {
		sink(1);
	}
		
	// Teacher's sink method
	// if parent is smaller than child(ren)
	// then parent switches with larger child,
	// until it is in proper place
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			// checks if left child is smaller
			if (j < N && less(j, j + 1))
				j++;
			// breaks if parent is bigger than children
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	

}

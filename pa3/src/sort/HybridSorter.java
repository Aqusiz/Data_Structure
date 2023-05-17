package sort;


import java.lang.reflect.Array;

public class HybridSorter<K extends Comparable<? super K>> {
	InsertionSorter<K> insertionSort = new InsertionSorter<K>();
	QuickSorter<K> quickSort = new QuickSorter<K>();
	private final int RUN = 32;
	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */

	public Pair<K, ?> search(Pair<K,?>[] array, int k) {
		// Fill your code to find k-th element in `array`.
		return null;
	}
	
	public Integer searchKey(Pair<K,?>[] array, String key) {
		// Fill your code to find the value of k for the pair that has the given key as its key value.
		// k represents the k-th element in the sorted `array`.
		return -1;
	}

	
	public void sort(Pair<K, ?>[] array, int left, int right) {
		// Fill your code to sort the elements in `array`.
		

	}
	public Pair<K, ?> first(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find the first element
		// HINT: You might need to implement merge method that merges two sorted arrays
		
		return null;

	}

	public Pair<K, ?> median(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find median element
		// HINT: You might need to implement merge method that merges two sorted arrays

		return null;

		
	}

	public Pair<K, ?> last(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find the last element
		// HINT: You might need to implement merge method that merges two sorted arrays
		
		
		return null;

	}

	
	
	public int min(int a, int b) {
		int res = 0;
		
		if (a > b ) res = b;
		else res = a;
		
		return res;
	}
	

}

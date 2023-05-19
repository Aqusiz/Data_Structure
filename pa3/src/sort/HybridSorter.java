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
		this.sort(array, 0, Array.getLength(array)-1);
		return array[k-1];
	}
	
	public Integer searchKey(Pair<K,?>[] array, String key) {
		// Fill your code to find the value of k for the pair that has the given key as its key value.
		// k represents the k-th element in the sorted `array`.
		this.sort(array, 0, Array.getLength(array)-1);
		for(int i = 0; i < Array.getLength(array); i++) {
			if(key.compareTo(array[i].getKey().toString()) == 0) {
				return i+1;
			}
		}
		return -1;
	}

	
	public void sort(Pair<K, ?>[] array, int left, int right) {
		// Fill your code to sort the elements in `array`.
		if(right - left <= RUN+1) {
			insertionSort.sort(array, left, right);
		}
		else {
			int p = quickSort.partition(array, left, right);
			this.sort(array, left, p-1);
			this.sort(array, p+1, right);
		}
	}

	private Object merge(Pair<K,?>[] array1, Pair<K,?>[] array2) {
		int len1 = Array.getLength(array1);
		int len2 = Array.getLength(array2);

		Object retarr = Array.newInstance(array1[0].getClass(), len1+len2);
		for(int i = 0; i < len2; i++) Array.set(retarr, i, array2[i]);
		for(int i = len2; i < len1+len2; i++) Array.set(retarr, i, array1[i-len2]);

		this.sort((Pair<K,?>[])retarr, 0, len1+len2-1);

		return retarr;
	}

	public Pair<K, ?> first(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find the first element
		// HINT: You might need to implement merge method that merges two sorted arrays
		Object newarr = merge(array1, array2);

		return (Pair<K, ?>)Array.get(newarr, 0);
	}

	public Pair<K, ?> median(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find median element
		// HINT: You might need to implement merge method that merges two sorted arrays
		Object newarr = merge(array1, array2);
		int len = Array.getLength(newarr);
		if(len%2 == 1) return (Pair<K,?>)Array.get(newarr, len/2);
		else {
			Pair<K,?> half = (Pair<K,?>)Array.get(newarr, len/2 - 1);
			Pair<K,?> halfadd1 = (Pair<K,?>)Array.get(newarr, len/2);
			K newKey = (K)(half.getKey().toString() + "-" + halfadd1.getKey().toString());
			String newValue = half.getValue().toString() + "-" + halfadd1.getValue().toString();
			Pair<K, String> med = new Pair<K, String>(newKey, newValue);
			return med;
		}
	}

	public Pair<K, ?> last(Pair<K,?>[] array1, Pair<K,?>[] array2){
		// Fill your code to find the last element
		// HINT: You might need to implement merge method that merges two sorted arrays
		Object newarr = merge(array1, array2);
		int len = Array.getLength(newarr);
		
		return (Pair<K, ?>)Array.get(newarr, len-1);
	}

	
	
	public int min(int a, int b) {
		int res = 0;
		
		if (a > b ) res = b;
		else res = a;
		
		return res;
	}
	

}

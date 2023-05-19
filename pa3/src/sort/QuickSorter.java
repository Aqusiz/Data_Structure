package sort;

public class QuickSorter<K extends Comparable<? super K>>{
	public void sort(Pair<K, ?>[] array, int left, int right) {
		
		// Fill your code to sort the elements in `array`.
		if(right - left < 1) return;
		int p = partition(array, left, right);
		sort(array, left, p-1);
		sort(array, p+1, right);
	}
	
	// Hint: Maybe you need to create the helper methods.
	private void swap(Pair<K, ?>[] array, int a, int b) {
		Pair<K, ?> temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private int findMedianIdx(Pair<K, ?>[] array, int a, int b, int c) {
		K k_a, k_b, k_c;
		k_a = array[a].getKey();
		k_b = array[b].getKey();
		k_c = array[c].getKey();
		if(k_a.compareTo(k_b) < 0) {
			if(k_b.compareTo(k_c) < 0) return b;
			else if(k_a.compareTo(k_c) > 0) return a;
			else return c;
		}
		else {
			if(k_b.compareTo(k_c) > 0) return b;
			else if(k_a.compareTo(k_c) < 0) return a;
			else return c;
		}
	}

	private int findPivotIdx(Pair<K, ?>[] array, int left, int right) {
		return findMedianIdx(array, left, (left+right)/2, right);
	}

	public int partition(Pair<K, ?>[] array, int left, int right) {
		K pivot;
		int p = findPivotIdx(array, left, right);
		pivot = array[p].getKey();

		swap(array, p, right); // pivot element goes to right
		p = left;	// pivot index starts from left
		for(int i = left+1; i < right; i++) {
			if(array[i].getKey().compareTo(pivot) < 0) {
				swap(array, i, p);
				p++;
			}
		}
		swap(array, p, right);
		return p;
	}
}

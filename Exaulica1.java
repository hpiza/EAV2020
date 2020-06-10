public class Exaulica1 {
	
	static long moves = 0;
	
	static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		moves += 3;
	}
	
	static int left(int index) {
		return (index + 1) * 2 - 1;
	}

	static int right(int index) {
		return left(index) + 1;
	}

	static void heapify(int[] array, int root, int heapSize) {
		int l = left(root);
		int r = right(root);
		int m = root;
		if (l < heapSize && array[l] > array[m])
			m = l;
		if (r < heapSize && array[r] > array[m])
			m = r;
		if (m != root) {
			swap(array, root, m);
			heapify(array, m, heapSize);
		}
	}

	public static void buildHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; i--)
			heapify(array, i, array.length);
	}

	public static void heapSort(int[] array) {
		moves = 0;
		buildHeap(array);
		for (int heapSize = array.length; heapSize > 0; heapSize--) {
			swap(array, 0, heapSize - 1);
			heapify(array, 0, heapSize - 1);
		}
	}
	
	static void insertion(int[] array, int start, int delta) {
		for(int i = start + delta; i < array.length; i += delta) {
			int pivot = array[i];
			moves ++;
			int j = i - delta;
			while(j >= start && pivot < array[j]) {
				array[j + delta] = array[j];
				moves ++;
				j -= delta;
			}
			array[j + delta] = pivot;
			moves ++;
		}
	}
	
	public static void shellSort(int[] array) {
		moves = 0;
		int d = 1;
		while(d <= array.length / 3) d = 3 * d + 1;
		while(d >= 1) {
			for(int s = 0; s < d; s ++) insertion(array, s, d);
			d /= 3;
		}
	}

	public static void main(String[] args) {
		for(int N = 1000; N <= 10000; N += 100) {
			double avg1 = 0, avg2 = 0;
			for(int r = 1; r <= N / 10; r ++) {
				int[] array1 = Sesion4.randomArray(N, 0, N);
				int[] array2 = array1.clone();
				shellSort(array1);
				avg1 += moves;
				
				heapSort(array2);
				avg2 += moves;
			}
			avg1 /= (N / 10);
			avg2 /= (N / 10);
			System.out.printf("%d\t%.2f\t%.2f\n", N, avg1, avg2);
		}
	}

}

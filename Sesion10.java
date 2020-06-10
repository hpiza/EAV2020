import java.util.Arrays;

public class Sesion10 {

	// Complejidad temporal: 3N + K = Theta(N + K)
	// Complejidad espacial:  N + K = Theta(N + K)
	public static void countingSort(int[] array, int k) {
		int[] counts = new int[k];
		for (int i = 0; i < array.length; i++) { // Theta(N)
			counts[array[i] - 1]++;
		}
		for (int i = 1; i < counts.length; i++) { // Theta(k)
			counts[i] += counts[i - 1];
		}
		int[] array1 = new int[array.length];			// Theta(N)
		for (int i = array.length - 1; i >= 0; i--) {	
			int pos = counts[array[i] - 1] - 1;
			array1[pos] = array[i];
			counts[array[i] - 1]--;
		}
		for (int i = 0; i < array.length; i++)	// Theta(N)
			array[i] = array1[i];
	}

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 1, 2, 3, 1, 1, 4, 2, 3, 4, 3, 1, 2 };
		countingSort(array, 4);
		System.out.println(Arrays.toString(array));
		final int N = 8_000, k = N * N / 2;
		int[] bigArray = Sesion4.randomArray(N, 1, k);
		long start = System.currentTimeMillis();
		countingSort(bigArray, k);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		// System.out.println(Arrays.toString(bigArray));
	}
}

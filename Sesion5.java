import java.util.Arrays;

public class Sesion5 {

	static class Pair {
		long mov, cmp;
		public Pair(long m, long c) {
			this.mov = m;
			this.cmp = c;
		}
	}
	
	public static Pair insertion(int[] array) {
		long mov = 0, cmp = 0;
		for (int p = 1; p < array.length; p++) {
			int pivot = array[p];					mov ++;
			int i = p - 1;
			while (i >= 0 && ++cmp > 0 && pivot < array[i]) {
				array[i + 1] = array[i];			mov ++;
				i--;
			}
			array[i + 1] = pivot;					mov ++;
		}
//		System.out.printf("%d\t%d\t%d\n", array.length, mov, cmp);
		return new Pair(mov, cmp);
	}
	
	public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i ++) {
			if(array[i] > array[i + 1]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int N = 1_000; N <= 10_000; N += 50) {
			int R = N / 100;
			double avgMov = 0, avgCmp = 0;
			for(int run = 1; run <= R; run ++) {
				int[] array = Sesion4.randomArray(N, -N, N);
				Pair p = insertion(array);				
				avgMov += p.mov;
				avgCmp += p.cmp;
			}
			avgMov /= R;
			avgCmp /= R;
			System.out.printf("%d\t%.1f\t%.1f\n", N, avgMov, avgCmp);
		}
	}
	
	public static void main1(String[] args) {
		int[] array = { 4, 1, 7, 3, 8, 2, 6, 5, 0, 9 };
		insertion(array);
		System.out.println(Arrays.toString(array));
		final int N = 100_000;
		int[] array2 = Sesion4.randomArray(N, -2*N, 2*N);
		
		long start = System.currentTimeMillis();
		insertion(array2);
		long end = System.currentTimeMillis();
		System.out.printf("%.1f\n", (end - start) / 1000.0);
		
		start = System.currentTimeMillis();
		insertion(array2);
		end = System.currentTimeMillis();
		System.out.printf("%.1f\n", (end - start) / 1000.0);

	}

}

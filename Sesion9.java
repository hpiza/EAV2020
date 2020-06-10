import java.util.List;
import java.util.PriorityQueue;

public class Sesion9 {

//	Sea N = array.length
//	T(N) = 2N(log(N)) --> O(N log(N)) amortizado
//	Este método ordena el arreglo de menor a mayor
//	Algoritmo de ordenamiento no IN-PLACE
	static void doSomething(int[] array) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();	// O(1)
		for(int x : array) {				//  N x
			queue.offer(x);					//      O(log(N)) amortizado
		}
		int i = 0;
		while(!queue.isEmpty()) {   		// N x
			array[i ++] = queue.poll();		//		O(log(N))
		}
	}
	
	public static void main(String[] args) {
		for(int N = 100_000; N <= 12_800_000; N *= 2) {
			int[] array = Sesion4.randomArray(N, -N, N);
			double avgTime = 0;
			for(int run = 1; run <= 20; run ++) {
				long start = System.currentTimeMillis();
				doSomething(array);
				long end   = System.currentTimeMillis();
				avgTime += (end - start) / 1000.0;
			}
			avgTime /= 20;
			System.out.printf("%d\t%.3f\n", N / 10_000, avgTime * 10);
		}

	}

}

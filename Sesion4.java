public class Sesion4 {

	static long sumCount = 0;
	
	static int sumSumsV1(int[] array) {
		sumCount = 0;
		int sumG = 0;
		for(int m = 0; m < array.length; m ++) {
			int sumP = 0;
			for(int k = 0; k <= m; k ++) {
				sumP += array[k];
				sumCount ++;
			}
			sumG += sumP;
			sumCount ++;
		}
		return sumG;
	}
	
	public static int random(int a, int b) {
		return a + (int) ((b - a + 1) * Math.random());
	}
	
	public static int[] randomArray(int N, int a, int b) {
		int[] array = new int[N];
		for(int i = 0; i < N; i ++) {
			array[i] = random(a, b);
		}
		return array;
	}
	
	public static void main(String[] args) {
		for(int N = 5000; N <= 640_000; N *= 2) {
			int[] array = randomArray(N, -5, 5);
//			long start = System.currentTimeMillis();
			sumSumsV1(array);
//			long end = System.currentTimeMillis();
//			double seconds = (end - start) / 1000.0;
			System.out.printf("%d\t%d\n", N, sumCount);
		}
//		int[] array1 = { 5, 1, 7, 8, 6, 4 };
//		System.out.println(sumSumsV1(array1));
//		int[] array2 = randomArray(100, 1, 3);
//		System.out.println(Arrays.toString(array2));
//		sumSumsV1(array2);
//		System.out.println(sumCount);
	}

}

	
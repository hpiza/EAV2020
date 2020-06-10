import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Sesion8 {

//	1) Crea un ArrayList<Double> y añade N ≥ 100,000 números aleatorios ordenados: 
//		El elemento k almacena el valor: k + random().
//	2) Repite el paso 1 con un  LinkedList<Double>.
//	3) Calcular el promedio del contenido del ArrayList, visitando a cada elemento con el método get(i).
//	4) Repite el paso 3 con el LinkedList<Double>.
	
	public static void main(String[] args) {
		long start, end;
		final int N = 200_000;
		
		start = System.currentTimeMillis();
		List<Double> aList = new ArrayList<>();
		for(int k = 0; k < N; k ++) aList.add(k + Math.random());
		end = System.currentTimeMillis();
		System.out.printf("Paso 1: %.2f\n", (end - start) / 1000.0);
		
		start = System.currentTimeMillis();
		List<Double> lList = new LinkedList<>();
		for(int k = 0; k < N; k ++) lList.add(k + Math.random());
		end = System.currentTimeMillis();
		System.out.printf("Paso 2: %.2f\n", (end - start) / 1000.0);
		
		start = System.currentTimeMillis();
		double avg1 = 0;
		for(int k = 0; k < N; k ++) avg1 += aList.get(k);
		avg1 /= N;
		end = System.currentTimeMillis();
		System.out.printf("Paso 3: %.2f\n", (end - start) / 1000.0);
		
//		El algoritmo es CUADRÁTICO, porque get(k) es lineal
//		start = System.currentTimeMillis();
		double avg2 = 0;
//		for(int k = 0; k < N; k ++) avg2 += lList.get(k);
//		avg2 /= N;
//		end = System.currentTimeMillis();
//		System.out.printf("Paso 4: %.2f\n", (end - start) / 1000.0);
		
//		Calcular el promedio (pasos 3, 4) utilizando ciclo for-each y ambas listas: LINEALES
		start = System.currentTimeMillis();
		avg1 = 0;
		for(double x : aList) avg1 += x;
		avg1 /= N;		
		end = System.currentTimeMillis();
		System.out.printf("Paso 5a: %.2f\n", (end - start) / 1000.0);
		
		start = System.currentTimeMillis();
		avg2 = 0;
		for(double x : lList) avg2 += x;
		avg2 /= N;
		end = System.currentTimeMillis();
		System.out.printf("Paso 5b: %.2f\n", (end - start) / 1000.0);
		
//		Insertar N datos en la mitad del ArrayList: CUADRÁTICO
		start = System.currentTimeMillis();
		for(int k = 0; k < aList.size(); k += 2) {		// N x 
			double x = aList.get(k);					//    Theta(1)
			aList.add(k + 1, x + Math.random() / 4);	//    O(N), Theta(k)    
		}
		end = System.currentTimeMillis();
		System.out.printf("Paso 6: %.2f\n", (end - start) / 1000.0);
		
//		100000, 1.21
//		200000, 3.37
//		400000, 15.26
//		800000, 94.93
		
//		Insertar N datos en la mitad con LinkedList e iteradores: LINEAL
		start = System.currentTimeMillis();
		ListIterator<Double> ite = lList.listIterator();
		while(ite.hasNext()) {							// N x
			double d = ite.next();						//      Theta(1)
			ite.add(d + Math.random() / 4);				// 		Theta(1)
		}
		end = System.currentTimeMillis();
		System.out.printf("Paso 7: %.2f\n", (end - start) / 1000.0);
		
		
//		Insertar N datos en la mitad con ArrayList e iteradores: CUADRÁTICO
		start = System.currentTimeMillis();
		ite = aList.listIterator();
		while(ite.hasNext()) {							// N x
			double d = ite.next();						//     Theta(1)
			ite.add(d + Math.random() / 4);				//     O(N)
		}
		end = System.currentTimeMillis();
		System.out.printf("Paso 8: %.2f\n", (end - start) / 1000.0);
	}

}

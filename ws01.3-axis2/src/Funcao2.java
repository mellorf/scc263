public class Funcao2 {

	public boolean maiorPrimo(int numero) { 
		int counter = 0;

		for (int i = 2; i <= numero; i++) {
			if (numero % i == 0)
				counter++;
		}

		return counter == 1 ? true : false;
	}

	public long cpuTest(int numero) {
		double w = 1;
		long start = System.currentTimeMillis();

		for (int i = 0; i < numero; i++)
		for (int j = 0; j < numero; j++)
		for (int k = 0; k < numero; k++) {
			w *= k + j / (i+1);
			System.out.println("testing...");
		}

		long end = System.currentTimeMillis();
		return end-start;
	}
}

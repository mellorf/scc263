public class Funcao {

	public boolean maiorPrimo(int numero) { 
		int counter = 0;

		for (int i = 2; i <= numero; i++) {
			if (numero % i == 0)
				counter++;
		}

		return counter == 1 ? true : false;
	}
}

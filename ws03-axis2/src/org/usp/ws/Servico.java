package org.usp.ws;

public class Servico {
	public int soma(int valor1, int valor2) {
		return valor1 + valor2;
	} 

	public JavaBean getJavaBean(int codigo, String nome) {	
		return new JavaBean(codigo, nome);
	}
}

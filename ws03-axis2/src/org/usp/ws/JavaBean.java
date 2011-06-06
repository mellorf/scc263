package org.usp.ws;

public class JavaBean {
	private int codigo;
	private String nome;

	public JavaBean() { }
	public JavaBean(int codigo, String nome) { 
		setCodigo(codigo);
		setNome(nome);
	}

	public void setCodigo(int codigo) { this.codigo = codigo; }
	public void setNome(String nome) { this.nome = nome; }
	public int getCodigo() { return this.codigo; }
	public String getNome() { return this.nome; }
}

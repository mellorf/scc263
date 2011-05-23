package usp;

public class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;

	public Pessoa() {}

	public void setNome(String nome) { this.nome = nome; }
	public void setEndereco(String endereco) { this.endereco = endereco; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public void setEmail(String email) { this.email = email; }

	public String getNome() { return this.nome; }
	public String getEndereco() { return this.endereco; }
	public String getTelefone() { return this.telefone; }
	public String getEmail() { return this.email; }
}

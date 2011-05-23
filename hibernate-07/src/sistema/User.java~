package sistema;

import java.util.*;

public class User {
	// atributos
	private Long id;
	private String name;
	private String login;
	private String passwd;

	public User() {}

	private void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setLogin(String login) { this.login = login; }
	public void setPasswd(String passwd) { this.passwd = passwd; }

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getLogin() { return login; }
	public String getPasswd() { return passwd; }

	// Relacao com Conta
	// Set não duplica elementos
	private Set contas = new HashSet();
	public Set getContas() { return contas; }
	public void setContas(Set contas) { this.contas = contas; }

	private Set emailAddresses = new HashSet();
	public Set getEmailAddresses() { return emailAddresses; }
	public void setEmailAddresses(Set emailAddresses) { this.emailAddresses = emailAddresses; }
}

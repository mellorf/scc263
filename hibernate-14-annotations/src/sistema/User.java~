package sistema;

import java.util.*;
import java.io.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
@Table(name="tuser")
public class User implements Serializable {
	@Id
	@Column(name="uid", unique=true, nullable=false)
        @SequenceGenerator(name = "seq_uid", sequenceName = "seq_uid")
        @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_uid")
	private Long uid;
	@Column(name="name", nullable=false, length=80)
	private String name;
	@Column(name="login", nullable=false, length=50)
	private String login;
	@Column(name="passwd", nullable=false, length=15)
	private String passwd;

	public User() {}

	public void setId(Long uid) { this.uid = uid; }
	public void setName(String name) { this.name = name; }
	public void setLogin(String login) { this.login = login; }
	public void setPasswd(String passwd) { this.passwd = passwd; }

	public Long getId() { return this.uid; }
	public String getName() { return this.name; }
	public String getLogin() { return this.login; }
	public String getPasswd() { return this.passwd; }

	@ManyToMany
	@JoinTable(
			name="tuser_tconta",
			joinColumns = { 
				@JoinColumn(name="uid", unique = true)
			},
			inverseJoinColumns = { 
				@JoinColumn(name="cid")
			}
		)
	private Set<Conta> contas = new HashSet<Conta>();
	public Set<Conta> getContas() { return this.contas; }
	public void setContas(Set<Conta> contas) { this.contas = contas; }


	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tuser_tdetail", 
			joinColumns = { 
				@JoinColumn(name = "uid") 
			}, 
			inverseJoinColumns = { 
				@JoinColumn(name = "information") 
			}
		)*/
	@OneToMany
	@JoinColumn (name = "uid")
	private Set<Detail> details = new HashSet<Detail>();
	public Set<Detail> getDetails() { return this.details; }
	public void setDetails(Set<Detail> details) { this.details = details; }
}

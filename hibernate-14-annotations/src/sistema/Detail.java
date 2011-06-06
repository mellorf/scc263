package sistema;

import java.util.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="tdetail")
public class Detail implements java.io.Serializable {
	@Id
	@Column(name="did", unique=true, nullable=false)
        @SequenceGenerator(name = "seq_did", sequenceName = "seq_did")
        @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_did")
	private Long did;

	@Column(name="information", nullable=false)
	private String information;

	public Detail() {}

	private void setId(Long did) { this.did = did; }
	public void setInformation(String information) { this.information = information; }

	public Long getId() { return this.did; }
	public String getInformation() { return this.information; }

	@ManyToOne
        @JoinColumn (name="uid", nullable = false, updatable = false, insertable = false)
	private User user;
	public User getUser() { return this.user; }
}

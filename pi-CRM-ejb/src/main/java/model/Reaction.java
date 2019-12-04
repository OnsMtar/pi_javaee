package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Reaction database table.
 * 
 */
@Entity
@NamedQuery(name="Reaction.findAll", query="SELECT r FROM Reaction r")
public class Reaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private int status;

	public Reaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
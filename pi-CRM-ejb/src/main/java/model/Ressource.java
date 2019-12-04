package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ressource database table.
 * 
 */
@Entity
@NamedQuery(name="Ressource.findAll", query="SELECT r FROM Ressource r")
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String nom;

	private double quantite;

	private String type;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	@JoinColumn(name="agent_id")
	private Agent agent;

	public Ressource() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public double getQuantite() {
		return this.quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
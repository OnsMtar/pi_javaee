package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Agent database table.
 * 
 */
@Entity
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private int heureTravail;

	private String nom;

	private int numTel;

	private String prenom;

	private String status;

	private String type;
	@Column(name= "hello")
	private String hello ;
	//bi-directional many-to-one association to Ressource
	@OneToMany(mappedBy="agent")
	private List<Ressource> ressources;

	//bi-directional many-to-one association to Tache
	@OneToMany(mappedBy="agent")
	private List<Tache> taches;

	public Agent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeureTravail() {
		return this.heureTravail;
	}

	public void setHeureTravail(int heureTravail) {
		this.heureTravail = heureTravail;
	}

	
	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public Ressource addRessource(Ressource ressource) {
		getRessources().add(ressource);
		ressource.setAgent(this);

		return ressource;
	}

	public Ressource removeRessource(Ressource ressource) {
		getRessources().remove(ressource);
		ressource.setAgent(null);

		return ressource;
	}

	public List<Tache> getTaches() {
		return this.taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Tache addTach(Tache tach) {
		getTaches().add(tach);
		tach.setAgent(this);

		return tach;
	}

	public Tache removeTach(Tache tach) {
		getTaches().remove(tach);
		tach.setAgent(null);

		return tach;
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

}
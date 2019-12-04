package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SousOffres database table.
 * 
 */
@Entity
@Table(name="SousOffres")
@NamedQuery(name="SousOffre.findAll", query="SELECT s FROM SousOffre s")
public class SousOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String description;

	private String nom;

	private double prix;

	public SousOffre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
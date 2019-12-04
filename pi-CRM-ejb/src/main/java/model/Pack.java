package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Pack database table.
 * 
 */
@Entity
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String description;

	private String nom;

	private double prix;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="packs")
	private List<Produit> produits;

	public Pack() {
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

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
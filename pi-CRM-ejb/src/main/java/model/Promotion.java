package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Promotions database table.
 * 
 */
@Entity
@Table(name="Promotions")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String code;

	private String description;

	private String nom;

	private double prix;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="promotion")
	private List<Produit> produits;

	public Promotion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setPromotion(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setPromotion(null);

		return produit;
	}

}
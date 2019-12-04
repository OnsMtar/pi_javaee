package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SousCategorie database table.
 * 
 */
@Entity
@NamedQuery(name="SousCategorie.findAll", query="SELECT s FROM SousCategorie s")
public class SousCategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="sousCategorie")
	private List<Produit> produits;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie_nom")
	private Categorie categorie;

	public SousCategorie() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setSousCategorie(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setSousCategorie(null);

		return produit;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
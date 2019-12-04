package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="QteEntrante")
	private double qteEntrante;

	@Column(name="QteSortante")
	private double qteSortante;

	//bi-directional one-to-one association to Boutique
	@OneToOne(mappedBy="stock")
	private Boutique boutique;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="stock")
	private List<Produit> produits;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="fournisseur_id")
	private Fournisseur fournisseur;

	public Stock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQteEntrante() {
		return this.qteEntrante;
	}

	public void setQteEntrante(double qteEntrante) {
		this.qteEntrante = qteEntrante;
	}

	public double getQteSortante() {
		return this.qteSortante;
	}

	public void setQteSortante(double qteSortante) {
		this.qteSortante = qteSortante;
	}

	public Boutique getBoutique() {
		return this.boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setStock(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setStock(null);

		return produit;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}
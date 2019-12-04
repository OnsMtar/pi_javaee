package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String description;

	private String image;

	private String nom;

	private double prix;

	//bi-directional many-to-many association to Devi
	@ManyToMany
	@JoinTable(
		name="ProduitDevis"
		, joinColumns={
			@JoinColumn(name="ProduitId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="DevisId")
			}
		)
	private List<Devi> devis;

	//bi-directional many-to-many association to Pack
	@ManyToMany
	@JoinTable(
		name="ProduitPacks"
		, joinColumns={
			@JoinColumn(name="ProduitId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PackId")
			}
		)
	private List<Pack> packs;

	//bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="promotion_id")
	private Promotion promotion;

	//bi-directional many-to-one association to SousCategorie
	@ManyToOne
	@JoinColumn(name="souscategorie_nomC")
	private SousCategorie sousCategorie;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="Stock_id")
	private Stock stock;

	//bi-directional many-to-one association to ProduitOffre
	@OneToMany(mappedBy="produit")
	private List<ProduitOffre> produitOffres;

	public Produit() {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<Devi> getDevis() {
		return this.devis;
	}

	public void setDevis(List<Devi> devis) {
		this.devis = devis;
	}

	public List<Pack> getPacks() {
		return this.packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public SousCategorie getSousCategorie() {
		return this.sousCategorie;
	}

	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<ProduitOffre> getProduitOffres() {
		return this.produitOffres;
	}

	public void setProduitOffres(List<ProduitOffre> produitOffres) {
		this.produitOffres = produitOffres;
	}

	public ProduitOffre addProduitOffre(ProduitOffre produitOffre) {
		getProduitOffres().add(produitOffre);
		produitOffre.setProduit(this);

		return produitOffre;
	}

	public ProduitOffre removeProduitOffre(ProduitOffre produitOffre) {
		getProduitOffres().remove(produitOffre);
		produitOffre.setProduit(null);

		return produitOffre;
	}

}
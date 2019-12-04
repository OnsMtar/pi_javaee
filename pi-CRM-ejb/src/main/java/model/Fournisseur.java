package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Fournisseurs database table.
 * 
 */
@Entity
@Table(name="Fournisseurs")
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String mail;

	private String nom;

	private String nomProduit;

	private int numTel;

	private String prenom;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="fournisseur")
	private List<Stock> stocks;

	public Fournisseur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setFournisseur(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setFournisseur(null);

		return stock;
	}

}
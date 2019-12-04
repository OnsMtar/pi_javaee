package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Boutique database table.
 * 
 */
@Entity
@NamedQuery(name="Boutique.findAll", query="SELECT b FROM Boutique b")
public class Boutique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String adresse;

	private Date dateFerm;

	private Date dateOuv;

	private String nom;

	private String site;

	private String type;

	//bi-directional one-to-one association to Stock
	@OneToOne
	@JoinColumn(name="Id")
	private Stock stock;

	public Boutique() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}






	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateFerm() {
		return dateFerm;
	}

	public void setDateFerm(Date dateFerm) {
		this.dateFerm = dateFerm;
	}

	public Date getDateOuv() {
		return dateOuv;
	}

	public void setDateOuv(Date dateOuv) {
		this.dateOuv = dateOuv;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
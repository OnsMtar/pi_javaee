package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Devis database table.
 * 
 */
@Entity
@Table(name="Devis")
@NamedQuery(name="Devi.findAll", query="SELECT d FROM Devi d")
public class Devi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private Date dateDevis;

	private double prixTotal;

	private double prixUnitaire;

	private double quantite;

	//bi-directional many-to-one association to ClientMoral
	@ManyToOne
	@JoinColumn(name="cl_id")
	private ClientMoral clientMoral;

	//bi-directional many-to-one association to ClientPhysique
	@ManyToOne
	@JoinColumn(name="cp_id")
	private ClientPhysique clientPhysique;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="devis")
	private List<Produit> produits;

	public Devi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Date getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
	}

	public double getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getQuantite() {
		return this.quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public ClientMoral getClientMoral() {
		return this.clientMoral;
	}

	public void setClientMoral(ClientMoral clientMoral) {
		this.clientMoral = clientMoral;
	}

	public ClientPhysique getClientPhysique() {
		return this.clientPhysique;
	}

	public void setClientPhysique(ClientPhysique clientPhysique) {
		this.clientPhysique = clientPhysique;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
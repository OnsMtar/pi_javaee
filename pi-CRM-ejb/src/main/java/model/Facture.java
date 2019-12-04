package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private Date datecommande;

	private Date datepaiement;

	private String description;

	private double prixTotal;

	private double prixUnitaire;

	private double tva;

	//bi-directional many-to-one association to ClientMoral
	@ManyToOne
	@JoinColumn(name="cl_id")
	private ClientMoral clientMoral;

	//bi-directional many-to-one association to ClientPhysique
	@ManyToOne
	@JoinColumn(name="cp_id")
	private ClientPhysique clientPhysique;

	public Facture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Date getDatecommande() {
		return datecommande;
	}

	public void setDatecommande(Date datecommande) {
		this.datecommande = datecommande;
	}

	public Date getDatepaiement() {
		return datepaiement;
	}

	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public double getTva() {
		return this.tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
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

}
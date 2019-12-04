package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ProduitOffres database table.
 * 
 */
@Entity
@Table(name="ProduitOffres")
@NamedQuery(name="ProduitOffre.findAll", query="SELECT p FROM ProduitOffre p")
public class ProduitOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProduitOffrePK id;

	//bi-directional many-to-one association to Offre
	@ManyToOne
	@JoinColumn(name="offre_nom")
	private Offre offre;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ProduitId",insertable=false,updatable=false)
	private Produit produit;

	public ProduitOffre() {
	}

	public ProduitOffrePK getId() {
		return this.id;
	}

	public void setId(ProduitOffrePK id) {
		this.id = id;
	}

	public Offre getOffre() {
		return this.offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProduitOffres database table.
 * 
 */
@Embeddable
public class ProduitOffrePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProduitId", insertable=false, updatable=false)
	private int produitId;

	@Column(name="OffreId")
	private int offreId;

	public ProduitOffrePK() {
	}
	public int getProduitId() {
		return this.produitId;
	}
	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}
	public int getOffreId() {
		return this.offreId;
	}
	public void setOffreId(int offreId) {
		this.offreId = offreId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProduitOffrePK)) {
			return false;
		}
		ProduitOffrePK castOther = (ProduitOffrePK)other;
		return 
			(this.produitId == castOther.produitId)
			&& (this.offreId == castOther.offreId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.produitId;
		hash = hash * prime + this.offreId;
		
		return hash;
	}
}
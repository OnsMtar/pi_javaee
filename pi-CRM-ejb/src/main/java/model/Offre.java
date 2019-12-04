package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Offre database table.
 * 
 */
@Entity
@NamedQuery(name="Offre.findAll", query="SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	//bi-directional many-to-one association to ProduitOffre
	@OneToMany(mappedBy="offre")
	private List<ProduitOffre> produitOffres;

	public Offre() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProduitOffre> getProduitOffres() {
		return this.produitOffres;
	}

	public void setProduitOffres(List<ProduitOffre> produitOffres) {
		this.produitOffres = produitOffres;
	}

	public ProduitOffre addProduitOffre(ProduitOffre produitOffre) {
		getProduitOffres().add(produitOffre);
		produitOffre.setOffre(this);

		return produitOffre;
	}

	public ProduitOffre removeProduitOffre(ProduitOffre produitOffre) {
		getProduitOffres().remove(produitOffre);
		produitOffre.setOffre(null);

		return produitOffre;
	}

}
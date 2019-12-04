package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	//bi-directional many-to-one association to SousCategorie
	@OneToMany(mappedBy="categorie")
	private List<SousCategorie> sousCategories;

	public Categorie() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SousCategorie> getSousCategories() {
		return this.sousCategories;
	}

	public void setSousCategories(List<SousCategorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public SousCategorie addSousCategory(SousCategorie sousCategory) {
		getSousCategories().add(sousCategory);
		sousCategory.setCategorie(this);

		return sousCategory;
	}

	public SousCategorie removeSousCategory(SousCategorie sousCategory) {
		getSousCategories().remove(sousCategory);
		sousCategory.setCategorie(null);

		return sousCategory;
	}

}
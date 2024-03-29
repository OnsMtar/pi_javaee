package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ClientMoral database table.
 * 
 */
@Entity
@NamedQuery(name="ClientMoral.findAll", query="SELECT c FROM ClientMoral c")
public class ClientMoral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String adresse;

	private int codeFiscal;

	private String mail;

	private String nom;

	private int numTel;

	private String password;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="clientMoral")
	private List<Commentaire> commentaires;

	//bi-directional many-to-one association to Devi
	@OneToMany(mappedBy="clientMoral")
	private List<Devi> devis;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="clientMoral")
	private List<Facture> factures;

	//bi-directional many-to-one association to Reclamation
	@OneToMany(mappedBy="clientMoral")
	private List<Reclamation> reclamations;

	public ClientMoral() {
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



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCodeFiscal() {
		return this.codeFiscal;
	}

	public void setCodeFiscal(int codeFiscal) {
		this.codeFiscal = codeFiscal;
	}

	



	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}



	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setClientMoral(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setClientMoral(null);

		return commentaire;
	}

	public List<Devi> getDevis() {
		return this.devis;
	}

	public void setDevis(List<Devi> devis) {
		this.devis = devis;
	}

	public Devi addDevi(Devi devi) {
		getDevis().add(devi);
		devi.setClientMoral(this);

		return devi;
	}

	public Devi removeDevi(Devi devi) {
		getDevis().remove(devi);
		devi.setClientMoral(null);

		return devi;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setClientMoral(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setClientMoral(null);

		return facture;
	}

	public List<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		getReclamations().add(reclamation);
		reclamation.setClientMoral(this);

		return reclamation;
	}

	public Reclamation removeReclamation(Reclamation reclamation) {
		getReclamations().remove(reclamation);
		reclamation.setClientMoral(null);

		return reclamation;
	}

}
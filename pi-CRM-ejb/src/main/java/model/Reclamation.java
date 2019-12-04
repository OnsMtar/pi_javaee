package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Reclamation database table.
 * 
 */
@Entity
@NamedQuery(name="Reclamation.findAll", query="SELECT r FROM Reclamation r")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String contenu;

	private Date dateDebut;

	private Date dateFin;

	private String objet;

	private String status;

	private String type;

	//bi-directional many-to-one association to ClientMoral
	@ManyToOne
	@JoinColumn(name="ClientMoralFK")
	private ClientMoral clientMoral;

	//bi-directional many-to-one association to ClientPhysique
	@ManyToOne
	@JoinColumn(name="ClientPhysiqueFK")
	private ClientPhysique clientPhysique;

	public Reclamation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String contenu;

	//bi-directional many-to-one association to ClientMoral
	@ManyToOne
	@JoinColumn(name="cl_id")
	private ClientMoral clientMoral;

	//bi-directional many-to-one association to ClientPhysique
	@ManyToOne
	@JoinColumn(name="cp_id")
	private ClientPhysique clientPhysique;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;

	public Commentaire() {
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

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
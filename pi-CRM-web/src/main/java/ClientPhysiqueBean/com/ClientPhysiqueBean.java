package ClientPhysiqueBean.com;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.ClientPhysique;
import services.com.ClientPhysiqueService;


@ManagedBean(name="clientPhysiqueBean")
public class ClientPhysiqueBean implements Serializable {


	private String adresse;
	private Date dateNaissance;
	private String mail;
	private String nom;
	private int numTel;

	private String password;

	private String prenom;
	
	@EJB
	ClientPhysiqueService ServiceClientPhy;
	
	
	public void addClientPhy() {
		ServiceClientPhy.ajouterClientPhysique(new ClientPhysique(adresse, dateNaissance, mail, nom, numTel, password, prenom));
	}
	
	
	private List<ClientPhysique> clientsphy;
	
	/*public List<ClientPhysique> getClientsP(){
		clientsphy=ServiceClientPhy.getAllClientsPhy();
		return clientsphy;
		
	}*/
	
	
	
	public List<ClientPhysique> getClientsphy() {
		clientsphy=ServiceClientPhy.getAllClientsPhy();
		return clientsphy;
	}


	public void setClientsphy(List<ClientPhysique> clientsphy) {
		this.clientsphy = clientsphy;
	}


	

	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public ClientPhysiqueService getServiceClientPhy() {
		return ServiceClientPhy;
	}

	public void setServiceClientPhy(ClientPhysiqueService serviceClientPhy) {
		ServiceClientPhy = serviceClientPhy;
	}
	
	
}

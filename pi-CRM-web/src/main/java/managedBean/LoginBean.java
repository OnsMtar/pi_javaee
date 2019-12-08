package managedBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import interfaces.IClientMoral;
import interfaces.IClientPhysique;
import interfaces.IGestionnaire;
import model.ClientMoral;
import model.ClientPhysique;
import model.Gestionnaire;
import utils.Mail;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {

	public static boolean loggedIn;
	public static String role;
	private Gestionnaire gestionnaire;
	private String mail, password;
	private Integer formType;
	private String newMail;
	private String newPassword;
	private Integer newNum;
	private String newNom;
	private String newAdresse;
	private ClientPhysique newClientPhysique;
	private ClientMoral newClientMoral;
	@EJB
	IGestionnaire gs;
	@EJB
	IClientPhysique cp;
	@EJB
	IClientMoral cm;

	@PostConstruct
	private void init() {
		formType = 1;
		role = "";
		loggedIn = false;
		newClientMoral = new ClientMoral();
		newClientPhysique = new ClientPhysique();
	}

	public String signIn() {
		if (gs.Login(mail, passwordEncryption(password)) != null) {
			loggedIn = true;
			role = "Admin";
			return "/xhtml/AccountsMorale?faces-redirect=true";
		}
		if (cp.Login(mail, passwordEncryption(password)) != null) {
			formType=2;
			loggedIn = true;
			role = "User";
			newClientPhysique = cp.Login(mail, passwordEncryption(password));
			return "/xhtml/AccountDetails?faces-redirect=true";
		}
		if (cm.Login(mail, passwordEncryption(password)) != null) {
			formType=1;
			loggedIn = true;
			role = "User";
			newClientMoral = cm.Login(mail, passwordEncryption(password));
			return "/xhtml/AccountDetails?faces-redirect=true";
		}
		return "/xhtml/index?faces-redirect=true";

	}
	public String signout() {
		formType=1;
		newClientMoral = new ClientMoral();
		newClientPhysique = new ClientPhysique();
		password="";
		mail="";
		return "/xhtml/index?faces-redirect=true";

	}

	public  String Register() {
		if (formType == 1) {
			newClientMoral.setMail(newMail);
			newClientMoral.setPassword(passwordEncryption(newPassword));
			newClientMoral.setNumTel(newNum);
			newClientMoral.setNom(newNom);
			newClientMoral.setAdresse(newAdresse);
			newClientMoral.setStatut(0);
			cm.addUser(newClientMoral);
			mail =newClientMoral.getMail();
			password = newPassword;
			return signIn();
		}
		if (formType == 2) {
			newClientPhysique.setMail(newMail);
			newClientPhysique.setPassword(passwordEncryption(newPassword));
			newClientPhysique.setNumTel(newNum);
			newClientPhysique.setNom(newNom);
			newClientPhysique.setAdresse(newAdresse);
			newClientMoral.setStatut(0);
			cp.addUser(newClientPhysique);
			mail =newClientPhysique.getMail();
			password = newPassword;
			return signIn();
		}
		return null;
	}
	
	public  void UpdateUser() {
		if (formType == 1) {
			newClientMoral.setMail(newMail);
			newClientMoral.setPassword(passwordEncryption(newPassword));
			newClientMoral.setNumTel(newNum);
			newClientMoral.setNom(newNom);
			newClientMoral.setAdresse(newAdresse);
			cm.UpdateUser(newClientMoral);
		}
		if (formType == 2) {
			newClientPhysique.setMail(newMail);
			newClientPhysique.setPassword(passwordEncryption(newPassword));
			newClientPhysique.setNumTel(newNum);
			newClientPhysique.setNom(newNom);
			newClientPhysique.setAdresse(newAdresse);
			cp.UpdateUser(newClientPhysique);
		}

	}

	public void PasswordReset() {
		String rPassword =String.valueOf(Math.random()); 
		if (gs.findByMail(mail) != null) {
			Gestionnaire g = new Gestionnaire();
			g = gs.findByMail(mail);
			g.setPassword(passwordEncryption(rPassword));
			gs.UpdateUser(g);
			Mail.envoyer(mail, rPassword);
		}
		if (cp.findByMail(mail) != null) {
			ClientPhysique client = new ClientPhysique();
			client = cp.findByMail(mail);
			client.setPassword(passwordEncryption(rPassword));
			cp.UpdateUser(client);
			Mail.envoyer(mail, rPassword);
		}
		if (cm.findByMail(mail) != null) {
			ClientMoral client = new ClientMoral();
			client = cm.findByMail(mail);
			client.setPassword(passwordEncryption(rPassword));
			cm.UpdateUser(client);
			Mail.envoyer(mail, rPassword);
		}

	}

	private String passwordEncryption(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	public static boolean isLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(boolean loggedIn) {
		LoginBean.loggedIn = loggedIn;
	}

	public static String getRole() {
		return role;
	}

	public static void setRole(String role) {
		LoginBean.role = role;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFormType() {
		return formType;
	}

	public void setFormType(Integer formType) {
		this.formType = formType;
	}

	public String getNewMail() {
		return newMail;
	}

	public void setNewMail(String newMail) {
		this.newMail = newMail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Integer getNewNum() {
		return newNum;
	}

	public void setNewNum(Integer newNum) {
		this.newNum = newNum;
	}

	public String getNewNom() {
		return newNom;
	}

	public void setNewNom(String newNom) {
		this.newNom = newNom;
	}

	public String getNewAdresse() {
		return newAdresse;
	}

	public void setNewAdresse(String newAdresse) {
		this.newAdresse = newAdresse;
	}

	public ClientPhysique getNewClientPhysique() {
		return newClientPhysique;
	}

	public void setNewClientPhysique(ClientPhysique newClientPhysique) {
		this.newClientPhysique = newClientPhysique;
	}

	public ClientMoral getNewClientMoral() {
		return newClientMoral;
	}

	public void setNewClientMoral(ClientMoral newClientMoral) {
		this.newClientMoral = newClientMoral;
	}

}

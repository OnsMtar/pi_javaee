package interfaces;

import javax.ejb.Remote;

import model.Gestionnaire;

@Remote
public interface IGestionnaire {
	public Gestionnaire Login(String mail, String password);
	public Gestionnaire findByMail(String mail);
	void UpdateUser(Gestionnaire u);
}

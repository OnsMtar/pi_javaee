package interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import model.ClientPhysique;

@Remote
public interface IClientPhysique {
	public ClientPhysique Login(String mail, String password);

	public void addUser(ClientPhysique cp);

	public ArrayList<ClientPhysique> findAll();

	public void deleteUser(int id);

	public ClientPhysique findByMail(String mail);

	void UpdateUser(ClientPhysique u);

	ClientPhysique FindById(int id);
}

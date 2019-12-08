package interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import model.ClientMoral;

@Remote
public interface IClientMoral {

	public ClientMoral Login(String mail, String password);

	public void addUser(ClientMoral cm);

	public ArrayList<ClientMoral> findAll();

	public void deleteUser(int id);

	public ClientMoral findByMail(String mail);

	void UpdateUser(ClientMoral u);

	ClientMoral FindById(int id);
}

package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import interfaces.IClientMoral;
import interfaces.IClientPhysique;
import model.ClientMoral;
import model.ClientPhysique;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class AccountsBean {
	private List<ClientMoral> listClientMoral;
	private List<ClientPhysique> listClientPhysique;
	
	@EJB
	IClientPhysique cp;
	@EJB
	IClientMoral cm;
	
	@PostConstruct
	private void init() {
		listClientMoral= new ArrayList<>();
		listClientPhysique= new ArrayList<>();
		listClientMoral = cm.findAll();
		listClientPhysique = cp.findAll();
		if(LoginBean.loggedIn==false || !LoginBean.role.equals("Admin")) {
			
		}
		else {
			
		}
	}
	public void deleteCM(int id) {
		cm.deleteUser(id);
		listClientMoral = cm.findAll();
	}
	
	public void deleteCP(int id) {
		cp.deleteUser(id);
		listClientPhysique = cp.findAll();
	}
	
	public void activateCM(int id) {
		ClientMoral client =  cm.FindById(id);
		client.setStatut(1);
		cm.UpdateUser(client);
		listClientMoral = cm.findAll();
	}
	
	public void activateCP(int id) {
		ClientPhysique client =  cp.FindById(id);
		client.setStatut(1);
		cp.UpdateUser(client);
		listClientPhysique = cp.findAll();
	}

	public List<ClientMoral> getListClientMoral() {
		return listClientMoral;
	}

	public void setListClientMoral(List<ClientMoral> listClientMoral) {
		this.listClientMoral = listClientMoral;
	}

	public List<ClientPhysique> getListClientPhysique() {
		return listClientPhysique;
	}

	public void setListClientPhysique(List<ClientPhysique> listClientPhysique) {
		this.listClientPhysique = listClientPhysique;
	}
	
	
}

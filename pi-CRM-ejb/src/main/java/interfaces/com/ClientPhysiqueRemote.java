package interfaces.com;

import java.util.List;

import javax.ejb.Remote;

import model.ClientPhysique;


@Remote
public interface ClientPhysiqueRemote {
	public void ajouterClientPhysique (ClientPhysique c);
	public List<ClientPhysique> getAllClientsPhy();
}

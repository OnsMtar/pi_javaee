package services.com;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfaces.com.ClientPhysiqueRemote;
import model.ClientPhysique;



@Stateless
@LocalBean
public class ClientPhysiqueService implements ClientPhysiqueRemote {
	 @PersistenceContext(unitName="primary")
		EntityManager em;
	 
	
	 
	 
	 public void ajouterClientPhysique (ClientPhysique c) {
		 em.persist(c);
	 }
	 
	 public List<ClientPhysique> getAllClientsPhy() {
			List<ClientPhysique> cl = em.createQuery("Select c from ClientPhysique c",
					ClientPhysique.class).getResultList();
			return cl;
			
		}
	
}

package service;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.IClientPhysique;
import model.ClientMoral;
import model.ClientPhysique;

@LocalBean
@Stateless
public class ClientPhysiqueService implements IClientPhysique {

	@PersistenceContext
	EntityManager em;

	@Override
	public ClientPhysique Login(String mail, String password) {
		TypedQuery<ClientPhysique> query = em.createQuery(
				"select g from ClientPhysique as g where g.mail=:mail" + " and g.password=:password and g.statut=1",
				ClientPhysique.class);
		try {
			ClientPhysique cp = query.setParameter("mail", mail).setParameter("password", password).getSingleResult();
			return cp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ClientPhysique findByMail(String mail) {
		TypedQuery<ClientPhysique> query = em.createQuery(
				"select g from ClientPhysique as g where g.mail=:mail",
				ClientPhysique.class);
		try {
			ClientPhysique cp = query.setParameter("mail", mail).getSingleResult();
			return cp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public void addUser(ClientPhysique cp) {
		em.persist(cp);
		
	}
	
	@Override
	public ArrayList<ClientPhysique> findAll() {
		TypedQuery<ClientPhysique> query=em.createQuery("select n from ClientPhysique as n ",ClientPhysique.class);
		return (ArrayList<ClientPhysique>) query.getResultList();
		
	}
	
	@Override
	public void deleteUser(int id) {
		em.remove(em.find(ClientPhysique.class,id));
		
	}
	
	@Override
	public void UpdateUser(ClientPhysique u) {
		em.merge(u);
		
	}
	
	@Override
	public ClientPhysique FindById(int id) {
		return em.find(ClientPhysique.class,id);
		
	}
}

package service;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.IClientMoral;
import model.ClientMoral;

@LocalBean
@Stateless
public class ClientMoralService implements IClientMoral{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public ClientMoral Login(String mail, String password) {
		TypedQuery<ClientMoral> query=em.createQuery("select g from ClientMoral as g where g.mail=:mail"
				+ " and g.password=:password and g.statut=1",ClientMoral.class);
		try {
			ClientMoral g=query.setParameter("mail", mail).setParameter("password", password).getSingleResult();
			return g;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ClientMoral findByMail(String mail) {
		TypedQuery<ClientMoral> query=em.createQuery("select g from ClientMoral as g where g.mail=:mail",ClientMoral.class);
		try {
			ClientMoral g=query.setParameter("mail", mail).getSingleResult();
			return g;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	public void addUser(ClientMoral cm) {
		 em.persist(cm);
		
	}
	
	@Override
	public ArrayList<ClientMoral> findAll() {
		TypedQuery<ClientMoral> query=em.createQuery("select n from ClientMoral as n ",ClientMoral.class);
		return (ArrayList<ClientMoral>) query.getResultList();
		
	}
	
	@Override
	public void deleteUser(int id) {
		em.remove(em.find(ClientMoral.class,id));
		
	}
	
	@Override
	public void UpdateUser(ClientMoral u) {
		em.merge(u);
		
	}
	
	@Override
	public ClientMoral FindById(int id) {
		return em.find(ClientMoral.class,id);
		
	}
}

package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.IGestionnaire;
import model.ClientPhysique;
import model.Gestionnaire;

@LocalBean
@Stateless
public class GestionnaireService implements IGestionnaire{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Gestionnaire Login(String mail, String password) {
		TypedQuery<Gestionnaire> query=em.createQuery("select g from Gestionnaire as g where g.mail=:mail"
				+ " and g.password=:password",Gestionnaire.class);
		try {
			Gestionnaire g=query.setParameter("mail", mail).setParameter("password", password).getSingleResult();
			return g;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Gestionnaire findByMail(String mail) {
		TypedQuery<Gestionnaire> query=em.createQuery("select g from Gestionnaire as g where g.mail=:mail",Gestionnaire.class);
		try {
			Gestionnaire g=query.setParameter("mail", mail).getSingleResult();
			return g;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public void UpdateUser(Gestionnaire u) {
		em.merge(u);
		
	}

}

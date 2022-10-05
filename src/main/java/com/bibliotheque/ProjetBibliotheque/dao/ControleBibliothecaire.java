package com.bibliotheque.ProjetBibliotheque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bibliotheque.ProjetBibliotheque.Entity.Bibliothecaire;

public class ControleBibliothecaire {

	private EntityManagerFactory emf;
	private EntityManager manager;
	
	
	public ControleBibliothecaire() {
		super();
		this.emf= Persistence.createEntityManagerFactory("projetBibliotheque");
		this.manager= emf.createEntityManager();
	}
	
	/**
	 * This method will check the values of the bibliothecaire's login and his password
	 * @param login
	 * @param motDePasse
	 * @return boolean
	 */

	@SuppressWarnings("unchecked")
	public boolean verifier(String login, String motDePasse) {
		
		String req="SELECT b FROM Bibliothecaire b WHERE b.login=:log and b.motDePasse=:pass";
		Query query= manager.createQuery(req);
		query.setParameter("log", login);
		query.setParameter("pass", motDePasse);
		
		List<Bibliothecaire> liste=(List<Bibliothecaire>) query.getResultList();
		if (liste.size()!=1)
			return false;
		else
			return true;
	}
	

	@SuppressWarnings({ "unchecked" })
	public Bibliothecaire verifier2(String login, String motDePasse) {
		
		String req="SELECT b FROM Bibliothecaire b WHERE b.login=:log AND b.motDePasse=:pass";
		Query query= manager.createQuery(req);
		query.setParameter("log", login);
		query.setParameter("pass", motDePasse);
		
		ArrayList<Bibliothecaire> liste=(ArrayList<Bibliothecaire>) query.getResultList();
		Bibliothecaire bib= liste.get(0);
		return bib;
	}
	
	
	/**
	 * Modifier le mot de passe d'un bibliothecaire
	 * @param login
	 * @param newPassword
	 * @return boolean
	 */
	public boolean  changerMotDePasse(String login, String newPassword) {
		boolean modifier= false;
		
		EntityTransaction trans= manager.getTransaction();
		trans.begin();
		
		Bibliothecaire biblio= (Bibliothecaire) manager.find(Bibliothecaire.class, login);
		
		if (biblio!=null) {
			
			biblio.setMotDePasse(newPassword);
			modifier= true;
		}
		
		trans.commit();
		
		return modifier;
	}
}

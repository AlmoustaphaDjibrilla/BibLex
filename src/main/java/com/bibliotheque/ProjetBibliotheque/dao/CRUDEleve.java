package com.bibliotheque.ProjetBibliotheque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;

public class CRUDEleve {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager manager;
	
	private final String unite="projetBibliotheque";
	
	private CRUDEmprunt crudEmprunt;
	
	
	/**
	 * Constructeur par défaut de la classe
	 */
	public CRUDEleve() {
		entityManagerFactory= Persistence.createEntityManagerFactory(unite);
		manager= entityManagerFactory.createEntityManager();
	}
	
	
	/**
	 * This method will persist a student who was passed as argument
	 * @param eleve
	 * @return boolean
	 */
	public boolean creer(Eleve eleve) {
		boolean creer=false;
		
		try {
			EntityTransaction trans= manager.getTransaction();
			
			//Vérifier si un élève existe avec la même matricule
			Eleve el= (Eleve) manager.find(Eleve.class, eleve.getMatricule());
			if (el==null) {
				trans.begin();
				manager.persist(eleve);
				creer=true;
				trans.commit();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return creer;
	}
	
	
	/**
	 * Cette méthode permet de chercher un élève par sa matricule et s'il existe, de changer ses infos par celles du nouvel élève passé en paramètre
	 * @param matricule
	 * @param nouvelEleve
	 * @return boolean
	 */
	public boolean modifier(int matricule, Eleve nouvelEleve) {
		boolean modifier=false;
		try {
			EntityTransaction trans=manager.getTransaction();
			
			//Cherchons l'élève avec la matricule parametrée
			
			Eleve eleve= manager.find(Eleve.class, matricule);
			if (eleve!=null) {
				
				
				
				manager.remove(eleve);
				//nouvelEleve.setMatricule(matricule);
				modifier= creer(nouvelEleve);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modifier;
	}
	
	
	/**
	 * 
	 * @param matricule
	 * @return Eleve
	 */
	public Eleve rechercher(int matricule) {
		Eleve eleve= null;
		
		eleve= manager.find(Eleve.class, matricule);
		
		return eleve;
	}
	
	
	/**
	 * Retourne tous les eleves
	 * @return List<Eleve>
	 */
	@SuppressWarnings("unchecked")
	public List<Eleve> tousEleves(){
		List<Eleve> lesEleves= null;
		
		String requete= "SELECT e FROM Eleve e";
		
		Query query= manager.createQuery(requete);
		
		lesEleves=(List<Eleve>) query.getResultList();
		
		return lesEleves;
	}
	
	
	
	
	/**
	 * Retourne les élèves en pénalité ( avec des emprunts dont les dates limites de retour sont dépassées )
	 * @return elevesPenalites
	 */
	public List<Eleve> elevesPenalites(){
		List<Eleve> elevesPenalites= new ArrayList<Eleve>();
		
		crudEmprunt= new CRUDEmprunt();
		
		List<Emprunt> empruntsPenalites= crudEmprunt.empruntsPenalites();
		
		for (Emprunt emp: empruntsPenalites) {
			elevesPenalites.add(emp.getEleve());
		}
		
		return elevesPenalites;
	}
}

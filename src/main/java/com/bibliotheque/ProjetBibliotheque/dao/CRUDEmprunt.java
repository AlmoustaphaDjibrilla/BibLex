package com.bibliotheque.ProjetBibliotheque.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;

public class CRUDEmprunt {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager manager;
	
	private CRUDEleve crudEleve;
	private CRUDLivre crudLivre;
	
	private final String unite="projetBibliotheque";
	
	//Le nombre max de livre qu'un eleve peut effectuer à la fois
	private final int MAX_EMPRUNT_ELEVE= 2;
	
	/**
	 * 
	 */
	public CRUDEmprunt() {
		entityManagerFactory= Persistence.createEntityManagerFactory(unite);
		manager= entityManagerFactory.createEntityManager();
		crudEleve= new CRUDEleve();
		crudLivre= new CRUDLivre();
	}
	
	
	/**
	 * Enregistrer un emprunt dans la BD
	 * @param emprunt
	 * @return 0 (si l'emprunt n'est pas enregistré )
	 * 		   1 si l'eleve a deja des livres en cours d'emprunt
	 * 		   2 si l'emprunt a lieu
	 */
	public int accorderEmprunt(Emprunt emprunt) {
		int accord= 0;
		
		try {
			
			
			EntityTransaction ts= manager.getTransaction();
			ts.begin();
			
			if (emprunt!=null) {
			
				Livre livre= emprunt.getLivre();
			
				Eleve eleve= emprunt.getEleve();
				eleve= (Eleve) manager.find(Eleve.class, eleve.getMatricule());
				
				int nbrEmpruntEnCours= eleve.getNombreEmpruntsEnCours();
			
				if (nbrEmpruntEnCours >= this.MAX_EMPRUNT_ELEVE)
					accord=1;
			
				else {
			
					boolean diminuerQteLivre= crudLivre.diminuerQuantiteLivre(livre.getIsbn(), 1);
			
					if (diminuerQteLivre) {
						emprunt.setRendu(false);
						eleve.nouvelEmprunt();
						//livre.nouvelEmprunt();
						manager.persist(emprunt);
						accord= 2;
					}
				}
			ts.commit();
			
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			accord= 0;
		}
		return accord;
	}
	
	
	/**
	 * Chercher un emprunt par son id
	 * @param id
	 * @return Emprunt
	 */
	public Emprunt chercherEmprunt(int id) {
		Emprunt emprunt= null;
		
		emprunt= (Emprunt) manager.find(Emprunt.class,(long) id);
		
		return emprunt;
	}
	
	
	
	/**
	 * Cette méthode permet de restituer un emprunt passé en parametre
	 * @param emprunt
	 * @return boolean
	 */
	public boolean restituerEmprunt(Emprunt emprunt) {
		boolean restituer= false;
		try {
			EntityTransaction ts= manager.getTransaction();
			ts.begin();
			
			if (emprunt!=null) {
			
				int id= (int) emprunt.getId();
			
				Emprunt emp= chercherEmprunt( id);
				if (emp!=null && emp.isRendu()==false) {
					
					Eleve eleve= (Eleve) manager.find(Eleve.class, emp.getEleve().getMatricule());
					Livre livre= (Livre) manager.find(Livre.class, emp.getLivre().getIsbn());
				
					/*
					Eleve eleve= crudEleve.rechercher(emp.getEleve().getMatricule());
					Livre livre= crudLivre.chercherLivre(emp.getLivre().getIsbn());
					*/
				
					livre.augmenterQuantiteLivre(1);
					eleve.restituerEmprunt();
					restituer= true;
					emp.setRendu(true);
				}
			
			}
			
			ts.commit();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			restituer= false;
		}
		return restituer;
	}
	
	
		/**

	 * Cette méthode retourne une liste contenant tous les emprunts
	 * @return List<Emprunt>
	 */
	@SuppressWarnings("unchecked")
	public List<Emprunt> tousLesEmprunts(){
		List<Emprunt> tousEmprunts= null;
		
		String requete= "SELECT e FROM Emprunt e";
		
		Query query= manager.createQuery(requete);
		
		tousEmprunts= (List<Emprunt>) query.getResultList();
		
		return tousEmprunts;
	}
	
	
	
	/**
	 * Retourne les emprunts qui ne sont pas encore rendus
	 * @return List<Emprunt>
	 */
	@SuppressWarnings("unchecked")
	public List<Emprunt> empruntEnCours(){
		List<Emprunt> empruntEnCours= null;
		
		String requete= "SELECT e FROM Emprunt e WHERE e.rendu=false";
		
		Query query= manager.createQuery(requete);
		
		empruntEnCours= query.getResultList();
		
		return empruntEnCours;
	}
	
	
	
	/**
	 * Retourne les emprunts non rendus et dont la date limite est dépassée
	 * @return empruntPenalites
	 */
	
	public List<Emprunt> empruntsPenalites(){
		
		List<Emprunt> empruntsPenalites= new ArrayList<Emprunt>();
		
		List <Emprunt> empruntEnCours= empruntEnCours();
		
		LocalDate instant= LocalDate.now();
		
		for (Emprunt emprunt: empruntEnCours) {
			
			LocalDate dateRetourMax= LocalDate.parse(emprunt.getDateRetour());
			
			if (instant.isAfter(dateRetourMax)) {
				
				empruntsPenalites.add(emprunt);
			}
		}
		
		
		return empruntsPenalites;
	}
	
	
	
	/**
	 * Retourne les emprunts rendus
	 * @return List<Emprunt>
	 */
	@SuppressWarnings("unchecked")
	public List<Emprunt> empruntRendus(){
		List<Emprunt> empruntRendus= null;
		
		String requete= "SELECT e FROM Emprunt e WHERE e.rendu=true";
		
		Query query= manager.createQuery(requete);
		
		empruntRendus= query.getResultList();
		
		return empruntRendus;
	}
}

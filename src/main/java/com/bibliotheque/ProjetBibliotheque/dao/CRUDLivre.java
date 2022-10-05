package com.bibliotheque.ProjetBibliotheque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;

public class CRUDLivre {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	public final String unite="projetBibliotheque";
	
	
	/**
	 * this method is the default constructor of this class. It will initialize the instances both of the entityManagerFactory and the entityManager
	 */
	public CRUDLivre() {
		
		emf= Persistence.createEntityManagerFactory(unite);
		manager= emf.createEntityManager();
	}

	
	/**
	 * This method will persist a book passed as argument in our database. It will return True when the persistence will be fact or False else
	 * @param livre
	 * @return boolean
	 */
	public boolean creer(Livre livre) {
		boolean creation= false;
		try {
			//Create  the transaction
			EntityTransaction transaction= manager.getTransaction();
		
			//Vérifier si le livre existe avec le meme numero isbn
			Livre lv= (Livre) manager.find(Livre.class, livre.getIsbn());
			if (lv==null) {
				transaction.begin();
		
				manager.persist(livre);
				creation= true;
		
				transaction.commit();
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			creation= false;
		}
		
		return creation;
	}
	
	
	/**
	 * La méthode recherche un livre par son isbn en parametre
	 * @param isbn
	 * @return Livre
	 */
	public Livre chercherLivre(String isbn) {
		
		Livre livre=null ;
		
		try {
			
			livre= (Livre) manager.find(Livre.class,isbn.toUpperCase());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return livre;
	}
	
	
	/**
	 * La méthode renvoie true si la qté du livre est incrémentée, false sinon
	 * @param isbn
	 * @param quantiteSupplementaire
	 * @return boolean
	 */
	public boolean augmenterQuantiteLivre(String isbn, int quantiteSupplementaire) {
		boolean reussi= false;
		
		try {
			Livre livre= chercherLivre(isbn);
			if (livre!=null) {
				EntityTransaction transaction= manager.getTransaction();
				transaction.begin();
				
				Livre livre2= livre;
				livre2.augmenterQuantiteLivre(quantiteSupplementaire);
				
				manager.remove(livre);
				manager.persist(livre2);
				reussi= true;
				
				transaction.commit();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			reussi= false;
		}
		
		return reussi;
	}
	
	
	/**
	 * Renvoie true  si la qté du livre est décrementée, false sinon
	 * @param isbn
	 * @param quantiteDiminuer
	 * @return boolean
	 */
	public boolean diminuerQuantiteLivre(String isbn, int quantiteDiminuer) {
		boolean reussi= false;
		
		try {
			Livre livre= chercherLivre(isbn);
			if (livre!=null) {
				EntityTransaction transaction= manager.getTransaction();
				transaction.begin();
				
				Livre livre2= livre;
				livre2.diminuerQuantite(quantiteDiminuer);
				
				manager.remove(livre);
				manager.persist(livre2);
				reussi= true;
				
				transaction.commit();
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			reussi= false;
		}
		
		return reussi;
	}
	
	
	
	/**
	 * Retourner une liste contenant tous les livres
	 * @return List<Livre>
	 */
	@SuppressWarnings("unchecked")
	public List<Livre> selectAll(){
		
		List<Livre> lesLivres;
		
		try {
			String requete= "SELECT l FROM Livre l";
			Query query= manager.createQuery(requete);
			
			lesLivres= (List<Livre>) query.getResultList();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lesLivres= null;
		}
		
		return lesLivres;
	}
	
	
	
	/**
	 * Retourne une liste de livre repondant à des criteres de recherche
	 * @param recherche
	 * @return List<Livre>
	 */
	@SuppressWarnings("unchecked")
	public List<Livre> chercher(String recherche){
		List<Livre> lesLivres= null;

		String requete= "SELECT l FROM Livre l WHERE l.isbn LIKE '%"+recherche+"%' OR l.titre LIKE '%"+recherche+"%' OR l.categorie LIKE '%"+recherche+"%' OR l.niveau LIKE '%"+recherche+"%' OR l.anneeEdition LIKE '%"+recherche+"%'";
		
		Query query= manager.createQuery(requete);
		
		lesLivres= (List<Livre>) query.getResultList();
		
		return lesLivres;
	}
	
	
	
	/***
	 * Retourner tous les livres en classant suivant leur nombre d'emprunts
	 * @return plusEmpruntes
	 */
	
	@SuppressWarnings("unchecked")
	public List<Livre> plusEmpruntes(){
		
		List<Livre> plusEmpruntes= null;
		
		String requete="SELECT l FROM Livre l ORDER BY l.nombreEmprunts DESC";
		
		Query query= manager.createQuery(requete);
		
		plusEmpruntes= (List<Livre>) query.getResultList();
		
		return plusEmpruntes;
	}
	
	
	
	/**
	 * Retourner tous les livres en classant 
	 * @return moinsEmpruntes
	 */
	@SuppressWarnings("unchecked")
	public List<Livre> moinsEmpruntes(){
		
		List<Livre> moinsEmpruntes= null;
		
		String requete= "SELECT l FROM Livre l ORDER BY l.nombreEmprunts ASC";
		
		Query query = manager.createQuery(requete);
		
		moinsEmpruntes= (List<Livre>) query.getResultList();
		
		return moinsEmpruntes;
	}
}

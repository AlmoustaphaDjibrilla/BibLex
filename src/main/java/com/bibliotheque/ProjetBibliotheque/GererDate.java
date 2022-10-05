/**
 * 
 */
package com.bibliotheque.ProjetBibliotheque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bibliotheque.ProjetBibliotheque.Entity.Categorie;
import com.bibliotheque.ProjetBibliotheque.Entity.Classe;
import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.Entity.Niveau;

/**
 * @author PCS
 *
 */
public class GererDate {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetBibliotheque");
		EntityManager manager= emf.createEntityManager();

		
		Niveau nv= Niveau.SECONDE;
		Categorie ct= Categorie.MATHS;
		Eleve el= new Eleve(18, "moussa mahamadou", "oumar farouk", Classe.PREMIERE_D);
		
		manager.persist(el);
		
		
	}
}

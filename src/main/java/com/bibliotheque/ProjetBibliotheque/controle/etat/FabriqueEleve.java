package com.bibliotheque.ProjetBibliotheque.controle.etat;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;

public class FabriqueEleve {

	
	public static List<Eleve> createBeanCollection(){
		
		CRUDEleve crudEleve= new CRUDEleve();
		List<Eleve> eleves=crudEleve.tousEleves();
		return eleves;
	}
}

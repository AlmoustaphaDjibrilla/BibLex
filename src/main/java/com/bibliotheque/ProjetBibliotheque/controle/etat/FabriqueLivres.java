package com.bibliotheque.ProjetBibliotheque.controle.etat;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;

public class FabriqueLivres {

	public static List<Livre> createBeanCollection(){
		
		CRUDLivre liv= new CRUDLivre();
				List<Livre> livres= liv.selectAll();
				return livres;
	}
}

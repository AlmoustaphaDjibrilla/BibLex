package com.bibliotheque.ProjetBibliotheque;


import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args )
    {
    	/*
    	List<String> listes= new ArrayList<String>();
    	
    	for (Categorie cat: Categorie.values()) {
    		listes.add(cat.toString());
    	}
    	
    	for (String ct: listes) {
    		System.out.println(ct);
    	}
    	
      */
    
    
    	List<Eleve> elevesPenalites= new CRUDEleve().elevesPenalites();
    	
    	for (Eleve el: elevesPenalites) {
    		System.out.println (el);
    	}
    }
}



package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;
import com.bibliotheque.ProjetBibliotheque.modeles.ModelesEleves;

public class ControlesEleves {

	private ModelesEleves modeleEleves;
	private CRUDEleve crudEleve;
	private List<Eleve> lesEleves;
	
	
	public ControlesEleves() {
		crudEleve= new CRUDEleve();
		lesEleves= crudEleve.tousEleves();
		modeleEleves= new ModelesEleves(lesEleves);
	}


	public ModelesEleves getModeleEleves() {
		return modeleEleves;
	}


	public void setModeleEleves(ModelesEleves modeleEleves) {
		this.modeleEleves = modeleEleves;
	}
	
	public boolean ajouterEleve(Eleve nouvelEleve) {
		boolean ajout= false;
		
		try {
			
			ajout= crudEleve.creer(nouvelEleve);
			
			this.modeleEleves.ajouterEleve(nouvelEleve);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			ajout= false;
		}
		
		return ajout;
	}
}

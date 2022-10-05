package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEmprunt;
import com.bibliotheque.ProjetBibliotheque.modeles.ModelesEmpruntsEnCours;

public class ControlesEmpruntsEnCours {

	private CRUDEmprunt crudEmprunt;
	private ModelesEmpruntsEnCours modeleEmpruntsCours;
	private List<Emprunt> empruntsCours;
	
	public ControlesEmpruntsEnCours() {
		
		crudEmprunt= new CRUDEmprunt();
		empruntsCours= crudEmprunt.empruntEnCours();
		modeleEmpruntsCours= new ModelesEmpruntsEnCours(empruntsCours);
	}

	public ModelesEmpruntsEnCours getModeleEmpruntsCours() {
		return modeleEmpruntsCours;
	}

	public void setModeleEmpruntsCours(ModelesEmpruntsEnCours modeleEmpruntsCours) {
		this.modeleEmpruntsCours = modeleEmpruntsCours;
	}
	
	
}

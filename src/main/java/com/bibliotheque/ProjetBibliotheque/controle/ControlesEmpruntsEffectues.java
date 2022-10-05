package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEmprunt;
import com.bibliotheque.ProjetBibliotheque.modeles.ModelesEmpruntsEffectues;

public class ControlesEmpruntsEffectues {

	private CRUDEmprunt crudEmprunt;
	private List<Emprunt> empruntsEffectues;
	private ModelesEmpruntsEffectues modeleEmprunsEffectues;
	
	public ControlesEmpruntsEffectues() {
		crudEmprunt= new CRUDEmprunt();
		empruntsEffectues= crudEmprunt.empruntRendus();
		modeleEmprunsEffectues= new ModelesEmpruntsEffectues(empruntsEffectues);
	}

	public ModelesEmpruntsEffectues getModeleEmprunsEffectues() {
		return modeleEmprunsEffectues;
	}

	public void setModeleEmprunsEffectues(ModelesEmpruntsEffectues modeleEmprunsEffectues) {
		this.modeleEmprunsEffectues = modeleEmprunsEffectues;
	}
	
	
}

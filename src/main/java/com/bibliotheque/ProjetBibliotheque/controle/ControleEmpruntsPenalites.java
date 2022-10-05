package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEmprunt;
import com.bibliotheque.ProjetBibliotheque.modeles.ModelesEmpruntsPenalites;

public class ControleEmpruntsPenalites {

	private ModelesEmpruntsPenalites modelesEmpruntsPenalites;
	private CRUDEmprunt crudEmprunt;
	private List<Emprunt> empruntPenalites;
	
	public ControleEmpruntsPenalites(){
		
		crudEmprunt= new CRUDEmprunt();
		empruntPenalites= crudEmprunt.empruntsPenalites();
		modelesEmpruntsPenalites= new ModelesEmpruntsPenalites(empruntPenalites);
	}

	public ModelesEmpruntsPenalites getModelesEmpruntsPenalites() {
		return modelesEmpruntsPenalites;
	}

	public void setModelesEmpruntsPenalites(ModelesEmpruntsPenalites modelesEmpruntsPenalites) {
		this.modelesEmpruntsPenalites = modelesEmpruntsPenalites;
	}
	
	
}

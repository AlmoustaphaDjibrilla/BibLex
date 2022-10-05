package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;
import com.bibliotheque.ProjetBibliotheque.modeles.ModelesRechercheLivre;

public class ControleRechercheLivre {

	private ModelesRechercheLivre modRechLivre;
	private CRUDLivre crudLivre;
	private List<Livre> livresRecherche;
	
	public ControleRechercheLivre(String recherche) {
		crudLivre= new CRUDLivre();
		livresRecherche= crudLivre.chercher(recherche);
		modRechLivre= new ModelesRechercheLivre(livresRecherche);
	}

	public ModelesRechercheLivre getModRechLivre() {
		return modRechLivre;
	}

	public void setModRechLivre(ModelesRechercheLivre modRechLivre) {
		this.modRechLivre = modRechLivre;
	}
	
	
}

package com.bibliotheque.ProjetBibliotheque.controle;

import java.util.List;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;
import com.bibliotheque.ProjetBibliotheque.modeles.ModeleLivres;

public class ControleLivres {

	private CRUDLivre crudLivre;
	private ModeleLivres modeleLivres;
	private List<Livre> lesLivres;
	
	
	public ControleLivres() {
		
		crudLivre= new CRUDLivre();
		lesLivres= crudLivre.selectAll();
		modeleLivres= new ModeleLivres(lesLivres);
	}
	
	public ModeleLivres getModeleLivre() {
		return this.modeleLivres;
	}
	
	public void setModeleLivre(ModeleLivres modele) {
		this.modeleLivres= modele;
	}
	
	public void chargerLivresPlusFrequentes() {
		
		List<Livre> nouveauxLivres= crudLivre.plusEmpruntes();
		this.modeleLivres= new ModeleLivres(nouveauxLivres);
	}
	
	
	public void chargerLivresMoinsFrequentes() {
		List<Livre> nouveauxLivres= crudLivre.moinsEmpruntes();
		this.modeleLivres= new ModeleLivres(nouveauxLivres);
	}
	
	public void chargerLivresBonEtats() {
		
		List<Livre> livresBonsEtats= crudLivre.selectAll();
		this.modeleLivres= new ModeleLivres(livresBonsEtats);
	}
	
	public boolean creerLivre(Livre livre) {
		
		boolean creation= false;
		try {
			
			creation= crudLivre.creer(livre);
			
			modeleLivres.ajouterLivre(livre);
			
		} 
		catch (Exception e) {
			// TODO: handle exception
			creation= false;
		}
		return creation;
	}
	
	public void selectAll() {
		List<Livre> lv= crudLivre.selectAll();
		modeleLivres.lu(lv);
	}
}

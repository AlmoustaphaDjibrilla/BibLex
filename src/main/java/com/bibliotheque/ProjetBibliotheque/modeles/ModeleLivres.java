package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.cfg.annotations.reflection.XMLContext.Default;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;

public class ModeleLivres extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  final String[] TITRES= {"ISBN", "TITRE", "ANNEE_EDITION", "NIVEAU", "CATEGORIE", "QUANTITE", "NOMBRE_EMPRUNTS"};
	private final List<Livre> lesLivres;

	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesLivres.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	
		Livre livre= getLivre(rowIndex);
		
		switch (columnIndex) {
		
		case 0:
			return livre.getIsbn();
		
		case 1:
			return livre.getTitre();
			
		case 2:
			return livre.getAnneeEdition();
			
		case 3:
			return livre.getNiveau();
			
		case 4:
			return livre.getCategorie();
			
		case 5: 
			return livre.getQuantite();
			
		case 6:
			return livre.getNombreEmprunts();
			
		default:
			return null;
		}
		
	}
	
	public String getColumnName(int columnIndex) {
		
		switch (columnIndex) {
		case 0:
			return "ISBN";

		case 1:
			return "TITRE";
			
		case 2:
			return "ANNEE_EDITION";
		
		case 3:
			return "NIVEAU";
			
		case 4:
			return "CATEGORIE";
			
		case 5:
			return "QUANTITE";

		case 6:
			return "NOMBRE_EMPRUNTS";
		default:
			return null;
		}
		//return lesColonnes[columnIndex];
	}
	
	
	/*
	 * Constructeur
	 */
	public ModeleLivres(List<Livre> livres) {
		lesLivres= new ArrayList<Livre>(livres);
	}
	
	
	public Livre getLivre(int rowIndex) {
		return lesLivres.get(rowIndex);
	}

	
	/**
	 * 
	 * @param newDonnees
	 */
	public void lu(List<Livre> newDonnees) {
		
		lesLivres.clear();
		lesLivres.addAll(newDonnees);
		this.fireTableDataChanged();
	}
	
	
	public void ajouterLivre(Livre livre) {
		
		this.lesLivres.add(livre);
		int index= this.lesLivres.size() -1;
		fireTableRowsInserted(index, index);
	}
}

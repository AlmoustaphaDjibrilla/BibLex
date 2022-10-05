package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;

public class ModelesRechercheLivre extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  final String[] TITRES= {"ISBN", "TITRE", "ANNEE_EDITION", "NIVEAU", "CATEGORIE", "QUANTITE"};
	private final List<Livre> lesLivresRecherches;
	
	
	/*
	 * Constructor
	 */
	public ModelesRechercheLivre(List<Livre> livresRecherches){
		
		lesLivresRecherches= new ArrayList<Livre>(livresRecherches);
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesLivresRecherches.size();
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
			
		default:
			return null;
		}
	}
	
	public Livre getLivre(int index) {
		return lesLivresRecherches.get(index);
	}
	
	public String getColumnName(int index) {
		return TITRES[index];
	}

}

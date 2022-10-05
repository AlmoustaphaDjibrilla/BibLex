package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;

public class ModelesEmpruntsPenalites extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String[] TITRES= {
		"ID_EMPRUNT", "MATRICULE_ELEVE", "NOM_PRENOM_ELEVE","ISBN_LIVRE", "TITRE_LIVRE", "DATE_LIMITE_RETOUR"	
	};

	private final List<Emprunt> empruntsPenalites;
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empruntsPenalites.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		Emprunt emprunt= getEmprunt(rowIndex);
		
		switch (columnIndex) {
		
		case 0:
			return emprunt.getId();
			
		case 1:
			return emprunt.getEleve().getMatricule();
			
		case 2:
			return emprunt.getEleve().getNom()+" "+emprunt.getEleve().getPrenom();
			
		case 3:
			return emprunt.getLivre().getIsbn();
			
		case 4:
			return emprunt.getLivre().getTitre();
			
		case 5:
			return emprunt.getDateRetour();
			
		default:
			return null;
		
		}
		
		
	}

	public String getColumnName(int columnIndex) {
		return TITRES[columnIndex];
	}
	
	/*
	 * Constructor
	 */
	public ModelesEmpruntsPenalites(List<Emprunt> empruntsEnPenalites) {
		this.empruntsPenalites= empruntsEnPenalites;
	}
	
	
	public Emprunt getEmprunt(int rowIndex) {
		return empruntsPenalites.get(rowIndex);
	}
}

package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;

public class ModelesEmpruntsEnCours extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String[] TITRES= {"ID", "MATRICULE_ELEVE", "ISBN_LIVRE", "DATE_RETRAIT", "DATE_RETOUR"};
	private final List<Emprunt> empruntsCours;
	
	
	/**
	 * Constructeur
	 * @param empruntsEnCours
	 */
	public ModelesEmpruntsEnCours(List<Emprunt> empruntsEnCours) {
		this.empruntsCours= empruntsEnCours;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return empruntsCours.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}
	
	public String getColumnName(int rowIndex) {
		return TITRES[rowIndex];
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
			return emprunt.getLivre().getIsbn();
			
		case 3:
			return emprunt.getDateRetrait();
			
		case 4:
			return emprunt.getDateRetour();
			
		default:
			return null;
		}
	}

	
	public Emprunt getEmprunt(int rowIndex) {
		return empruntsCours.get(rowIndex);
	}
}

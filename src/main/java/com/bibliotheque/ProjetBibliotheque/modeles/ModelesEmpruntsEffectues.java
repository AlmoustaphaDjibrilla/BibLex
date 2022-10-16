package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;

public class ModelesEmpruntsEffectues extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final String[] TITRES={"ID_EMPRUNT", "MATRICULE_ELEVE", "ISBN_LIVRE", "DATE_RETRAIT", "DATE_RETOUR"};
	private final List<Emprunt> empruntsEffectues;
	
	public ModelesEmpruntsEffectues(List<Emprunt> empruntsEffectues) {
		
		this.empruntsEffectues= empruntsEffectues;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return empruntsEffectues.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}
	
	public String getColumnName(int index) {
		return TITRES[index];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		Emprunt emprunt= getEmprunt(rowIndex);
		
		switch(columnIndex) {
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

	public Emprunt getEmprunt(int index) {
		return empruntsEffectues.get(index);
	}
}

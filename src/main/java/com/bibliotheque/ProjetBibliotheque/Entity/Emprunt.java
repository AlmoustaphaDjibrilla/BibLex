package com.bibliotheque.ProjetBibliotheque.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;

@Entity
@Table (name = "Emprunt")
public class Emprunt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private long id;
	
	@Column (name = "dateRetrait")
	private String dateRetrait;
	
	@Column (name = "dateRetour")
	private String dateRetour;
	
	@ManyToOne 
	private Eleve eleve;
	
	@ManyToOne
	private Livre livre;

	@Column (name = "rendu")
	private boolean rendu;
	
	/**
	 * Constructeur
	 */
	public Emprunt() {
		
	}


	public Emprunt(Eleve eleve, Livre livre) {
		super();
	
		this.eleve= eleve;
		
		this.livre= livre;
		
		LocalDate retrait= LocalDate.now();
		this.dateRetrait = retrait.toString();
		
		LocalDate retour= retrait.plusDays(6l);
		this.dateRetour= retour.toString();
		
		this.rendu = false;
	}


	
	public String getDateRetrait() {
		return dateRetrait;
	}


	public void setDate_retrait(String date_retrait) {
		this.dateRetrait = date_retrait;
	}


	public String getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(String date_retour) {
		this.dateRetour = date_retour;
	}
	


	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Livre getLivre() {
		return livre;
	}


	public void setLivre(Livre livre) {
		this.livre = livre;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public long getId() {
		return id;
	}


	public boolean isRendu() {
		return rendu;
	}
	
	public void setRendu(boolean estRendu) {
		this.rendu= estRendu;
	}


	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateRetrait=" + dateRetrait + ", dateRetour=" + dateRetour + ", eleve=" + eleve
				+ ", livre=" + livre + "]";
	}
	
	
	
}

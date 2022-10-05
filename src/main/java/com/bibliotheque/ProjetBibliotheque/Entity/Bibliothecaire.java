package com.bibliotheque.ProjetBibliotheque.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bibliothecaire")
public class Bibliothecaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="login")
	private String login;
	
	@Column(name="motDePasse")
	private String motDePasse;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="telephone")
	private String telephone;

	
	
	/**
	 * Constructeur de la classe Bibliothecaire
	 * @param login
	 * @param motDePasse
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	
	public Bibliothecaire(String login, String motDePasse, String nom, String prenom, String telephone) {
		super();
		this.login = login.toLowerCase();
		this.motDePasse = motDePasse;
		this.nom = nom.toUpperCase();
		this.prenom = prenom.substring(0,1).toUpperCase()+ prenom.substring(1).toLowerCase();
		this.telephone = telephone;
	}

	
	/**
	 * Constructeur par défaut de la classe Bibliothecaire
	 */
	public Bibliothecaire() {
		
	}
	
	/*
	 * 
	 * Getters and setters
	 * 
	 */
	

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Bibliothecaire [login=" + login + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephone=" + telephone + "]";
	}
	
	
}

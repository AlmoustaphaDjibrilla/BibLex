package com.bibliotheque.ProjetBibliotheque.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;


@Entity
@Table(name="Profil")
public class Profil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="id")
	private int id;
	
	@Column(name= "photo")
	private byte[] photo;
	
	@Column (name = "details")
	private char[] details;

	public Profil(int id, byte[] photo, char[] details) {
		super();
		this.id = id;
		this.photo = photo;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getDetails() {
		return details;
	}

	public void setDetails(char[] details) {
		this.details = details;
	}

	public Profil() {
		super();
	}

	
	
}

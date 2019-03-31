package marcheSecondaire.beans;

import java.util.Date;

public class Utilisateur {

	private int id_utilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int societe;
	private int type;
	private String cin;
	private String carte;
	private String dateexp;
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getCarte() {
		return carte;
	}
	public void setCarte(String carte) {
		this.carte = carte;
	}
	public String getDateexp() {
		return dateexp;
	}
	public void setDateexp(String dateexp) {
		this.dateexp = dateexp;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSociete() {
		return societe;
	}
	public void setSociete(int societe) {
		this.societe = societe;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
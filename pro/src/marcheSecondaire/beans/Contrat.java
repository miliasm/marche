package marcheSecondaire.beans;

import java.util.Date;

public class Contrat {

	private int id_contrat;
	private int type;
	private int nombre;
	private Date publication;
	private float prix_depart;
	
	
	public int getId_contrat() {
		return id_contrat;
	}
	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public Date getPublication() {
		return publication;
	}
	public void setPublication(Date publication) {
		this.publication = publication;
	}
	public float getPrix_depart() {
		return prix_depart;
	}
	public void setPrix_depart(float prix_depart) {
		this.prix_depart = prix_depart;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	private int id_utilisateur;
}
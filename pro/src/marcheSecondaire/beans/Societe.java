package marcheSecondaire.beans;

public class Societe {

	private int id_societe;
	private String nom;
	private int capitalisation;
	private String description;
	private int id_secteur;
	
	public int getId_societe() {
		return id_societe;
	}
	public void setId_societe(int id_societe) {
		this.id_societe = id_societe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCapitalisation() {
		return capitalisation;
	}
	public void setCapitalisation(int capitalisation) {
		this.capitalisation = capitalisation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_secteur() {
		return id_secteur;
	}
	public void setId_secteur(int id_secteur) {
		this.id_secteur = id_secteur;
	}
}
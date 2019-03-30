package marcheSecondaire.beans;

public class Transaction {

	private int id_transaction;
	private int id_contrat;
	private int id_utilisateur;
	private int quantite;
	private float prix_unitaire;
	
	
	public int getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}
	public int getId_contrat() {
		return id_contrat;
	}
	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
}
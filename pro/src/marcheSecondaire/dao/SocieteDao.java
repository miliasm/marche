package marcheSecondaire.dao;

import marcheSecondaire.beans.Societe;

public interface SocieteDao {
	public void ajouter(Societe societe);
	public Societe getByNom(String nom);
}
package marcheSecondaire.dao;

import java.util.List;

import marcheSecondaire.beans.Secteur;

public interface SecteurDao {

	public List<Secteur> lister();
	public Secteur getNomById(int id);
	public Secteur getIdByNom(String nom);
}
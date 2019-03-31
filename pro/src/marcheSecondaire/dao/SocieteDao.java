package marcheSecondaire.dao;

import java.util.List;
import java.util.Map;

import marcheSecondaire.beans.Societe;

public interface SocieteDao {
	public void ajouter(Societe societe);
	public Societe getByNom(String nom);
	public List<Societe> lister();
	public Map<Integer, Societe> listerMap();
	public List<Societe> listerBySec(int id);
}
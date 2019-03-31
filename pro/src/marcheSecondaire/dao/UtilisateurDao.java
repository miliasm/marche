package marcheSecondaire.dao;

import java.util.List;

import marcheSecondaire.beans.Societe;
import marcheSecondaire.beans.Utilisateur;

public interface UtilisateurDao {

	void ajouter(Utilisateur utilisateur, Societe societe);
	Utilisateur existe(Utilisateur utilisateur);
	Utilisateur completerInv(Utilisateur utilisateur);
    List<Utilisateur> lister();
    List<Utilisateur> listerInv();
    List<Utilisateur> listerMmbr();
}
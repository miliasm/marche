package marcheSecondaire.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import marcheSecondaire.beans.Secteur;

public class SecteurDaoImpl implements SecteurDao {
	
	private DaoFactory daoFactory;
	
	public SecteurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Secteur> lister() {
		List<Secteur> secteurs = new ArrayList<>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = (Statement) connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM secteur;");
			
			while(resultat.next()) {
				Secteur sec = new Secteur();
				sec.setId_secteur(resultat.getInt("id_secteur"));
				sec.setNom(resultat.getString("nom"));
				secteurs.add(sec);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return secteurs;
	}

}
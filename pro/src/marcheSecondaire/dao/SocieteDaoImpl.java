package marcheSecondaire.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import marcheSecondaire.beans.Societe;

public class SocieteDaoImpl implements SocieteDao {
	
	private DaoFactory daoFactory;
	
	public SocieteDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Societe societe) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO societe(nom, capitalisation, description) VALUES(?,?,?);");
			preparedStatement.setString(1, societe.getNom());
			preparedStatement.setInt(2, societe.getCapitalisation());
			preparedStatement.setString(3, societe.getDescription());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Societe getByNom(String nom) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		Societe soc = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM societe WHERE nom=?;");
			preparedStatement.setString(1, nom);
			resultat = preparedStatement.executeQuery();
			if(resultat.next()) {
				soc = new Societe();
				soc.setId_societe(resultat.getInt("id_societe"));
				soc.setNom(resultat.getString("nom"));
				soc.setCapitalisation(resultat.getInt("capitalisation"));
				soc.setId_secteur(resultat.getInt("id_secteur"));
				soc.setDescription(resultat.getString("description"));
				return soc;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return soc;
	}

}
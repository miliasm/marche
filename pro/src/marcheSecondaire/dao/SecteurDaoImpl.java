package marcheSecondaire.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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

	@Override
	public Secteur getNomById(int id) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT nom FROM secteur WHERE id_secteur=?;");
			preparedStatement.setInt(1, id);
			resultat = preparedStatement.executeQuery();
			
			if(resultat.next()) {
				Secteur sec = new Secteur();
				sec.setId_secteur(id);
				sec.setNom(resultat.getString("nom"));
				
				return sec;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Secteur getIdByNom(String nom) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT id_secteur FROM secteur WHERE nom=?;");
			preparedStatement.setString(1, nom);
			resultat = preparedStatement.executeQuery();
			
			//System.out.println("I am heeere"); // debug
			
			if(resultat.next()) {
				Secteur sec = new Secteur();
				sec.setId_secteur(resultat.getInt("id_secteur"));
				sec.setNom(nom);
				
				return sec;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
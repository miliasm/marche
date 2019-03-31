package marcheSecondaire.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

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
			preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO societe(nom, capitalisation, description, id_secteur) VALUES(?,?,?,?);");
			preparedStatement.setString(1, societe.getNom());
			preparedStatement.setInt(2, societe.getCapitalisation());
			preparedStatement.setString(3, societe.getDescription());
			preparedStatement.setInt(4, societe.getId_secteur());
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

	@Override
	public List<Societe> lister() {
		List<Societe> societes = new ArrayList<Societe>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            statement = (Statement) connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM societe;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                int capi = resultat.getInt("capitalisation");
                int sect = resultat.getInt("id_secteur");
                String desc = resultat.getString("description");
                int id = resultat.getInt("id_societe");
                
                Societe soc = new Societe();
                soc.setNom(nom);
                soc.setCapitalisation(capi);;
                soc.setId_secteur(sect);
                soc.setDescription(desc);
                soc.setId_societe(id);
                
                societes.add(soc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return societes;
 
	}

	@Override
	public List<Societe> listerBySec(int id) {
		List<Societe> societes = new ArrayList<Societe>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		Societe soc = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM societe WHERE id_secteur=?;");
			preparedStatement.setInt(1,id);
			
			resultat = preparedStatement.executeQuery();
			while(resultat.next()) {
				soc = new Societe();
				soc.setId_societe(resultat.getInt("id_societe"));
				soc.setNom(resultat.getString("nom"));
				soc.setCapitalisation(resultat.getInt("capitalisation"));
				soc.setId_secteur(resultat.getInt("id_secteur"));
				soc.setDescription(resultat.getString("description"));
				
				societes.add(soc);
				
			
		}
		
	}catch (SQLException e) {
        e.printStackTrace();
    }
	return societes;
}

	@Override
	public Map<Integer, Societe> listerMap() {
		Map<Integer, Societe> societes = new HashMap<Integer, Societe>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            statement = (Statement) connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM societe;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                int capi = resultat.getInt("capitalisation");
                int sect = resultat.getInt("id_secteur");
                String desc = resultat.getString("description");
                int id = resultat.getInt("id_societe");
                
                Societe soc = new Societe();
                soc.setNom(nom);
                soc.setCapitalisation(capi);;
                soc.setId_secteur(sect);
                soc.setDescription(desc);
                soc.setId_societe(id);
                
                societes.put(id, soc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return societes;
	}
}
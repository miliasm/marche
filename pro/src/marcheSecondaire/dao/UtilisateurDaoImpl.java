package marcheSecondaire.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import marcheSecondaire.beans.Societe;
import marcheSecondaire.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	private DaoFactory daoFactory;

    UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void ajouter(Utilisateur utilisateur, Societe societe) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = (Connection) daoFactory.getConnection();
			
			if(societe != null) {// ajouter un membre societe
				preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO utilisateur(email, nom, prenom, mot_de_passe, type, id_societe) VALUES(?,?,?,?,?,?);");
				preparedStatement.setString(1, utilisateur.getEmail());
				preparedStatement.setString(2, utilisateur.getNom());
				preparedStatement.setString(3, utilisateur.getPrenom());
				preparedStatement.setString(4, securePassword(utilisateur.getPassword()));
				preparedStatement.setInt(5, utilisateur.getType());
				preparedStatement.setInt(6, societe.getId_societe());
			}else {// ajouter un investisseur
				preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO utilisateur(email, nom, prenom, mot_de_passe, type) VALUES(?,?,?,?,?);");
				preparedStatement.setString(1, utilisateur.getEmail());
				preparedStatement.setString(2, utilisateur.getNom());
				preparedStatement.setString(3, utilisateur.getPrenom());
				preparedStatement.setString(4, securePassword(utilisateur.getPassword()));
				preparedStatement.setInt(5, utilisateur.getType());
			}
			

			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public Utilisateur existe(Utilisateur utilisateur) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM utilisateur WHERE email=? and mot_de_passe=?;");
			preparedStatement.setString(1, utilisateur.getEmail());
			preparedStatement.setString(2, securePassword(utilisateur.getPassword()));
			
			resultat = preparedStatement.executeQuery();
			if(resultat.next()) {
				utilisateur.setId_utilisateur(resultat.getInt("id_utilisateur"));
				utilisateur.setNom(resultat.getString("nom"));
				utilisateur.setPrenom(resultat.getString("prenom"));
				utilisateur.setType(resultat.getInt("type"));
				utilisateur.setSociete(resultat.getInt("id_societe"));
				
				return utilisateur;
			}
			
			return utilisateur; // Il faut retourner l'objet utilisateur entièrement !!!!!!!!! pour l'utiliser à priori
		}catch(SQLException e) {
			e.printStackTrace();
			return utilisateur;
		}
	}
	
	

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String securePassword(String pass) {
		if(pass == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String generatedPassword = sb.toString();
			return generatedPassword;
		} catch (NoSuchAlgorithmException | NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Utilisateur completerInv(Utilisateur utilisateur) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("UPDATE utilisateur SET cin=?, carte=?, dateexp=?, type=? WHERE id_utilisateur=?;");
			preparedStatement.setString(1, utilisateur.getCin());
			preparedStatement.setString(2, utilisateur.getCarte());
			preparedStatement.setDate(3, java.sql.Date.valueOf((utilisateur.getDateexp())));
			preparedStatement.setInt(4, 2);
			preparedStatement.setInt(5, utilisateur.getId_utilisateur());
			
			preparedStatement.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Utilisateur> listerInv() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT nom, prenom, cin FROM utilisateur where type=?;");
            preparedStatement.setInt(1, 2);
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String cin = resultat.getString("cin");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setCin(cin);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

	@Override
	public List<Utilisateur> listerMmbr() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT nom, prenom, id_societe FROM utilisateur where type=?;");
            preparedStatement.setInt(1, 1);
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                int id_societe = resultat.getInt("id_societe");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setSociete(id_societe);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
	}

}
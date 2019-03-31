package marcheSecondaire.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marcheSecondaire.beans.Secteur;
import marcheSecondaire.beans.Societe;
import marcheSecondaire.beans.Utilisateur;
import marcheSecondaire.dao.DaoFactory;
import marcheSecondaire.dao.SecteurDao;
import marcheSecondaire.dao.SocieteDao;
import marcheSecondaire.dao.UtilisateurDao;
import marcheSecondaire.forms.InscriptionForm;

public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_SOC = "societe";
    public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/signup.jsp";
	private String type;
	private UtilisateurDao utilisateurdao;
	private SocieteDao societedao;
	private SecteurDao secteurDao;
	
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurdao = daoFactory.getUtilisateurDao();
        this.societedao = daoFactory.getSocieteDao();
        this.secteurDao = daoFactory.getSecteurDao();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = (String) request.getParameter("type");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* Préparation de l'objet formulaire */
		InscriptionForm form;
		if (type.equals("inv")) {
			form = new InscriptionForm();
			/* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
			Utilisateur utilisateur = form.inscrireUtilisateurInvest( request );
			/* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute(ATT_FORM, form );
	        request.setAttribute(ATT_USER, utilisateur );
	        this.getServletContext().getRequestDispatcher(VUE+"?type=inv").forward(request, response);
	        if(form.isCorrect()) {
	        	utilisateurdao.ajouter(utilisateur, null);
	        }
		}else if(type.equals("mmbr")) {
			form = new InscriptionForm();
			Utilisateur utilisateur = form.inscrireUtilisateurMmbr( request );
			Societe societe = form.inscrireSociete();
			Secteur secteur = form.getSecteur();
			/* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute(ATT_FORM, form);
	        request.setAttribute(ATT_USER, utilisateur);
	        request.setAttribute(ATT_SOC, societe);
	        this.getServletContext().getRequestDispatcher(VUE+"?type=mmbr").forward(request, response);
	        if(form.isCorrect()) {
	        	//System.out.println(secteur.getNom()); // debug
	        	secteur = secteurDao.getIdByNom(secteur.getNom());
	        	//System.out.println(secteur.getId_secteur()); // debug
	        	societe.setId_secteur(secteur.getId_secteur());
	        	societedao.ajouter(societe);
	        	societe = societedao.getByNom(societe.getNom());// nouvelle objet que nous recuperons de la DB
	        	utilisateurdao.ajouter(utilisateur, societe);
	        	
	        }
		}
		
	}
}
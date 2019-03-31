package marcheSecondaire.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import marcheSecondaire.forms.SocFormAdmin;

@WebServlet("/adminPages/connected")
public class Admin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String VUE1 = "/adminPages/connected.jsp";
	public static final String VUE2 = "/adminPages/affichereste.jsp";
	public static final String VUE3 = "/adminPages/affichercontrat.jsp";
	public static final String VUE4 = "/adminPages/affichertransaction.jsp";
	public static final String VUE5 = "/adminPages/afficherinv.jsp";
	public static final String VUE6 = "/adminPages/affichermmbr.jsp";
	
	private SocieteDao societedao;
	private SecteurDao secteurdao;
	private UtilisateurDao utilisateurdao;
	
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.societedao = daoFactory.getSocieteDao();
        this.secteurdao = daoFactory.getSecteurDao();
        this.utilisateurdao = daoFactory.getUtilisateurDao();
    }
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.valueOf(request.getParameter("page"));
		switch(page) {
		case 1:
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
			break;
		case 2:
			this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
			break;
		case 3:
			this.getServletContext().getRequestDispatcher(VUE3).forward(request, response);
			break;
		case 4:
			this.getServletContext().getRequestDispatcher(VUE4).forward(request, response);
			break;
		case 5:
			List<Utilisateur> utilisateurs = utilisateurdao.listerInv();
			request.setAttribute("utilisateurs", utilisateurs);
			this.getServletContext().getRequestDispatcher(VUE5).forward(request, response);
			break;
		case 6:
			List<Utilisateur> mmbrsoc = utilisateurdao.listerMmbr();
			Map<Integer, Societe> map = societedao.listerMap();
			request.setAttribute("membres", mmbrsoc);
			request.setAttribute("map", map);
			this.getServletContext().getRequestDispatcher(VUE6).forward(request, response);
			break;
		default:
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.valueOf(request.getParameter("page"));
		switch(page) {
		case 2:
			SocFormAdmin form = new SocFormAdmin();
			Societe societe = form.rechercher(request);
			Secteur secteur = form.chercherSocieteBySec();
			//System.out.println(societe.getNom()); // debug
			if(secteur.getNom() == null && societe.getNom() != null) {
				societe = societedao.getByNom(societe.getNom());
				secteur = secteurdao.getNomById(societe.getId_secteur());
				
				request.setAttribute("societe", societe);
				request.setAttribute("secteur", secteur);
				
				this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
				break;
			}else if(secteur.getNom() == null && societe.getNom() == null) {
				
				List<Societe> societes = societedao.lister();
				List<Secteur> secteurs = new ArrayList<Secteur>();
				for(Societe s : societes) {
					secteurs.add(secteurdao.getNomById(s.getId_secteur()));
				}
				request.setAttribute("societes", societes);
				request.setAttribute("secteurs", secteurs);
				this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
				break;
				
			}else if(secteur.getNom() != null && societe.getNom() == null) {
				secteur = secteurdao.getIdByNom(secteur.getNom());
				List<Societe> societes = societedao.listerBySec(secteur.getId_secteur());
				//societe = societedao.getByNom(societe.getNom());
				
				//secteur = secteurdao.getNomById(societe.getId_secteur());
				request.setAttribute("societes", societes);
				request.setAttribute("secteur", secteur);
				this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
				break;
			}
			this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
			break;
		case 3:
			this.getServletContext().getRequestDispatcher(VUE3).forward(request, response);
			break;
		case 4:
			this.getServletContext().getRequestDispatcher(VUE4).forward(request, response);
			break;
		case 5:
			this.getServletContext().getRequestDispatcher(VUE5).forward(request, response);
			break;
		case 6:
			this.getServletContext().getRequestDispatcher(VUE6).forward(request, response);
			break;
		default:
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		}
	}
}
package marcheSecondaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import marcheSecondaire.beans.Utilisateur;
import marcheSecondaire.dao.DaoFactory;
import marcheSecondaire.dao.UtilisateurDao;
import marcheSecondaire.forms.ConnexionForm;

public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	
	public static final String ATT_SESSION_INV_POT_USER = "inves_pot";
	public static final String ATT_SESSION_ADMIN = "admin";
	public static final String ATT_SESSION_INV = "investisseur";
	public static final String ATT_SESSION_MMBR = "membre";
	
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/connexion.jsp";
	private UtilisateurDao utilisateurdao;
	private int id;
	private int type;
	
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurdao = daoFactory.getUtilisateurDao();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ConnexionForm form = new ConnexionForm();
		Utilisateur utilisateur = form.connecterUtilisateur(request);
		utilisateur = utilisateurdao.existe(utilisateur);
		id = utilisateur.getId_utilisateur();
		type = utilisateur.getType();
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, utilisateur);
		if(id == 0) {
			session.setAttribute(ATT_SESSION_USER, null);
			request.setAttribute("cantConnect", "email ou mot de passe incorrect ! ressayez !");
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		}else {
			switch(type) {
				case 0:
					session.setAttribute(ATT_SESSION_ADMIN, utilisateur);
					this.getServletContext().getRequestDispatcher("/adminPages/connected.jsp?id="+id).forward(request, response);
					break;
				case 1:
					session.setAttribute(ATT_SESSION_MMBR, utilisateur);
					this.getServletContext().getRequestDispatcher("/mmbrSocPages/connected.jsp?id="+id).forward(request, response);
					break;
				case 2:
					session.setAttribute(ATT_SESSION_INV, utilisateur);
					this.getServletContext().getRequestDispatcher("/investPages/connected.jsp?id="+id).forward(request, response);
					break;
				case 3:
					session.setAttribute(ATT_SESSION_INV_POT_USER, utilisateur);
					this.getServletContext().getRequestDispatcher("/investPotPages/connected.jsp?id="+id).forward(request, response);
					break;
				default:
					session.setAttribute(ATT_SESSION_USER, utilisateur);
					this.getServletContext().getRequestDispatcher("/WEB-INF/connected.jsp?id="+id).forward(request, response);
			}
			
		}
	}
}
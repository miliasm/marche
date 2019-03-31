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
import marcheSecondaire.forms.CompleterInvForm;

public class CompleterInv extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE = "/investPotPages/completer.jsp";
	private UtilisateurDao utilisateurdao;
	
	@Override
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurdao = daoFactory.getUtilisateurDao();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CompleterInvForm form = new CompleterInvForm();
		Utilisateur utilisateur = form.completerUtilisateur(request);
		HttpSession session = request.getSession();
		utilisateur.setId_utilisateur(((Utilisateur)session.getAttribute("inves_pot")).getId_utilisateur());
		utilisateurdao.completerInv(utilisateur);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
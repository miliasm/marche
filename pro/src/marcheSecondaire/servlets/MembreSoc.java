package marcheSecondaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mmbrSocPages/connected")
public class MembreSoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE1 = "/mmbrSocPages/connected.jsp";
	public static final String VUE2 = "/mmbrSocPages/infos.jsp";
	public static final String VUE3 = "/mmbrSocPages/newoffre.jsp";
       

    public MembreSoc() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
		default:
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		}
		
	}
}

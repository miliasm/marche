package marcheSecondaire.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class InvestPotFilter
 */
@WebFilter("/investPotPages/*")
public class InvestPotFilter implements Filter {
	
	public static final String ACCES_PUBLIC     = "/index.html";
	public static final String ATT_SESSION_INV_POT_USER = "inves_pot";

    /**
     * Default constructor. 
     */
    public InvestPotFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* R�cup�ration de la session depuis la requ�te */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connect�.
         */
        if ( session.getAttribute( ATT_SESSION_INV_POT_USER ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
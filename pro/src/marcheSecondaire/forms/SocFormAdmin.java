package marcheSecondaire.forms;

import javax.servlet.http.HttpServletRequest;

import marcheSecondaire.beans.Secteur;
import marcheSecondaire.beans.Societe;

public class SocFormAdmin {

	private static final String CHAMP_SOC  = "nomste";
	private static final String CHAMP_SEC  = "composant";
	private Societe societeObj;
	private Secteur secteurObj;
	
	public Societe rechercher(HttpServletRequest request) {
		String soc = getValeurChamp( request, CHAMP_SOC );
        String sector = getValeurChamp( request, CHAMP_SEC );
        societeObj = new Societe();
        secteurObj = new Secteur();
        societeObj.setNom(soc);
        secteurObj.setNom(sector);
		return societeObj;
	}
	
	
	public Secteur chercherSocieteBySec() {
    	return this.secteurObj;
    }
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
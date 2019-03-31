package marcheSecondaire.forms;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import marcheSecondaire.beans.Utilisateur;

public class CompleterInvForm {

	private static final String CHAMP_CIN  = "cin";
    private static final String CHAMP_BK   = "carte";
    private static final String CHAMP_EXP   = "dateexp";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private boolean correct = false; // indiquer si le formulaire est bon
    
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public Utilisateur completerUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String cin = getValeurChamp( request, CHAMP_CIN );
        String carte = getValeurChamp( request, CHAMP_BK );
        String dateexp = getValeurChamp(request, CHAMP_EXP);
        Utilisateur utilisateur = new Utilisateur();
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            validationCarte(carte);
        } catch ( Exception e ) {
            setErreur(CHAMP_BK, e.getMessage());
        }
        utilisateur.setCarte(carte);
        
        try {
			//utilisateur.setDateexp(format.parse(dateexp));
        	utilisateur.setDateexp(dateexp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			setErreur(CHAMP_EXP, e.getMessage());
		}
        
        utilisateur.setCin(cin);
        
        if ( erreurs.isEmpty() ) {
            resultat = "Modification a été prise en compte. Reconnectez-vous !";
            this.correct = true;
        } else {
            resultat = "Échec de modification.";
            this.correct = false;
        }

       

        
        return utilisateur;
    }

    /*
     * Valider la carte bancaire.
     */
    private void validationCarte( String carte ) throws Exception {
        if ( carte != null && carte.length() != 16 ) {
            throw new Exception( "Ce champ doit contenir exactement 16 chiffres." );
        }
    }
    
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur(String champ, String message) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
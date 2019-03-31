package marcheSecondaire.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import marcheSecondaire.beans.Secteur;
import marcheSecondaire.beans.Societe;
import marcheSecondaire.beans.Utilisateur;

public final class InscriptionForm {

	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_CONF   = "confirmation";
    private static final String CHAMP_NOM    = "nom";
    private static final String CHAMP_PRENOM    = "prenom";
    private static final String CHAMP_SOCIETE = "societe";
    private static final String CHAMP_CAP = "capitalisation";
    private static final String CHAMP_SEC = "secteur";
    private static final String CHAMP_DESC = "description";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    
    private boolean correct = false; // indiquer si le formulaire est bon
    private Societe societeObj;
    private Secteur secteurObj;
    
    public boolean isCorrect() {
		return correct;
	}
    
    public String getResultat() {
        return resultat;
    } 

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public Utilisateur inscrireUtilisateurInvest( HttpServletRequest request) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );

        Utilisateur utilisateur = new Utilisateur();
        
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        utilisateur.setPassword( motDePasse );
        utilisateur.setType(3);
        
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        try {
            validationNom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription. Connectez-vous !";
            this.correct = true;
        } else {
            resultat = "Échec de l'inscription.";
            this.correct = false;
        }
        
        return utilisateur;
    }
    
    public Utilisateur inscrireUtilisateurMmbr( HttpServletRequest request) {
    	String email = getValeurChamp( request, CHAMP_EMAIL );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String societe = getValeurChamp(request, CHAMP_SOCIETE);
        String capitalisation = getValeurChamp(request, CHAMP_CAP);
        String secteur = getValeurChamp(request, CHAMP_SEC);
        String description = getValeurChamp(request, CHAMP_DESC);
        
    	societeObj = new Societe();
    	secteurObj = new Secteur();
    	Utilisateur utilisateur = new Utilisateur();
    	
    	utilisateur.setType(1);
    	try {
            validationNom(societe);
        } catch ( Exception e ) {
            setErreur(CHAMP_SOCIETE, e.getMessage() );
        }
    	societeObj.setNom(societe);
    	
    	try {
            validationCap(capitalisation);
        } catch ( Exception e ) {
            setErreur(CHAMP_CAP, e.getMessage() );
        }
    	societeObj.setCapitalisation(Integer.valueOf(capitalisation));
    	
    	secteurObj.setNom(secteur);
    	
    	societeObj.setDescription(description);
    	// ###########
    	
    	try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        try {
            validationNom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription. Connectez-vous !";
            this.correct = true;
        } else {
            resultat = "Échec de l'inscription.";
            this.correct = false;
        }
        
        return utilisateur;
    }
    
    public Societe inscrireSociete() {
    	return this.societeObj;
    }
    
    public Secteur getSecteur() {
    	return this.secteurObj;
    }
    
    /*
     * Traitements sur les données
     * */
    
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Ce champ doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationCap( String nom ) throws Exception {
        if ( nom == null  ) {
            throw new Exception( "Ce champ doit etre non vide !." );
        }else {
        	if(!nom.matches("\\d+")) {
        		throw new Exception( "Ce champ doit contenir que des chiffres !." );
        	}
        }
    }
    
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
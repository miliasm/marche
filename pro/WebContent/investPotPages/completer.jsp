<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/marcheSecondaire/form.css" />
<title>Completer profil</title>
</head>
	<body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">
                    <li><a href="/marcheSecondaire/deconnexion">Logout</a></li>
                </ul>
            </div>   
        </header>
        <section id ="formulaireprofil"> 
            <form id = "formulairesignup" method="post" action="signup">
              <fieldset>
                <legend>Profil Invesitisseur</legend>
                <p>Afin de completer votre profil veuillez remplir ce formulaire.</p>
                <label for="CIN">CIN<span class="requis">*</span></label>
                <input type="text" id="CIN" name="CIN" value="" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['CIN']}</span>
                <br />
                <label for="CarteBancaire">N° Carte Bancaire<span class="requis">*</span></label>
                <input type="number" id="CarteBancaire" name="CarteBancaire" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['CarteBancaire']}</span>
                <br />
                <label for="DateExpiration">Date d'expiration<span class="requis">*</span></label>
                <input type="date" id="DateExpiration" name="DateExpiration" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['DateExpiration']}</span>
                <br />
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
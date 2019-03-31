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
            <form id = "formulaire" method="post" action="completer">
              <fieldset>
                <legend>Profil Invesitisseur</legend>
                <p>Afin de completer votre profil veuillez remplir ce formulaire.</p>
                <label for="cin">CIN<span class="requis">*</span></label>
                <input type="text" id="cin" name="cin" value="" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['cin']}</span>
                <br />
                <label for="carte">N° Carte Bancaire<span class="requis">*</span></label>
                <input type="text" id="carte" name="carte" value="" size="20" maxlength="16" />
                <span class="erreur">${form.erreurs['carte']}</span>
                <br />
                <label for="dateexp">Date d'expiration<span class="requis">*</span></label>
                <input type="date" id="dateexp" name="dateexp" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['dateexp']}</span>
                <br />
                <input type="submit" value="Completer Profil" class="sansLabel" />
                <br />
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
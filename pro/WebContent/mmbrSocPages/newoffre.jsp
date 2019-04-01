<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Offre</title>
        <link type="text/css" rel="stylesheet" href="/marcheSecondaire/form.css" />
    </head>
    <body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">
                    <li><a href="connected?page=2">Infos Société </a></li>
                    <li><a href="connected?page=3">Nouvelle Offre </a></li>
                     <li><a href="/marcheSecondaire/deconnexion">Logout</a></li>
                </ul>
            </div>   
        </header>
        <section id ="formulaireprofil"> 
            <form id = "formulaire" method="post" action="XXX">
              <fieldset>
                <legend>Publier une nouvelle offre</legend>
                <p>Veuillez compléter les informations liées à votre offre. </p>
                <label for="type">Type de l'offre <span class="requis">*</span></label>
                <select id="secteur" name="secteur"><span class="requis">*</span>
                  <option> Action </option>
                  <option> Stock-option </option>
                </select>
                <br/>
                <label for="quantite">Quantité <span class="requis">*</span></label>
                <input type="number" step="8" value="0" min="0" max="200">
                <br/>
                <label for="prix">Prix unitaire en Euros <span class="requis">*</span></label>
                <input type="text" id="prix" name="prix" value="" size="5" maxlength="60" /> 
                <br/>
                <label for="negociation">Négociable</label>
                <input type="checkbox" name="negociable" value="1">
                <br/>
                <br/>
                <label for="datenegociation">Si oui, date de fin de négociation</label>
                <input type="date"  id="datenegociation" name="datenegociation" value=""/> 
                <br/>
                <br />            
                <input type="submit" value="Publier" class="sansLabel" />
                <br />
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
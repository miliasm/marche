<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Sociétés</title>
        <link type="text/css" rel="stylesheet" href="/marcheSecondaire/form.css" />
    </head>
    <body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">               
                    <li><a href="connected?page=2">Sociétés </a></li>
                    <li><a href="connected?page=3">Offres </a></li>
                    <li><a href="connected?page=4">Mes transactions </a></li>
                    <li><a href="/marcheSecondaire/deconnexion">Logout</a></li>               
                </ul>
            </div>   
        </header>
        <section id ="formulaireprofil"> 
            <form id = "formulaire" method="post" action="XXX">
              <fieldset>
                <legend>Contrats disponibles</legend>
                <p>Précisez les critères de votre recherche.</p>
                <label for="societe">Nom de la Société</label>
                <input type="text" id="societe" name="societe" value="" size="34" maxlength="60" />
                <br/>
                <label for="type_con">Type(s) de contrat(s) </label>
				        <input type="radio" name="composant" value="Action"> Action
				        <input type="radio" name="composant" value="Stock option"> Stock-option  
				 
                <input type="submit" value="Filtrer" class="sansLabel" />
                <br/><br/>
                <table class="tg">
        				  <tr>
        				    <th class="tg-7btt">Type du contrat</th>
        				    <th class="tg-7btt">Nom de la société </th>
        				    <th class="tg-7btt">Prix</th>
                    <th class="tg-7btt">Détails</th>
                    <th class="tg-7btt">Disponible(s)</th>
        				  </tr>
        				  <tr>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
                    <td class="tg-0lax"></td>
                    <td class="tg-0lax"></td>
        				  </tr>
        				</table>
                <br/><br/>
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Les contrats disponibles</title>
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
                <legend>Mon historique de transactions </legend>
                <br/>
                <table class="tg">
        				  <tr>
        				    <th class="tg-7btt">Type du contrat</th>
        				    <th class="tg-7btt">Nom de la société </th>
        				    <th class="tg-7btt">Montant total</th>
        				    <th class="tg-7btt">Date</th>
        				  </tr>
        				  <tr>
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
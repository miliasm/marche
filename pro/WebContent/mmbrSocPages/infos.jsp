<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Données Société</title>
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
                <legend>Données Société</legend>
                <p>Dites-nous plus sur votre société.</p>
                <label for="nomste">Nom de la Société <span class="requis">*</span></label>
                <input type="text" id="nomste" name="nomste" value="" size="34" maxlength="60" />
                <br />
                <label for="secteur">Secteur d'activité <span class="requis">*</span></label>
                <select id="secteur" name="secteur">Secteur d'activité<span class="requis">*</span>
                  <OPTION> Agriculture </OPTION>
                  <OPTION> Assurances </OPTION>
                  <OPTION> Banques </OPTION> 
                  <OPTION> Bien de consommation </OPTION>
                  <OPTION> Hôtellerie </OPTION>
                  <OPTION> Industrie </OPTION>
                  <OPTION> Technologies et services de l'information </OPTION>
                </select>
                <br />
                <label for="capital">Capitalisation boursière<span class="requis">*</span></label>
                <input type="text" id="capital" name="capital" value="" size="34" maxlength="60" />
                <br /> 
                <label for="des">Description</label>
                <textarea id="des" name="des" value="" rows=6 cols=38> </textarea>
                <br />
                <input type="submit" value="Valider" class="sansLabel" />
                <br />
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
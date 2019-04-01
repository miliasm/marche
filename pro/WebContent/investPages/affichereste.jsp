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
            <form id = "formulaire" method="post" action="connected?page=2">
              <fieldset>
                <legend>Afficher les sociétés disponibles</legend>
                <p>Précisez les critères de votre recherche.</p>
                <label for="nomste">Nom de la Société</label>
                <input type="text" id="nomste" name="nomste" value="" size="34" maxlength="60" />
                <br/>
                <label for="sect">Secteur(s)</label>
				        <input type="radio" name="composant" value="Agriculture"> Agriculture 
				        <input type="radio" name="composant" value="Assurances"> Assurances 
				        <input type="radio" name="composant" value="Banques"> Banques
				        <input type="radio" name="composant" value="Biens de consommation"> Biens de consommation 
				        <input type="radio" name="composant" value="Hotellerie"> Hotellerie 
				        <input type="radio" name="composant" value="Industrie"> Industrie<br/> 
				        <input type="radio" name="composant" value="Technologies et services de l'information"> Technologies et services de l'information <br/> 
                <br/>
                <input type="submit" value="Filtrer" class="sansLabel" />
                <br/><br/>
                <table class="tg">
        				  <tr>
        				    <th class="tg-7btt">Nom de la société</th>
        				    <th class="tg-7btt">Capitalisation boursière</th>
        				    <th class="tg-7btt">Secteur d'activité</th>
        				    <th class="tg-7btt">Description</th>
        				  </tr>
        				  
        				  <c:choose>
        				  	<c:when test="${!empty societe }">
        				  
        				  <tr>
        				    <td class="tg-0lax"><c:out value="${societe.nom}" /></td>
        				    <td class="tg-0lax"><c:out value="${societe.capitalisation}" /></td>
        				    <td class="tg-0lax"><c:out value="${secteur.nom}" /></td>
        				    <td class="tg-0lax"><c:out value="${societe.description}" /></td>
        				  </tr>
        				  
        				  
        				  	</c:when>
        				  	
        				  	<c:when test="${!empty societes }">
        				  	
        				  		<c:if test="${!empty secteurs }">
        				  			<c:forEach var="soc" items="${ societes }" varStatus="status">
            							<tr>
        				    				<td class="tg-0lax"><c:out value="${soc.nom}" /></td>
					        				<td class="tg-0lax"><c:out value="${soc.capitalisation}" /></td>
					        				<td class="tg-0lax"><c:out value="${secteurs[status.index].nom}" /></td>
					        				<td class="tg-0lax"><c:out value="${soc.description}" /></td>
					        			</tr>
        							</c:forEach>
        				  		</c:if>
        				  		
        				  		<c:if test="${!empty secteur }">
        				  			<c:forEach var="soc" items="${ societes }">
            							<tr>
        				    				<td class="tg-0lax"><c:out value="${soc.nom}" /></td>
					        				<td class="tg-0lax"><c:out value="${soc.capitalisation}" /></td>
					        				<td class="tg-0lax"><c:out value="${secteur.nom}" /></td>
					        				<td class="tg-0lax"><c:out value="${soc.description}" /></td>
					        			</tr>
        							</c:forEach>
        				  		</c:if>
        				  	
        				  	</c:when>
        				  
        				  
        				  </c:choose>
        				  
        				  <tr>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				  </tr>
        				  <tr>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				  </tr>
        				  <tr>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				    <td class="tg-0lax"></td>
        				  </tr>
                   </table>
              </fieldset>
            </form>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
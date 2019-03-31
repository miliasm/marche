<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Les Membres Société</title>
        <link type="text/css" rel="stylesheet" href="/marcheSecondaire/form.css" />
    </head>
    <body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">
                    <li><a href="connected?page=2">Sociétés </a></li>
                    <li><a href="connected?page=3">Offres </a></li>
                    <li><a href="connected?page=4">Transactions </a></li>
                    <li><a href="connected?page=5">Investisseurs </a></li>
                    <li><a href="connected?page=6">Membres sociétés </a></li>
                    <li><a href="/marcheSecondaire/deconnexion">Logout</a></li>
                </ul>
            </div>   
        </header>
        <section id ="formulaireprofil"> 
            <form id = "formulaire" method="post" action="XXX">
              <fieldset>
                <legend>La liste des membres sociétés</legend>
                <br/><br/>
                <table class="tg">
        				  <tr>
        				    <th class="tg-7btt">Nom</th>
        				    <th class="tg-7btt">Prénom </th>
        				    <th class="tg-7btt">Nom Société</th>
        				  </tr>
        				  
        				  <c:if test="${!empty membres }">
        				  	<c:forEach var="membre" items="${ membres }">
        				  	<tr>
        				  		<td class="tg-0lax"><c:out value="${membre.nom}" /></td>
        				    	<td class="tg-0lax"><c:out value="${membre.prenom}" /></td>
        				    	<td class="tg-0lax"><c:out value="${map[membre.societe].nom}" /></td>
        				    </tr>
        				  	</c:forEach>
        				  </c:if>
        				  <tr>
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
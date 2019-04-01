<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
         <title>signup</title>
         <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
    
    
    <c:choose>
    	<c:when test="${ param.type eq 'inv' }">
        
	        <section id ="SignUp"> 
	          <form id = "formulaire" method="post" action="signup">
	            <fieldset>
	                <legend>Sign Up</legend>
	                <p>Vous pouvez vous inscrire via ce formulaire.</p>
	                <label for="nom">Nom </label>
	                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['nom']}</span>
	                <br />
	                <label for="prenom">Prénom </label>
	                <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['prenom']}</span>
	                <br />
	                <label for="email">Adresse email (login) <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['email']}</span>
	                <br />
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['motdepasse']}</span>
	                <br />
	                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
	                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['confirmation']}</span>
	                <br />
	                
	                <input type="submit" value="Inscription" class="sansLabel" />
	                <br />
	                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	            </fieldset>
	          </form>
	        </section>
        </c:when>
        <c:when test="${ param.type eq 'mmbr' }">
        	<!-- <p><c:out value="${param.type }"/></p><br> -->
        	<section id ="SignUp"> 
	          <form id = "formulaire" method="post" action="signup">
	            <fieldset>
	                <legend>Sign Up</legend>
	                <p>Vous pouvez vous inscrire via ce formulaire.</p>
	                <label for="nom">Nom </label>
	                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['nom']}</span>
	                <br />
	                <label for="prenom">Prénom </label>
	                <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['prenom']}</span>
	                <br />
	                <label for="email">Adresse email (login) <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['email']}</span>
	                <br />
	                <label for="societe">Nom Societé <span class="requis">*</span></label>
	                <input type="text" id="societe" name="societe" value="<c:out value="${societe.nom}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['societe']}</span>
	                <br />
	                <label for="capitalisation">Capitalisation <span class="requis">*</span></label>
	                <input type="text" id="capitalisation" name="capitalisation" value="<c:out value="${societe.capitalisation}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['capitalisation']}</span>
	                <br /><br/>
	                
	                <label for="secteur">Secteur d'activité <span class="requis">*</span></label>
	                <select name = "secteur" id="secteur">
			            <option value = "Agriculture" selected>Agriculture</option>
			            <option value = "Assurances">Assurances</option>
			            <option value = "Banques">Banques</option>
			            <option value = "Biens de consommation">Biens de consommation</option>
			            <option value = "Hotellerie">Hotellerie</option>
			            <option value = "Industrie">Industrie</option>
			            <option value = "Technologies et services de l'information">Technologies et services de l'information</option>
         			</select>
         			<br/><br/>
	                
	                <label for="description">Description </label>
	                <textarea id="dessociete" rows="5" cols = "30" name = "description" ><c:out value="${societe.description}"/></textarea>
	                <!--  <input type="textarea" id="description" name="description" value="<c:out value="${societe.description}"/>" size="20" maxlength="60" />-->
	                <span class="erreur">${form.erreurs['description']}</span>
	                <br />
	                
	                <input type="submit" value="Inscription" class="sansLabel" />
	                <br />
	                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	            </fieldset>
	          </form>
	        </section>
        </c:when>
    </c:choose>
        <footer>          
        </footer> 
    </body>
</html>
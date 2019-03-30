<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <section id ="connexion">
        <form id ="formulaireconnexion" method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                <!-- <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p><br/> -->
                <p class="${empty requestScope ? '' : 'erreur'}">${requestScope.cantConnect}</p>
            </fieldset>
        </form>
      </section>
    </body>
</html>
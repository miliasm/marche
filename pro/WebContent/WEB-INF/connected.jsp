<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ include file="header.jsp" %> --%>
<%@ include file="footer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="form.css" />
<title>Success ${sessionScope.sessionUtilisateur.nom}</title>
</head>
<body>
	<header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul>
                    <li><a href="#">Companies</a></li>
                    <li><a href="#">Marketplace</a></li>
                    <li><a href="deconnexion">Logout</a></li>
                    
                </ul>
            </div>    
        </header>
	<h4>Bonjour ${sessionScope.sessionUtilisateur.nom}</h4>
</body>
</html>
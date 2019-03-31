<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Bienvenue Admin</title>
        <link type="text/css" rel="stylesheet" href="/marcheSecondaire/form.css" />
    </head>
    <body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">
                    <li><a href="adminPages/connected?page=2">Sociétés </a></li>
                    <li><a href="adminPages/connected?page=3">Offres </a></li>
                    <li><a href="adminPages/connected?page=4">Transactions </a></li>
                    <li><a href="adminPages/connected?page=5">Investisseurs </a></li>
                    <li><a href="adminPages/connected?page=6">Membres sociétés </a></li>
                    <li><a href="/marcheSecondaire/deconnexion">Logout</a></li>
                </ul>
            </div>   
        </header>
        <section id ="formulaireprofil">
            <p id="bienvenue">Bienvenue sur votre espace administrateur !</p>
        </section> 
        <footer>          
        </footer>   
    </body>
</html>
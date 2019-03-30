<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
       <header>
            <p id="AM"> AssetMarket </p>
            <div id="menu">
                <ul id="menu-deroulant">
                    <li><a href="#">Marketplace</a></li>
                    <li><a href="/marcheSecondaire/connexion">Login</a></li>
                    <li><a href="/marcheSecondaire/">Sign Up</a>
                        <ul>
                            <li><a href="signup?type=inv">Investisseur</a></li>
                            <li><a href="signup?type=mmbr">MembreSociete</a></li>
                        </ul>
                    </li>
                </ul>
            </div>   
        </header>
        <section>
            <img id="wal" src="/marcheSecondaire/images/wal.jpg">
            <p id="slogan">Sign Up and buy your future <br>private shares </p>
        </section>  
        <footer>          
        </footer>  
</body>
</html>
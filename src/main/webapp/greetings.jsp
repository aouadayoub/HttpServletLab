<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to this amazing web application</title>
</head>
<body>
<div align="center">
    <h1>Tenter votre chance à cette loterie virtuelle!</h1>
    <form action="./hello" method="post">
        Votre nom svp: <input type="text" name="nom"><br>
        Votre rôle: <input type="text" name="role"><br><br>
        Voulez-vous supprimer ce nom de la base de données?<br>
        Oui <input type="radio" id="Oui" name="delete" value="1"><br>
        Non <input type="radio" id="Non" name="delete" value="0"><br><br>
        <input type="submit" value="Soumettre">
    </form>
</div>
</body>
</html>

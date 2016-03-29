<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>InfoMore - Definir um Local</title>
</head>
<body>

	<h1>Meu Local</h1>
	<form action="Mapa?local=meulocal" method="post">
		Latitude:  <input name="latitude" type="text" value="" /> <br>
		Longitude: <input name="longitude" type="text" value="" /> <br>
		<input type="submit" value="Definir como 'Meu Local'">
		
	</form>
</body>
</html>



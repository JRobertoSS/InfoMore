<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">
	
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDPLEj4invnE6TCsJSRR7ePqD7eAAJs4Pw"></script>

	<script type="text/javascript" src="js/angular.js"></script>

	<script type="text/javascript" src="js/app.js"></script>

	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
	
	<link href="css/login.css" rel="stylesheet"/>

<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<title>Infomore</title>
</head>
<body>
	<h3>InfoMore</h3><br>
	<p>Logo aqui!</p><br>
	<br>
	<br>
	<div id="page-content-wrapper" class="container"> 
		
		<form action="login?acao=consultar">

			<div class="row">
				<div class="input-field col s12">
					<i class="material-icons prefix">email</i>
					<input id="email" type="email" class="validate" name="">
					<label for="email">Email</label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s12">
					<i class="material-icons prefix">lock</i>
					<input id="password" type="password" class="validate" name="">
					<label for="password">Senha</label>
				</div>
			</div>

			<div class="center-align">
				<input  type="submit" class="waves-effect waves-light btn botao" name="buttonEntrar" value="Entrar"/>
			</div>
			
			<div class="center-align">
				<a class="waves-effect" href="navegar?acao=cadastro">Sou novo por aqui!</a>
			</div>
			
		</form>

	</div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>
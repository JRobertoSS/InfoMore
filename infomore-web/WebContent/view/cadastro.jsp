<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
	<meta charset="UTF-8">
	
		<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>	
	<script type="text/javascript" src="js/cadastro.js"></script>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDPLEj4invnE6TCsJSRR7ePqD7eAAJs4Pw"></script>

	<script type="text/javascript" src="js/angular.js"></script>

	<script type="text/javascript" src="js/app.js"></script>

	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<link href="css/perfil.css" rel="stylesheet">

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<title>Infomore</title>
</head>
<body>
	<nav>
		<div class="nav-wrapper teal menuNav">	
			<ul id="nav-mobile" class="left">
				<h4 class="cadastro">Cadastro</h4>
			</ul>
		</div>
	</nav>

	<div class="container">
		<form action="cadastro?acao=salvar" method="post" class="col s12">
			<div class="row form-content">
				<div class="input-field col s12">
					<i class="material-icons prefix">account_circle</i>
					<label for="inputNome" class="labels">Nome</label>
					<input id="inputNome" name="inputNome" type="text" class="validate form-input">
				</div>

				<div class="input-field col s12">
					<i class="material-icons prefix">email</i>
					<label for="inputEmail" class="labels">E-mail</label>
					<input id="inputEmail" name="inputEmail" type="tel" class="validate form-input">
				</div>

				<div class="input-field col s12">
					<i class="material-icons prefix">date_range</i>
					<label for="inputData" class="labels">Data de Nascimento</label><br>
					<input id="inputData" name="inputData" type="date" class="validate form-input">
				</div>
					
				<div class="input-field col s12">
					<i class="material-icons prefix">lock</i>
					<label for="Senha" class="labels">Senha</label>
					<input id="inputSenha" name="inputSenha" type="password" class="validate form-input">
				</div>
			</div>
		
			<div class="row center-align">
				<div class="col s6">
					<input class="waves-effect waves-light btn" type="submit"  value="Cadastrar"/>
				</div>
				<div class="col s6">
					<a class="btn waves-effect waves-teal white black-text" href="navegar?acao=cadastro">Limpar</a>
				</div>
			</div>
			<div class="center-align">
				<a class="btn waves-effect waves-teal lighten-1 blue" href="navegar?acao=login">Cancelar</a>
			</div>
		</form>
	</div>
	

</body>
</html>
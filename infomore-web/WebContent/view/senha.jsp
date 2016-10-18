<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">

		<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>	
	<script type="text/javascript" src="js/perfil.js"></script>

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
		
		<ul id="dropdownOpcoes" class="dropdown-content">
			<li> <a href="principal.html" >Mapa</a> </li>
			<li> <a href="perfil.html" >Atualizar Perfil</a> </li>
			<li> <a href="senha.html" >Atualizar Senha</a> </li>
			<li> <a href="#!" >Meus Locais</a> </li>
			<li> <a href="#!" >Relatórios</a> </li>
			<li class="divider"></li>
			<li><a href="login.html">Sair</a></li>
		</ul>

		<div class="nav-wrapper teal menuNav">
			
			<ul id="nav-mobile" class="left">
				<li><h3 class="meuPerfil">Senha</h3></li>
			</ul>

			<ul id="nav-mobile" class="right">
				<li><a href="#" id="dropdownButtonOpcoes" class="dropdown-button" data-beloworigin="true" data-activates="dropdownOpcoes"><i class="material-icons">settings</i></a></li>
			</ul>

		</div>

	</nav>

	<div class="container">
		<div class="row">
		    <form class="col s12">

				<div class="row form-content">

				<div class="input-field col s12">
						<i class="material-icons prefix">lock_outline</i>
						<label for="inputSenhaAtual" class="labels">Senha atual</label>
						<input id="inputSenhaAtual" type="password" class="validate form-input">
					</div>

					<div class="input-field col s12">
						<i class="material-icons prefix">lock</i>
						<label for="inputSenhaNova" class="labels">Senha nova</label>
						<input id="inputSenhaNova" type="password" class="validate form-input">
					</div>

					<div class="input-field col s12">
						<i class="material-icons prefix">lock</i>
						<label for="inputConfirmarSenhaNova" class="labels">Confirmar senha nova</label>
						<input id="inputConfirmarSenhaNova" type="password" class="validate form-input">
					</div>

					<div class="center-align">
						<!--<button class="btn waves-effect waves-light top" type="submit" name="action">Atualizar
							<i class="material-icons right">send</i>
						</button>-->
						<a class="btn waves-effect waves-light top" href="principal.html">Atualizar<i class="material-icons right">send</i></a>
					</div>
				</div>

		    </form>
	  	</div>

		
	</div>

	


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">

<!-- Import da taglib pra uso de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/perfil.js"></script>
<script type="text/javascript" src="js/comum.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>



<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/perfil.css" rel="stylesheet">



<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore</title>
</head>
<body>

	<%@ include file="menu/navigator.jsp"%>

	<div class="container">
		<div class="row">
			<form class="col s12" action="senha" method="post">
				
				<input type="hidden" name="acao" value="alterar"/>

				<div class="row form-content">

					<div class="input-field col s12">
						<i class="material-icons prefix">lock_outline</i> <label
							for="inputSenhaAtual" class="labels">Senha atual</label> <input
							id="inputSenhaAtual" name="inputSenhaAtual" type="password" class="validate form-input">
					</div>

					<div class="input-field col s12">
						<i class="material-icons prefix">lock</i> <label
							for="inputSenhaNova" class="labels">Senha nova</label> <input
							id="inputSenhaNova" name="inputSenhaNova" type="password" class="validate form-input">
					</div>

					<div class="input-field col s12">
						<i class="material-icons prefix">lock</i> <label
							for="inputConfirmarSenhaNova" class="labels">Confirmar
							senha nova</label> <input id="inputConfirmarSenhaNova" 
							 name="inputConfirmarSenhaNova" type="password"
							class="validate form-input">
					</div>

					<div class="center-align">
						<button class="btn waves-effect waves-light top" type="submit" name="action">Alterar senha
							<i class="material-icons right">send</i>
						</button>
				<!-- 		<a class="btn waves-effect waves-light top" href="principal.html">Atualizar<i
							class="material-icons right">send</i></a> -->
					</div>
				</div>

			</form>
		</div>

			<%@ include file="modal/mensagem.jsp" %>
	</div>




</body>
</html>
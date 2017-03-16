<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">

<!-- Import da taglib pra uso de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<link href="css/comum.css" rel="stylesheet">	

<link href="css/perfil.css" rel="stylesheet">



<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore</title>
</head>
<body class="corpo">

	<%@ include file="menu/navigator.jsp"%>

	<div class="container">
		<div class="row">
			<form class="col s12" action="perfil" method="post">

				<input type="hidden" name="acao" value="alterar">

				<div class="row form-content">

					<c:set value="${usuario}" var="usuario" scope="request" />

					<div class="input-field col s12">
						<i class="material-icons prefix">account_circle</i> 
						<input id="inputNome" name="inputNome" type="text" class="validate"
							value="${usuario.nome}">
						<label for="inputNome" >Nome</label> 
					</div>

					<div class="input-field col s12">
						<i class="material-icons prefix">email</i> 
						<input id="inputEmail" name="inputEmail" type="email" class="validate"
							value="${usuario.email}">
						<label for="inputEmail">E-mail</label> 
					</div>


					<c:set value="${formatador}" var="formatador" scope="request" />

					<div class="input-field col s12">
						<i class="material-icons prefix">date_range</i>
						<input id="inputData" name="inputData" type="date"
							class="validate form-input"
							value="${formatador.formataDateParaString(usuario.dtNascimento)}">
						<label for="inputData" class="active">Data de Nascimento</label>							
					</div>

					<div class="center-align">
						<button class="btn waves-effect waves-light top botao-confirmar" type="submit"
							name="action">
							Atualizar <i class="material-icons right">send</i>
						</button>
						<!-- <a class="btn waves-effect waves-light top" href="principal.html">Atualizar<i class="material-icons right">send</i></a> -->
					</div>

					<%@ include file="modal/mensagem.jsp" %>
				</div>

			</form>
		</div>

	</div>




</body>
</html>
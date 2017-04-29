<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<!-- Import da taglib pra uso de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/cadastro.js"></script>
<script type="text/javascript" src="js/comum.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">



<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/comum.css" rel="stylesheet">

<link href="css/cadastro.css" rel="stylesheet">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Cadastro</title>
</head>
<body class="corpo">
	
	<div id="page-content-wrapper" class="container">
		
		<img src="images/logo_infomore.png" alt="InfoMore" class="logo-infomore"/>
		
		<form action="cadastro" method="post" class="col s12" id="formCadastro">
			<div class="row form-content">
				<div class="input-field col s10">
					<i class="material-icons prefix">account_circle</i> <input
						id="inputNome" name="inputNome" type="text" class="validate">
					<label for="inputNome">Nome</label>
				</div>

				<div class="input-field col s10">
					<i class="material-icons prefix">email</i> <input id="inputEmail"
						name="inputEmail" type="email" class="validate"> <label
						for="inputEmail">E-mail</label>
				</div>

				<div class="input-field col s10">
					<i class="material-icons prefix">date_range</i> <input
						id="inputData" name="inputData" type="date" class="datepicker">
					<label for="inputData" class="active">Data de Nascimento</label>

				</div>

				<div class="input-field col s10">
					<i class="material-icons prefix">lock</i> <input id="inputSenha"
						name="inputSenha" type="password" class="validate"> <label
						for="inputSenha">Senha</label>
				</div>

				<div class="input-field col s10">
					<i class="material-icons prefix">lock</i> <input
						id="inputConfirmaSenha" name="inputConfirmaSenha" type="password"
						class="validate"> <label for="inputConfirmaSenha">Confirma
						Senha</label>
				</div>

			</div>

			<div class="row form-content">
				<div class="row col s12 center-align">
					<div class="col s6">
						<input
							class="waves-effect waves-light btn botao-cadastrar center-align"
							name="buttonCadastrar" type="submit" value="Cadastrar" />
					</div>
					<div class="col s6">
						<a class="waves-effect waves-light btn botao-cancelar"
							href="navegar?acao=login">Cancelar</a>
					</div>

				</div>
				<div class="row col s12 center-align">
					<div class="col s12">
						<a class="waves-effect waves-light btn botao-limpar"
							href="navegar?acao=cadastro">Limpar dados</a>
					</div>
				</div>
			</div>


			<input type="hidden" name="acao" value="salvar">
		</form>

		<%@ include file="modal/mensagem.jsp"%>

	</div>


</body>
</html>
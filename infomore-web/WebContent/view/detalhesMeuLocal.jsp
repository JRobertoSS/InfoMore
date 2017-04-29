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
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/mapa.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/comum.js"></script>


<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/comum.css" rel="stylesheet">

<link href="css/detalhesMeuLocal.css" rel="stylesheet">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore</title>
</head>
<body class="corpo">

	<%@include file="menu/navigator.jsp"%>

	<%@include file="modal/mensagem.jsp"%>

	<div id="page-content-wrapper" class="container espacamento-container">

		<c:set value="${meuLocal}" var="meuLocal" scope="session" />

		<c:if test="${ meuLocal != null }">
			<div class="row">
				<form class="col s12" action="meuLocal" method="post">

					<input type="hidden" name="acao" value="salvar">

					<div class="row form-content">

						<div class="input-field col s10">
							<p class="label ">Nome deste local:</p> 
						</div>
						</br>
						</br>
						<div class="input-field col s10">
							<input id="inputNome"
								name="inputNome" type="text" value="${meuLocal.nome}">
						</div>
						
						<div class="input-field col s10">
							<p class="label">Descreva este local:</p> 
						</div>
						
						<div class="input-field col s10">
							<input id="inputDescricao"
								name="inputDescricao" type="text"
								value="${meuLocal.descricao}">
						</div>
						
						
						<div class="input-field col s10 center">
							<h5>Informações do Local</h5> 
						</div>

						<div class="input-field col s10">
							<p><span class="label">Raio:</span> ${meuLocal.raio}</p>
						</div>

						<div class="input-field col s10">
							<p><span class="label">Latitude:</span> ${meuLocal.latitude}</p>
						</div>

						<div class="input-field col s10">
							<p><span class="label">Longitude:</span> ${meuLocal.longitude}</p>
						</div>

						<div class="row col s12 form-content center-align">
							<div class="col s12">

								<button class="btn waves-effect waves-light top botao-atualizar"
									type="submit" name="action">Salvar </button>
									
								<a class="btn waves-effect waves-light top"
									href="navegar?acao=mapa">Cancelar</a>
							</div>
						</div>

					</div>
				</form>
			</div>
		</c:if>


	</div>
</body>

</html>

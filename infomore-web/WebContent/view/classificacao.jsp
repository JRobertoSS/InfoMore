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
<script type="text/javascript" src="js/classificacao.js"></script>
<script type="text/javascript" src="js/comum.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>


<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/bootstrap.css" rel="stylesheet">

<link href="css/classificacao.css" rel="stylesheet">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore</title>
</head>
<body>

	<div class="container">

		<form action="classificacao?acao=alterarClassificacao" method="post">
			
			<c:set value="${usuario}" var="usuario" scope="session" />
			
			<!-- Classificações criadas dinamicamente ( Lista de ClassificacaoView no init() da Servlet) -->
			<c:forEach var="classificacaoView" items="${applicationScope['listaClassificacaoView']}">
				 <div class="row">
					<h4>
						<i class="material-icons">${classificacaoView.nomeIcone}</i> ${classificacaoView.categoria.nome}
					</h4>
					
					<!-- Varre as prioridades do usuário e binda no valor da classificação (para o caso de ser um update) -->
					<c:forEach var="prioridade" items="${usuario.prioridades}" >
						<c:if test="${ prioridade.categoria.nome == classificacaoView.categoria.nome }">
							<c:set value="${prioridade}" var="prioridadeEquivalente"/>
						</c:if>
					</c:forEach>
					
					<p class="range-field">
						${classificacaoView.categoria.descricao}
						<input type="range" id="${classificacaoView.nomeId}" name="${classificacaoView.nomeId}"
							min="0" max="10" value="${prioridadeEquivalente.peso}"/>
					</p>
				</div>
			</c:forEach>


			<div class="row center-align">
				<input type="submit" class="btn waves-effect waves-light botao"
					value="Prosseguir" />
			</div>

		</form>

	</div>


</body>
</html>
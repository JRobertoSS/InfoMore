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
<script type="text/javascript" src="js/resultadoComparacao.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="js/comum.js"></script>


<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/comum.css" rel="stylesheet">

<link href="css/resultadoComparacao.css" rel="stylesheet">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore - Resultado da Comparação</title>
</head>
<body class="corpo">

	<%@include file="menu/navigator.jsp"%>

	<%@include file="modal/mensagem.jsp"%>

	<div id="page-content-wrapper" class="container espacamento-container">

		<c:set value="${comparacao}" var="comparacao" scope="request" />
		<div class="row form-content">
			<table class="tabela">
				<thead>
					<tr>

						<th>Local</th>

						<th>Pontuação</th>

						<th></th>

					</tr>
				</thead>
				<c:forEach var="local" items="${comparacao.meusLocaisComparacao}">
					<tbody>
						<tr>
							<td>${local.nome}</td>

							<td>${comparacao.mapaIdPontuacaoLocal.get(local.id)}</td>

							<td>
								<a href="#"
									onclick="atualizarDetalhesDoLocal(${local.id})"> <img
										alt="detalhes" src="images/infomore_icon.png">
								</a>
							</td>


							<div id="page-content-wrapper"
								class="container espacamento-container">
								<ul>
									<li><i class="material-icons">local_hospital</i> <span
										class="x"> X </span> <span id="quantidadeSaude"></span></li>
									<li><i class="material-icons">school</i> <span class="x">
											X </span> <span id="quantidadeEducacao"></span></li>
									<li><i class="material-icons">security</i> <span class="x">
											X </span> <span id="quantidadeSeguranca"></span></li>
									<li><i class="material-icons">shopping_cart</i> <span
										class="x"> X </span> <span id="quantidadeComodidades"></span></li>
									<li><i class="material-icons">tag_faces</i> <span
										class="x"> X </span> <span id="quantidadeLazerCultura"></span></li>
									<li><i class="material-icons">directions_bus</i> <span
										class="x"> X </span> <span id="quantidadeTransportes"></span></li>
									<li><i class="material-icons">report</i> <span class="x">
											X </span> <span id="quantidadeOcorrencias"></span></li>
								</ul>

							</div>
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<div class="center espacamento-botoes">
				<a class="btn waves-effect waves-light top botao-voltar"
					href="meusLocais?acao=listar">Voltar</a>
			</div>

		</div>
	</div>



	<%@include file="detalhesComparacao.jsp"%>



</body>

</html>

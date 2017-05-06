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

<script>

</script>


<title>Infomore - Resultado da Comparação</title>
</head>
<body class="corpo">

	<%@include file="menu/navigator.jsp"%>

	<%@include file="modal/mensagem.jsp"%>

	<div id="page-content-wrapper" class="container espacamento-container">

		<c:set value="${comparacao}" var="comparacao" scope="request" />
		<c:set value="${jsonMap}" var="jsonMap" scope="request" />
		
		<script>
			document.mapaCategoriaQuantidade = JSON.parse('${jsonMap}');
		</script>
		
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

							<td><a href="#" class="button-collapse"
								onclick="atualizarDetalhesCategorias(${local.id})"> <img alt="detalhes"
									src="images/infomore_icon.png">
							</a></td>


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

	 <div class="modal center" id="modalDetalhes">
		<div id="page-content-wrapper" class="modal-content detalhes-modal">
			<ul>
				<li><i class="material-icons icone">local_hospital</i> <span
					class="x"> X </span> <span id="quantidadeSaude" class="quantidade"></span></li>
				<li><i class="material-icons icone">school</i> <span class="x">
						X </span> <span id="quantidadeEducacao" class="quantidade"></span></li>
				<li><i class="material-icons icone">security</i> <span class="x">
						X </span> <span id="quantidadeSeguranca" class="quantidade"></span></li>
				<li><i class="material-icons icone">shopping_cart</i> <span class="x">
						X </span> <span id="quantidadeComodidades" class="quantidade"></span></li>
				<li><i class="material-icons icone">tag_faces</i> <span class="x">
						X </span> <span id="quantidadeLazerCultura" class="quantidade"></span></li>
				<li><i class="material-icons icone">directions_bus</i> <span
					class="x"> X </span> <span id="quantidadeTransportes" class="quantidade"></span></li>
				<li><i class="material-icons icone">report</i> <span class="x">
						X </span> <span id="quantidadeOcorrencias" class="quantidade"></span></li>
			</ul>

		</div>
	</div>
	
	<%@include file="detalhesComparacao.jsp"%>



</body>

</html>

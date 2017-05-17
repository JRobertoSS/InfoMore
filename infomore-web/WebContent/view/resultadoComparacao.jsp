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
<script type="text/javascript" src="js/resultadoComparacao.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/comum.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


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

	<div id="page-content-wrapper" class="container">

		<c:set value="${comparacao}" var="comparacao" scope="request" />
		<c:set value="${jsonMap}" var="jsonMap" scope="request" />
		
		<script>
			document.mapaCategoriaQuantidade = JSON.parse('${jsonMap}');
			document.idLocais = ${comparacao.idsComparacao};
			document.locais = new Map();
		</script>
		
		<c:forEach var="local" items="${comparacao.meusLocaisComparacao}">
			<script>
				var id = Number(${local.id});
				var nome = '${local.nome}';
				document.locais.set(id, nome);
			</script>
		</c:forEach>
		
		<div class="row form-content">
			<table class="tabela">
				<thead>
					<tr>

						<th>Local</th>

						<th>Pontuação</th>

						<th></th>
						
						<th></th>

					</tr>
				</thead>
				<c:forEach var="local" items="${comparacao.meusLocaisComparacao}">
			
					<tbody>
						<tr>
							<td>${local.nome}</td>

							<td>${comparacao.mapaIdPontuacaoLocal.get(local.id)}</td>

							<td>
								<a href="#" class="button-collapse"
									onclick="atualizarDetalhesCategorias(${local.id}, '${local.nome}')"> 
									<img alt="detalhes" src="images/infomore_icon.png">
								</a>
							</td>
							
							<td><a href="#" class="button-collapse"
								onclick="atualizarGraficoCategorias(${local.id}, '${local.nome}')"> <img alt="grafico"
									src="images/pie_chart_icon.png">
							</a></td>


						</tr>
					</tbody>
				</c:forEach>
			</table>

			<div class="center espacamento-botoes">
			<p> <a class="btn waves-effect waves-light top botao-comparacao"
					href="#" onclick="atualizarGraficoComparacao();">Comparação Gráfica</a> </p>
				<p><a class="btn waves-effect waves-light top botao-voltar"
					href="meusLocais?acao=listar">Voltar</a></p>
			</div>

		</div>
	</div>

	 <div class="modal" id="modalDetalhes">
		<div id="page-content-wrapper" class="modal-content detalhes-modal">
			<ul>
				<li class="collection-header"><h5 id="tituloLista"></h5></li>
				
				<li class="item-resultado"><img src="images/icon_saude.png"> <label class="nome-categoria">Saúde</label> <span id="quantidadeSaude" class="quantidade right"></span></li>
					
				<li class="item-resultado"><img src="images/icon_educacao.png"> <label class="nome-categoria">Educação</label> <span id="quantidadeEducacao" class="quantidade right"></span></li>
						
				<li class="item-resultado"><img src="images/icon_seguranca.png"> <label class="nome-categoria">Segurança</label> <span id="quantidadeSeguranca" class="quantidade right"></span></li>
						
				<li class="item-resultado"><img src="images/icon_comodidades.png"> <label class="nome-categoria">Comodidades</label> <span id="quantidadeComodidades" class="quantidade right"></span></li>
						
				<li class="item-resultado"><img src="images/icon_lazer_cultura.png">  <label class="nome-categoria">Lazer e Cultura</label> <span id="quantidadeLazerCultura" class="quantidade right"></span></li>
						
				<li class="item-resultado"><img src="images/icon_transporte.png"> <label class="nome-categoria">Transportes</label><span id="quantidadeTransportes" class="quantidade right"></span></li>
					
				<li class="item-resultado"><img src="images/icon_ocorrencias.png"> <label class="nome-categoria">Ocorrências</label> <span id="quantidadeOcorrencias" class="quantidade right"></span></li>
						
				<li class="item-resultado"> <label class="total">Total: </label><span id="quantidadeTotal" class="quantidade right"></span></li>
			</ul>

		</div>
	</div>
	
	<div id="chartCategorias" class="modal chart-local" >
	</div>
	
	<div id="chartComparacao" class="modal chart-comparacao" >
	</div>
		

</body>

</html>

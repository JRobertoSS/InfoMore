<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<!-- Import da taglib pra uso de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/comum.js"></script>
<script type="text/javascript" src="js/meusLocais.js" charset="UTF-8"></script>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/comum.css" rel="stylesheet">

<link href="css/meusLocais.css" rel="stylesheet">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>

<title>Infomore - Meus Locais</title>
</head>
<body class="corpo">

	<%@include file="menu/navigator.jsp"%>

	<%@include file="modal/mensagem.jsp"%>

	<div id="page-content-wrapper" class="container">

		<form action="meusLocais" method="post">

			<input type="hidden" name="acao" value="processar">

			<div class="row form-content">
				<table class="tabela">
					<thead>
						<tr>

							<th class="acao"></th>

							<th class="nome">Nome</th>

							<th class="acao"></th>
							<th class="acao"></th>

						</tr>
					</thead>
					<c:forEach var="local" items="${requestScope['meusLocais']}">
						<tbody>
							<tr >
								<td class="acao"><input id="checkbox${local.id}" type="checkbox"
									name="checkComparar" value="${local.id}"> <label
									for="checkbox${local.id}"></label></td>

								<td class="nome" onclick="mostrarDescricao('${local.descricao}');">${local.nome}</td>

								<td class="acao">
									<a href="editarLocal?acao=consultar&idLocal=${local.id}">
										<img src="images/icon_pencil_edit.png" />
									</a>
								</td>
								<td class="acao">
									<a href="excluirLocal?acao=excluir&idLocal=${local.id}">
										<img src="images/icon_x_remove.png" 
										onclick="return confirm('Deseja realmente remover este local de sua lista?');"/>
									</a>
								</td>

							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="center espacamento-botoes">
					<button class="btn waves-effect waves-light top botao-comparar"
						type="submit" name="action">Comparar</button>

					<a class="btn waves-effect waves-light top botao-cancelar"
						href="navegar?acao=mapa">Voltar</a>
				</div>
			</div>
			
			<div id="modalDescricao" class="modal" >
				<div id="page-content-wrapper" class="modal-content modal-descricao">
					<p id="descricaoLocal"></p>
				</div>
			</div>


		</form>

	</div>


</body>

</html>

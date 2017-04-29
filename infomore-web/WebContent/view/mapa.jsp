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
<script type="text/javascript" src="js/mapa.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/comum.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/comum.css" rel="stylesheet">

<link href="css/mapa.css" rel="stylesheet">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>

<title>Infomore</title>
</head>
<body class="corpo">

	<%@include file="menu/navigator.jsp"%>

	<%@include file="modal/mensagem.jsp"%>

	<div id="page-content-wrapper" class="container">

		<div id="mapa" class="mapa">
			<c:set var="local" scope="request" value="${requestScope['local']}" />

			<c:choose>
				<c:when test="${local == null}">
					<script type="text/javascript">
						getLocal();
					</script>
				</c:when>
				<c:otherwise>
					<script type="text/javascript">
						converteLocal(local);
					</script>
				</c:otherwise>
			</c:choose>

		</div>



		<div class="fixed-action-btn click-to-toggle"
			style="bottom: 20px; right: 20px;">
			<a class="btn-floating btn-large pink"> <img alt="filtro"
				src="images/infomore_button.png">
			</a>

			<ul>

				<li><a id="buttonSaude" class="btn-floating red "
					onclick="filtrarCategorias('Saúde');"><i class="material-icons">local_hospital</i></a></li>

				<li><a id="buttonEducacao" class="btn-floating purple"
					onclick="filtrarCategorias('Educação');"><i
						class="material-icons">school</i></a></li>

				<li><a id="buttonSeguranca" class="btn-floating black"
					onclick="filtrarCategorias('Segurança');"><i
						class="material-icons">security</i></a></li>

				<li><a id="buttonComodidades" class="btn-floating green"
					onclick="filtrarCategorias('Comodidades');"><i
						class="material-icons">shopping_cart</i></a></li>

				<li><a id="buttonLazer" class="btn-floating yellow darken-1"
					onclick="filtrarCategorias('Lazer e Cultura');"><i
						class="material-icons">tag_faces</i></a></li>

				<li><a id="buttonTransporte" class="btn-floating blue darken-4"
					onclick="filtrarCategorias('Transportes');"><i
						class="material-icons">directions_bus</i></a></li>

				<li><a id="buttonOcorrencias" class="btn-floating orange"
					onclick="filtrarCategorias('Ocorrências');"><i
						class="large material-icons">report</i></a></li>
			</ul>
		</div>

	</div>


</body>
</html>
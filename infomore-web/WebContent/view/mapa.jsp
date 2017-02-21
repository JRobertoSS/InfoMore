<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">

<!-- Import da taglib pra uso de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript" src="js/mapa.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>

	<script type="text/javascript" src="js/angular.js"></script>

	<script type="text/javascript" src="js/app.js"></script>

	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<link href="css/mapa.css" rel="stylesheet">

	<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<title>Infomore</title>
</head>
<body>

	<nav>

		<ul id="dropdownMeuLocalAtual" class="dropdown-content">
			<li> <a class="modal-trigger" href="#modal1" >Informações</a> </li>
			<li> <a href="#!" >Inserir local</a> </li>
			<li> <a href="#!" >Reportar ocorrência</a> </li>
			<li class="divider"></li>
			<li><a href="local.html">Escolher local</a></li>
		</ul>
		
		
		<ul id="dropdownOpcoes" class="dropdown-content">
			<li> <a href="principal.html" >Mapa</a> </li>
			<li> <a href="perfil.html" >Atualizar Perfil</a> </li>
			<li> <a href="senha.html" >Atualizar Senha</a> </li>
			<li> <a href="#!" >Meus Locais</a> </li>
			<li> <a href="#!" >Relatórios</a> </li>
			<li class="divider"></li>
			<li><a href="login.html">Sair</a></li>
		</ul>
		
				
		<div class="nav-wrapper teal menuNav">
			
			<ul id="nav-mobile" id="dropdownButtonMeuLocalAtual" class="left">
				<li><a href="#!" class="dropdown-button" data-beloworigin="true" data-activates="dropdownMeuLocalAtual"><i class="material-icons">map</i></a></li>
			</ul>
			
			<ul id="nav-mobile" class="right">
				<li><a href="#" id="dropdownButtonOpcoes" class="dropdown-button" data-beloworigin="true" data-activates="dropdownOpcoes"><i class="material-icons">settings</i></a></li>
			</ul>
		
		</div>

	</nav>
		
	
	<div id="page-content-wrapper" class="container"> 

		<div id="mapa" class="mapa">
			<c:set var="local" scope="request" value="${requestScope['local']}"/>
			
			<c:choose>
				<c:when test="${local == null}">
					<script type="text/javascript">
						getLocal();
					</script>
				</c:when>
		<%--	<c:otherwise>
					<script type="text/javascript">
			   			converteLocal(local);
		 			</script>
			 	</c:otherwise> --%>
			</c:choose>
			
		</div>
		
		
		<!-- Slides -->
	
	<!-- <ul id="slideSaude" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkFarmacia"/><label for="checkFarmacia">Farmácia</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkHospital"/><label for="checkHospital">Hospital</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkPostoSaude"/><label for="checkPostoSaude">Posto de Saúde</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkClinica"/><label for="checkClinica">Clínica</label></li>
	</ul>

	<ul id="slideEducacao" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkEscola"/><label for="checkEscola">Escola</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkFaculdade"/><label for="checkFaculdade">Faculdade</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkCreche"/><label for="checkCreche">Creche</label></li>
	</ul>

	<ul id="slideSeguranca" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkPoliciMilitar"/><label for="checkPoliciMilitar">Polícia Militar</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkPoliciaCivil"/><label for="checkPoliciaCivil">Policia Civil</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkBombeiros"/><label for="checkBombeiros">Bombeiros</label></li>
	</ul>

	<ul id="slideComodidades" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkSupermercado"/><label for="checkSupermercado">Supermercado</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkPadaria"/><label for="checkPadaria">Padaria</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkRestaurante"/><label for="checkRestaurante">Restaurante</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkLoja"/><label for="checkLoja">Loja</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkPostoDeServicos"/><label for="checkPostoDeServicos">Posto de Serviços</label></li>
	</ul>

	<ul id="slideLazer" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkCinema"/><label for="checkCinema">Cinema</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkMuseu"/><label for="checkMuseu">Museu</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkTeatro"/><label for="checkTeatro">Teatro</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkBiblioteca"/><label for="checkBiblioteca">Biblioteca</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkParque"/><label for="checkParque">Parque</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkBar"/><label for="checkBar">Bar</label></li>
	</ul>

	<ul id="slideTransporte" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkOnibus"/><label for="checkOnibus">Ônibus</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkMetro"/><label for="checkMetro">Metrô</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkTaxi"/><label for="checkTaxi">Táxi</label></li>
	</ul>

	<ul id="slideOcorrencias" class="side-nav">
		<li><input type="checkbox" name="" class="filled-in" id="checkAssalto"/><label for="checkAssaltos">Assalto</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkHomicidio"/><label for="checkHomicidio">Homicídio</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkRouboDeVeiculo"/><label for="checkRouboDeVeiculo">Roubo de veículo</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkRouboDeImovel"/><label for="checkRouboDeImovel">Roubo de imóvel</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkAcidenteDeTransito"/><label for="checkAcidenteDeTransito">Acidentes de Trânsito</label></li>
		<li><input type="checkbox" name="" class="filled-in" id="checkEnchentes"/><label for="checkEnchentes">Enchente</label></li>
	</ul> -->
	
		<div class="fixed-action-btn click-to-toggle" style="bottom: 20px; right: 20px;">
			<a class="btn-floating btn-large pink">
		    	<img alt="filtro" src="images/infomore_button.png">
		    </a>

			<ul>
				
				<li><a id="buttonSaude" class="btn-floating red " onclick="filtrarCategorias('Saúde');"><i class="material-icons">local_hospital</i></a></li>

				<li><a id="buttonEducacao" class="btn-floating purple" onclick="filtrarCategorias('Educação');"><i class="material-icons">school</i></a></li>

				<li><a id="buttonSeguranca" class="btn-floating black" onclick="filtrarCategorias('Segurança');"><i class="material-icons">security</i></a></li>

				<li><a id="buttonComodidades" class="btn-floating green" onclick="filtrarCategorias('Comodidades');"><i class="material-icons">shopping_cart</i></a></li>

				<li><a id="buttonLazer" class="btn-floating yellow darken-1" onclick="filtrarCategorias('Lazer e Cultura');"><i class="material-icons">tag_faces</i></a></li>

				<li><a id="buttonTransporte" class="btn-floating blue darken-4" onclick="filtrarCategorias('Transportes');"><i class="material-icons">directions_bus</i></a></li>

				<li><a id="buttonOcorrencias" class="btn-floating orange" onclick="filtrarCategorias('Ocorrências');"><i class="large material-icons">report</i></a></li>
			</ul>
		</div>

	</div>

	



</body>
</html>
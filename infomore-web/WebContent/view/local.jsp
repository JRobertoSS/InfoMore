<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="infomore">
<head>
<meta charset="UTF-8">


<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/local.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADLLbi_ei8WPPbzyCq5_UUCN0Iy--V3Lo"></script>



<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link href="css/local.css" rel="stylesheet">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Infomore</title>
</head>
<body>

	<div class="container center-align">
		</br> 
		<a href="navegar?acao=mapa" class="btn waves-effect waves-light botao"
				id="buttonMeuLocal" value="Usar meu local atual" />
		</br> 
		
		<a href="#!" class="btn waves-effect waves-light botao"
			id="buttonEscolherLocal" data-activates="slideEscolherLocal">Escolher um local </a>
		</br> 
		</br>

		<form action="mapa?acao=escolherlocal" method="post">

			<ul id="slideEscolherLocal" class="side-nav">

				<div class="input-field  center-align conteudo-input">
					<li><select id="cbEstado">
							<option value="" disabled selected>Estado</option>
							<option value="1">São Paulo</option>
					</select></li> </br>

					<li><select id="cbCidade">
							<option value="" disabled selected>Cidade</option>
							<option value="1">Mogi das Cruzes</option>
					</select></li> </br>

					<li>
						<div class="input-field">

							<label for="inputEndereco">Endereço</label> <input type="text"
								name="" class="texto" id="inputEndereco" />
						</div>
					</li> </br>
					<li><input type="submit"
						class="btn waves-effect waves-light botao" id="buttonEnviar"
						value="Ir!" /></li>

				</div>
				
			</ul>
		</form>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
	function initialize() {
		// pegar a latitude da requisi��o
		var latitude = <%out.print(request.getParameter("latitude"));%>;
		//  pegar a longitude da requisi��o
		var longitude = <%out.print(request.getParameter("longitude"));%>;
		// inicializar um novo objeto de LatLng com os valores da latitude e longitude
		var meuLocal = new google.maps.LatLng(latitude, longitude);
		// indicar o container do mapa (div)
		var mapCanvas = document.getElementById('map');
		// criar um objeto com as op��es do mapa
		var mapOptions = {
			center : meuLocal, // centralizado no meuLocal (LatLng)
			zoom : 16, // zoom inicial (+ = pr�ximo /  - = distante)
			mapTypeId : google.maps.MapTypeId.ROADMAP
		// tipo padr�o de mapa inicial
		};
		// criar um novo objeto de mapa com o container e as op��es definidas
		var map = new google.maps.Map(mapCanvas, mapOptions);
		// criar um novo objeto de marcador 
		var marker = new google.maps.Marker({
			position : meuLocal, // posi��o no meuLocal (LatLng)
			map : map, // objeto do mapa
			title : 'Meu Local', // t�tulo do marcador
		});
		// criar um objeto de C�rculo para determinar o raio inicial
		var circle = new google.maps.Circle({
			map : map, // objeto do mapa
			radius : 300, // raio inicial (em 'm')
			center : marker.position, // centro do circulo no marcador
			strokeColor : '#1E90FF', // cor do contorno
			strokeOpacity : 0.6, // opacidade do contorno
			fillColor : '#1E90FF', // cor do preenchimento
			fillOpacity : 0.2, // opacidade do preenchimento
			editable : true
		// torna o c�rculo edit�vel
		});
		document.getElementById("raio").innerHTML = "Raio: "
				+ circle.getRadius(); // mostra o raio no conteiner raio
		document.getElementById("lat").innerHTML = "Latitude: "
				+ circle.getCenter().lat(); // mostra a latitude no conteiner lat
		document.getElementById("lng").innerHTML = "Longitude: "
				+ circle.getCenter().lng(); // mostra a longitude no conteiner lng

		// adicionar o listener do evento de mudan�a de raio
		google.maps.event.addListener(circle, "radius_changed", function() {
			document.getElementById("raio").innerHTML = "Raio: "
					+ circle.getRadius(); // mostra o raio alterado no conteiner raio
		})
		// adicionar o listener do evento de mover o c�rculo
		google.maps.event.addListener(circle, "center_changed", function() {
			// mover o marcador para o novo local do c�rculo
			marker.setPosition(circle.getCenter());
			document.getElementById("lat").innerHTML = "Latitude: "
					+ circle.getCenter().lat(); // mostra a latitude alterada no conteiner lat
			document.getElementById("lng").innerHTML = "Longitude: "
					+ circle.getCenter().lng(); // mostra a longitude alterada no conteiner lng
		})
		// criar um objeto de InfoWindow (descri��o ao clicar no marcador)
		var infoWindow = new google.maps.InfoWindow({
			content : "Este � o seu local atual!" // o que ser� mostrado ao clicar no marcador 
		})
		// adicionar o listener do evento de click no marcador e mostrar o InfoWindow
		google.maps.event.addListener(marker, 'click', function() {
			infoWindow.open(map, marker);
		})

	}
	// executar o m�todo initialize depois de carregar a p�gina
	window.onload = initialize;
</script>
</head>
<body>
	*manter essas infos em uma op��o
	<div id="map"></div>
	<div id="raio">raio</div>
	<div id="lat">lat</div>
	<div id="lng">lng</div>
	
	*Um bot�o (Filtrar) para as localidades, em que aparecem as 05 categorias: Sa�de, Educa��o, Seguran�a, Lazer/Cultura e Comodidades.
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria s�o mostrados. � poss�vel listar
	quais pontos espec�ficos de cada categoria s�o desejados (Ex. Hospitais, farm�cias e Postos, na categoria Sa�de))
	Ao clicar em um ponto, � poss�vel ver os detalhes e salvar este ponto nos "favoritos/pontos importantes" do usu�rio
	
	
	*Um bot�o (Filtrar) para as ocorr�ncias, em que aparecem as categorias em que h� ocorr�ncias apenas (Se houver apenas
	uma categoria, n�o vai ter sentido manter isso, bota direto a lista dos pontos, sem categoria). 
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria s�o mostrados. � poss�vel listar
	quais pontos espec�ficos de cada categoria s�o desejados (Ex. Acidentes, Assaltos e Homic�dios, na categoria Seguran�a))
	
	*Um bot�o (Filtrar) para as �reas de abrang�ncia, em que aparecem as categorias Energia, �gua e Telecomunica��es.
	Ao clicar nisso, aparece quais categorias possuem (ou n�o) cobertura do servi�o.
	
	*Um bot�o de informa��es sobre a �rea demarcada. Ainda n�o definimos, mas pode ser algo como, al�m das infos de latitude, longitude e raio, quantidade de pontos de cada categoria no local e coisa do tipo.
	
	 
	
</body>
</html>
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
		// pegar a latitude da requisição
		var latitude = <%out.print(request.getParameter("latitude"));%>;
		//  pegar a longitude da requisição
		var longitude = <%out.print(request.getParameter("longitude"));%>;
		// inicializar um novo objeto de LatLng com os valores da latitude e longitude
		var meuLocal = new google.maps.LatLng(latitude, longitude);
		// indicar o container do mapa (div)
		var mapCanvas = document.getElementById('map');
		// criar um objeto com as opções do mapa
		var mapOptions = {
			center : meuLocal, // centralizado no meuLocal (LatLng)
			zoom : 16, // zoom inicial (+ = próximo /  - = distante)
			mapTypeId : google.maps.MapTypeId.ROADMAP
		// tipo padrão de mapa inicial
		};
		// criar um novo objeto de mapa com o container e as opções definidas
		var map = new google.maps.Map(mapCanvas, mapOptions);
		// criar um novo objeto de marcador 
		var marker = new google.maps.Marker({
			position : meuLocal, // posição no meuLocal (LatLng)
			map : map, // objeto do mapa
			title : 'Meu Local', // título do marcador
		});
		// criar um objeto de Círculo para determinar o raio inicial
		var circle = new google.maps.Circle({
			map : map, // objeto do mapa
			radius : 300, // raio inicial (em 'm')
			center : marker.position, // centro do circulo no marcador
			strokeColor : '#1E90FF', // cor do contorno
			strokeOpacity : 0.6, // opacidade do contorno
			fillColor : '#1E90FF', // cor do preenchimento
			fillOpacity : 0.2, // opacidade do preenchimento
			editable : true
		// torna o círculo editável
		});
		document.getElementById("raio").innerHTML = "Raio: "
				+ circle.getRadius(); // mostra o raio no conteiner raio
		document.getElementById("lat").innerHTML = "Latitude: "
				+ circle.getCenter().lat(); // mostra a latitude no conteiner lat
		document.getElementById("lng").innerHTML = "Longitude: "
				+ circle.getCenter().lng(); // mostra a longitude no conteiner lng

		// adicionar o listener do evento de mudança de raio
		google.maps.event.addListener(circle, "radius_changed", function() {
			document.getElementById("raio").innerHTML = "Raio: "
					+ circle.getRadius(); // mostra o raio alterado no conteiner raio
		})
		// adicionar o listener do evento de mover o círculo
		google.maps.event.addListener(circle, "center_changed", function() {
			// mover o marcador para o novo local do círculo
			marker.setPosition(circle.getCenter());
			document.getElementById("lat").innerHTML = "Latitude: "
					+ circle.getCenter().lat(); // mostra a latitude alterada no conteiner lat
			document.getElementById("lng").innerHTML = "Longitude: "
					+ circle.getCenter().lng(); // mostra a longitude alterada no conteiner lng
		})
		// criar um objeto de InfoWindow (descrição ao clicar no marcador)
		var infoWindow = new google.maps.InfoWindow({
			content : "Este é o seu local atual!" // o que será mostrado ao clicar no marcador 
		})
		// adicionar o listener do evento de click no marcador e mostrar o InfoWindow
		google.maps.event.addListener(marker, 'click', function() {
			infoWindow.open(map, marker);
		})

	}
	// executar o método initialize depois de carregar a página
	window.onload = initialize;
</script>
</head>
<body>
	*manter essas infos em uma opção
	<div id="map"></div>
	<div id="raio">raio</div>
	<div id="lat">lat</div>
	<div id="lng">lng</div>
	
	*Um botão (Filtrar) para as localidades, em que aparecem as 05 categorias: Saúde, Educação, Segurança, Lazer/Cultura e Comodidades.
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria são mostrados. É possível listar
	quais pontos específicos de cada categoria são desejados (Ex. Hospitais, farmácias e Postos, na categoria Saúde))
	Ao clicar em um ponto, é possível ver os detalhes e salvar este ponto nos "favoritos/pontos importantes" do usuário
	
	
	*Um botão (Filtrar) para as ocorrências, em que aparecem as categorias em que há ocorrências apenas (Se houver apenas
	uma categoria, não vai ter sentido manter isso, bota direto a lista dos pontos, sem categoria). 
	Ao clicar em uma categoria, todos os pontos dentro do raio e desta categoria são mostrados. É possível listar
	quais pontos específicos de cada categoria são desejados (Ex. Acidentes, Assaltos e Homicídios, na categoria Segurança))
	
	*Um botão (Filtrar) para as áreas de abrangência, em que aparecem as categorias Energia, Água e Telecomunicações.
	Ao clicar nisso, aparece quais categorias possuem (ou não) cobertura do serviço.
	
	*Um botão de informações sobre a área demarcada. Ainda não definimos, mas pode ser algo como, além das infos de latitude, longitude e raio, quantidade de pontos de cada categoria no local e coisa do tipo.
	
	 
	
</body>
</html>
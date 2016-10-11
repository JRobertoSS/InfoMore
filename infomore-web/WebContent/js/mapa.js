function inicializaMapa(latitude, longitude) {

	// inicializar um novo objeto de LatLng com os valores da latitude e longitude
	var meuLocal = new google.maps.LatLng(latitude, longitude);
	// indicar o container do mapa (div)
	var mapCanvas = document.getElementById('mapa');
	// criar um objeto com as opções do mapa
	var mapOptions = {
		center : meuLocal, // centralizado no meuLocal (LatLng)
		zoom : 16, // zoom inicial (+ = próximo /  - = distante)
		mapTypeId : google.maps.MapTypeId.ROADMAP, // tipo padrão de mapa inicial
		disableDefaultUI: true // desabilita UI padrão do Google Maps
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
	/*document.getElementById("raio").innerHTML = "Raio: "
			+ circle.getRadius(); // mostra o raio no conteiner raio
	document.getElementById("lat").innerHTML = "Latitude: "
			+ circle.getCenter().lat(); // mostra a latitude no conteiner lat
	document.getElementById("lng").innerHTML = "Longitude: "
			+ circle.getCenter().lng(); // mostra a longitude no conteiner lng*/

	// adicionar o listener do evento de mudança de raio
	google.maps.event.addListener(circle, "radius_changed", function() {
		/*document.getElementById("raio").innerHTML = "Raio: "
				+ circle.getRadius(); // mostra o raio alterado no conteiner raio*/
	})
	// adicionar o listener do evento de mover o círculo
	google.maps.event.addListener(circle, "center_changed", function() {
		// mover o marcador para o novo local do círculo
		marker.setPosition(circle.getCenter());
		/*document.getElementById("lat").innerHTML = "Latitude: "
				+ circle.getCenter().lat(); // mostra a latitude alterada no conteiner lat
		document.getElementById("lng").innerHTML = "Longitude: "
				+ circle.getCenter().lng(); // mostra a longitude alterada no conteiner lng*/
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
// executar o método depois de carregar a página
window.onload = inicializaMapa(-23.505457, -46.187097);


$('.dropdown-button').dropdown();

$("#buttonSaude").sideNav();
$("#buttonEducacao").sideNav();
$("#buttonSeguranca").sideNav();
$("#buttonComodidades").sideNav();
$("#buttonLazer").sideNav();
$("#buttonTransporte").sideNav();
$("#buttonOcorrencias").sideNav();
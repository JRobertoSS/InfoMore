
$('.dropdown-button').dropdown();

/*$("#buttonSaude").sideNav();
$("#buttonEducacao").sideNav();
$("#buttonSeguranca").sideNav();
$("#buttonComodidades").sideNav();
$("#buttonLazer").sideNav();
$("#buttonTransporte").sideNav();
$("#buttonOcorrencias").sideNav();*/

document.mapIcones = new Map();

document.mapIcones.set('Saúde', 'images/icon_saude.png').set('Educação', 'images/icon_educacao.png').set('Segurança', 'images/icon_seguranca.png').set('Comodidades', 'images/icon_comodidades.png').set('Lazer e Cultura', 'images/icon_lazer_cultura.png').set('Transportes', 'images/icon_transporte.png').set('Ocorrências', 'images/icon_ocorrencias.png');


// varre a lista de marcadores e seta o valor do map
function setMapOnAll(map) {
	if (document.markers != undefined && document.markers != null) {
		for (var i = 0; i < document.markers.length; i++) {
			document.markers[i].setMap(map);
		}
	}
}

//Shows any markers currently in the array.
function showMarkers() {
	setMapOnAll(document.map);
}

// remove os marcadores, mas mantém o array
function clearMarkers() {
	setMapOnAll(null);
}

// exclui os marcadores no array.
function deleteMarkers() {
	clearMarkers();
	document.markers = [];
}

// função que converte o objeto em JSON para envio de ajax
function circleBoundsToJSON(bounds) {
	return JSON.stringify({
		"latNE" : bounds.getNorthEast().lat(), // latitude do ponto nordeste
		"lngNE" : bounds.getNorthEast().lng(), // longitude do ponto nordeste
		"latSW" : bounds.getSouthWest().lat(), // latitude do ponto sudoeste
		"lngSW" : bounds.getSouthWest().lng() // longitude do ponto sudoeste
	});
}

//função que cria um InfoWindow no evento de click no objetoParaOInfo, mostrando o conteudo
function criarInfoWindow(conteudo, objetoParaOInfo) {
	// criar um objeto de InfoWindow (descrição ao clicar no marcador)
	var infoWindow = new google.maps.InfoWindow({
		content : conteudo, // o que será mostrado ao clicar
		anchor : objetoParaOInfo.icon.anchor
	// no marcador
	})
	// adicionar o listener do evento de click no marcador e mostrar o
	// InfoWindow
	google.maps.event.addListener(objetoParaOInfo, 'click', function() {
		infoWindow.open(document.map, objetoParaOInfo);
	})
}

// renderiza os pontos no objeto global de circle
function renderizarPontos(pontos) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = pontos == null ? [] : (pontos instanceof Array ? pontos : [ pontos ]);

	deleteMarkers(); // remove os marcadores anteriores e reinstancia o array de marcadores
	$.each(list, function(index, ponto) {
		var localPonto = new google.maps.LatLng(ponto.latitude, ponto.longitude);
		var image = {
			url : document.mapIcones.get(ponto.categoria.nome),
			anchor : new google.maps.Point(12, 12)
		}
		var marker = new google.maps.Marker({
			position : localPonto, // posição do ponto (LatLng)
			map : document.map, // objeto do mapa
			title : ponto.descricao, // título do marcador
			icon : image
		});
		document.markers.push(marker); // adiciona o marker ao array
		criarInfoWindow(ponto.descricao, marker); // cria um infoWindow para ao clicar no marcador, mostrar a descrição
	});
}
// função que realiza uma chamada ajax para o servidor, recuperando os pontos dentro de um determinado raio ( objeto google maps circle)
function atualizarPontosRaio(circle) {
	var bounds = circle.getBounds(); // objeto de LatLngBouunds https://developers.google.com/maps/documentation/javascript/reference#LatLngBounds

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : '/infomore/atualizaPontosRaio?acao=listar',
		dataType : 'json',
		data : circleBoundsToJSON(bounds), // função para converter em JSON
		success : renderizarPontos // função para atualizar os pontos no raio
	});
}



function inicializaMapa(latitude, longitude) {

	// inicializar um novo objeto de LatLng com os valores da latitude e
	// longitude
	document.meuLocal = new google.maps.LatLng(latitude, longitude);
	// indicar o container do mapa (div)
	var mapCanvas = document.getElementById('mapa');
	// criar um objeto com as opções do mapa
	var mapOptions = {
		center : document.meuLocal, // centralizado no meuLocal (LatLng)
		zoom : 16, // zoom inicial (+ = próximo / - = distante)
		mapTypeId : google.maps.MapTypeId.ROADMAP, // tipo padrão de mapa
		// inicial
		disableDefaultUI : true
	// desabilita UI padrão do Google Maps
	};
	// criar um novo objeto de mapa com o container e as opções definidas
	document.map = new google.maps.Map(mapCanvas, mapOptions);

	// define a imagem customizada do marcador 'meu local'
	var image = {
		url : 'images/icon_person.png',
		anchor : new google.maps.Point(25, 50)
	};

	// criar um novo objeto de marcador
	var meuLocalmarker = new google.maps.Marker({
		position : document.meuLocal, // posição no meuLocal (LatLng)
		map : document.map, // objeto do mapa
		title : 'Meu Local', // título do marcador
		icon : image
	});
	// criar um objeto de Círculo para determinar o raio inicial
	var circle = new google.maps.Circle({
		map : document.map, // objeto do mapa
		radius : 300, // raio inicial (em 'm')
		center : meuLocalmarker.position, // centro do circulo no marcador
		strokeColor : '#1E90FF', // cor do contorno
		strokeOpacity : 0.6, // opacidade do contorno
		fillColor : '#1E90FF', // cor do preenchimento
		fillOpacity : 0.2, // opacidade do preenchimento
		editable : true
	// torna o círculo editável
	});

	// recuperar os pontos dentro dos limites do círculo
	atualizarPontosRaio(circle);

	/*
	 * document.getElementById("raio").innerHTML = "Raio: " +
	 * circle.getRadius(); // mostra o raio no conteiner raio
	 * document.getElementById("lat").innerHTML = "Latitude: " +
	 * circle.getCenter().lat(); // mostra a latitude no conteiner lat
	 * document.getElementById("lng").innerHTML = "Longitude: " +
	 * circle.getCenter().lng(); // mostra a longitude no conteiner lng
	 */

	// adicionar o listener do evento de mudança de raio
	google.maps.event.addListener(circle, "radius_changed", function() {

		/*
		 * Aqui irá mandar uma requisição ajax, atualizando os
		 * pontos dentro do raio
		 * 
		 */
		atualizarPontosRaio(circle);

	})
	// adicionar o listener do evento de mover o círculo
	google.maps.event.addListener(circle, "center_changed", function() {
		// mover o marcador para o novo local do círculo
		meuLocalmarker.setPosition(circle.getCenter());
		atualizarPontosRaio(circle);
	/*
	 * document.getElementById("lat").innerHTML = "Latitude: " +
	 * circle.getCenter().lat(); // mostra a latitude alterada no conteiner
	 * lat document.getElementById("lng").innerHTML = "Longitude: " +
	 * circle.getCenter().lng(); // mostra a longitude alterada no conteiner
	 * lng
	 */
	})

	// criar infoWindow do marcador 'meu local'
	criarInfoWindow("Este é seu local atual!", meuLocalmarker);

	/**
	 * Para testes - ao clicar no mapa (fora do circulo) printa no console de debug as coordenadas ( para exploração e inserts de pontos de teste)
	 */
	google.maps.event.addListener(document.map, "click", function(event) {
		var latLng = event.latLng;
		console.log("lat: " + latLng.lat() + "\nlng: " + latLng.lng());
	})

}
/**
 * Ao clicar em um botão de filtro de categoria, varre os marcadores e desativa/ativa todos estes marcadores pelo mapa
 */
function filtrarCategorias(nomeCategoria) {
	if (document.markers != undefined && document.markers != null) {
		// varre os marcadores
		for (var i = 0; i < document.markers.length; i++) {
			// compara a url do icone com o mapa de url de icones (baseado no nome da categoria)
			if (document.markers[i].icon.url == document.mapIcones.get(nomeCategoria)) {
				// se não está aparecendo no mapa, habilita o ícone
				if (document.markers[i].getMap() == null)
					document.markers[i].setMap(document.map);
				// se está no mapa, desabilita o ícone
				else
					document.markers[i].setMap(null);
			}
		}
	}
}

// método de callback que é chamado em caso de sucesso da recuperação da posição
// atual
function success(position) {
	inicializaMapa(position.coords.latitude, position.coords.longitude);
}
;

function getLocal() {
	// se o brower suportar, pega a geolocalizacao
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(success);
	} else {
		inicializaMapa(-23.507962, -46.188789); // posição da FATEC < em caso de
	// erro ao recuperar posição
	// atual
	}
}
;

// executar o método depois de carregar a página
/* window.onload = inicializaMapa(-23.505457, -46.187097); */
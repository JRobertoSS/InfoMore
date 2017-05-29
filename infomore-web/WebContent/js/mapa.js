// habilita o menu navigator.jsp
$(document).ready(function() {
	$(".dropdown-button").dropdown({
		hover : false
	});
});

/*
 * $("#buttonSaude").sideNav(); $("#buttonEducacao").sideNav();
 * $("#buttonSeguranca").sideNav(); $("#buttonComodidades").sideNav();
 * $("#buttonLazer").sideNav(); $("#buttonTransporte").sideNav();
 * $("#buttonOcorrencias").sideNav();
 */

document.mapIcones = new Map();

document.mapIcones.set('Saúde', 'images/icon_saude.png').set('Educação',
		'images/icon_educacao.png').set('Segurança',
		'images/icon_seguranca.png').set('Comodidades',
		'images/icon_comodidades.png').set('Lazer e Cultura',
		'images/icon_lazer_cultura.png').set('Transportes',
		'images/icon_transporte.png').set('Ocorrências',
		'images/icon_ocorrencias.png').set('Meu Local',
		'images/icon_person.png');

// varre a lista de marcadores e seta o valor do map
function setMapOnAll(map) {
	if (document.markers != undefined && document.markers != null) {
		for (var i = 0; i < document.markers.length; i++) {
			document.markers[i].setMap(map);
		}
	}
}

// Shows any markers currently in the array.
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

// função que cria um InfoWindow no evento de click no objetoParaOInfo,
// mostrando o conteudo
function criarInfoWindow(conteudo, marcador) {
	// criar um objeto de InfoWindow (descrição ao clicar no marcador)
	
	var infoWindow = new google.maps.InfoWindow({
		content : conteudo, // o que será mostrado ao clicar no marcador
	});
	// adicionar o listener do evento de click no marcador e mostrar o
	// InfoWindow
	google.maps.event.addListener(marcador, 'click', function() {
		infoWindow.open(document.map, marcador);
	})
}

function fechaInfoMeuLocal() {
	if (document.infoWindow !== undefined && document.infoWindow !== null)
		document.infoWindow.close();
}
function criarInfoWindowMeuLocal(marcador) {
	fechaInfoMeuLocal();

	var conteudo = "<p><b>Este é seu local atual!</b>";
	conteudo += "<p><b>Raio: </b>" + document.circle.radius.toFixed(2)
			+ " m</p>";
	conteudo += "<p><b>Latitude: </b>" + document.meuLocal.lat() + "</p>";
	conteudo += "<p><b>Longitude: </b>" + document.meuLocal.lng() + "</p>";


	
	document.infoWindow = new google.maps.InfoWindow({
		content : conteudo,

	});

	google.maps.event.addListener(marcador, 'click', function() {
		document.infoWindow.open(document.map, marcador);
	})
};

// renderiza os pontos no objeto global de circle
function renderizarPontos(pontos) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an
	// object (not an 'array of one')
	var list = pontos == null ? [] : (pontos instanceof Array ? pontos
			: [ pontos ]);

	deleteMarkers(); // remove os marcadores anteriores e reinstancia o array
	// de marcadores
	$.each(list, function(index, ponto) {
		if (ponto != undefined && ponto.categoria != undefined) {
			var localPonto = new google.maps.LatLng(ponto.latitude,
					ponto.longitude);
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
			
			// criar o conteúdo do InfoWindows, com descrição do ponto + estrelas
			var conteudo = criarConteudoInfoWindowMarcador(ponto);
			
			criarInfoWindow(conteudo, marker); // cria um infoWindow
			// para
			// ao clicar no marcador,
			// mostrar a descrição
		}
	});
}

/* cria o conteúdo utilizando a descrição do ponto
 * e o número de estrelas, para renderizar a imagem
 * de estrelas preenchidas + estrelas não preenchidas (cinzas)
 */
function criarConteudoInfoWindowMarcador(ponto){
	var conteudo = '<p>' + ponto.descricao + '</p> <p>';
	
	// ocorrëncias não utilizam avaliação
	if(ponto.ocorrencia)
		return conteudo;
	
	var preenchidas = 0;
	for( ; preenchidas < ponto.avaliacao.estrelas; preenchidas++){
		conteudo += '<img src="images/icon_star.png" class="estrela"></img>';
	}
	for(; preenchidas < 5; preenchidas++){
		conteudo += '<img src="images/icon_star_grey.png" class="estrela"></img>';
	}
	conteudo +='</p>';
	return conteudo;
	
}
// função que converte o objeto de bounds em JSON para envio de ajax
function circleBoundsToJSON(bounds) {
	return JSON.stringify({
		"latNE" : bounds.getNorthEast().lat(), // latitude do ponto nordeste
		"lngNE" : bounds.getNorthEast().lng(), // longitude do ponto nordeste
		"latSW" : bounds.getSouthWest().lat(), // latitude do ponto sudoeste
		"lngSW" : bounds.getSouthWest().lng()
	// longitude do ponto sudoeste
	});
}

// função que realiza uma chamada ajax para o servidor, recuperando os pontos
// dentro de um determinado raio ( objeto google maps circle)
function atualizarPontosRaio(circle) {
	/*
	 * var bounds = circle.getBounds(); // objeto de LatLngBouunds
	 */// https://developers.google.com/maps/documentation/javascript/reference#LatLngBounds
	var novoRaio = Math.sqrt(circle.getRadius() * circle.getRadius() / 2);
	var novoCirculo = new google.maps.Circle({
		center : circle.getCenter(),
		radius : novoRaio
	});
	var boundsNovoCirculo = novoCirculo.getBounds();
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : '/infomore/atualizaPontosRaio?acao=listar',
		dataType : 'json',
		data : circleBoundsToJSON(boundsNovoCirculo), // função para converter em JSON
		success : renderizarPontos // função para atualizar os pontos no raio com callback de sucesso
	});
}

// função que converte o objeto meuLocal em JSON para envio de ajax
function meuLocalToJSON(meuLocal) {
	return JSON.stringify({
		"nomeLocal" : meuLocal.nomeLocal,
		"raio" : meuLocal.raio,
		"latitude" : meuLocal.latitude,
		"longitude" : meuLocal.longitude,

		"limiteRaio" : {
			"pontoNE" : {
				"latitude" : meuLocal.limiteRaio.pontoNE.latitude,
				"longitude" : meuLocal.limiteRaio.pontoNE.longitude
			},
			"pontoSW" : {
				"latitude" : meuLocal.limiteRaio.pontoSW.latitude,
				"longitude" : meuLocal.limiteRaio.pontoSW.longitude
			}
		}
	});

}

// função que retorna um novo objeto de meuLocal
function getMeuLocalObject() {
	var meuLocal = {
		nomeLocal : "",
		raio : 0.0,
		latitude : 0.0,
		longitude : 0.0,
		limiteRaio : {
			pontoNE : {
				latitude : 0.0,
				longitude : 0.0,
			},
			pontoSW : {
				latitude : 0.0,
				longitude : 0.0,
			}
		}
	};
	return meuLocal;
}

// função que realiza uma chamada ajax para o servidor, salvando o local atual
// do usuário
function salvarEsteLocal(nomeLocal) {
	var meuLocal = getMeuLocalObject();

	meuLocal.nomeLocal = nomeLocal, meuLocal.raio = document.circle.radius;
	meuLocal.latitude = document.meuLocal.lat();
	meuLocal.longitude = document.meuLocal.lng();

	meuLocal.limiteRaio.pontoNE.latitude = document.circle.getBounds()
			.getNorthEast().lat();
	meuLocal.limiteRaio.pontoNE.longitude = document.circle.getBounds()
			.getNorthEast().lng();
	meuLocal.limiteRaio.pontoSW.latitude = document.circle.getBounds()
			.getSouthWest().lat();
	meuLocal.limiteRaio.pontoSW.longitude = document.circle.getBounds()
			.getSouthWest().lng();

	xhr = new XMLHttpRequest();
	var url = '/infomore/detalhesMeuLocal';
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/json");
	var data = meuLocalToJSON(meuLocal);
	xhr.send(data);

	/*
	 * $.ajax({ type : 'POST', contentType : 'application/json', url :
	 * '/infomore/detalhesMeuLocal', dataType : 'json', data :
	 * meuLocalToJSON(meuLocal), // função para converter em JSON success :
	 * renderizarPontos // função para atualizar os pontos no raio });
	 */
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
		url : document.mapIcones.get('Meu Local'),
		anchor : new google.maps.Point(25, 50)
	};

	// criar um novo objeto de marcador
	document.meuLocalmarker = new google.maps.Marker({
		position : document.meuLocal, // posição no meuLocal (LatLng)
		map : document.map, // objeto do mapa
		title : 'Meu Local', // título do marcador
		icon : image
	});
	// criar um objeto de Círculo para determinar o raio inicial
	document.circle = new google.maps.Circle({
		map : document.map, // objeto do mapa
		radius : 300, // raio inicial (em 'm')
		center : document.meuLocalmarker.position, // centro do circulo no
		// marcador
		strokeColor : '#1E90FF', // cor do contorno
		strokeOpacity : 0.6, // opacidade do contorno
		fillColor : '#1E90FF', // cor do preenchimento
		fillOpacity : 0.2, // opacidade do preenchimento
		editable : true
	// torna o círculo editável
	});

	// recuperar os pontos dentro dos limites do círculo
	atualizarPontosRaio(document.circle);
	atualizarFronteirasMapa();
	
	/*
	 * document.getElementById("raio").innerHTML = "Raio: " +
	 * circle.getRadius(); // mostra o raio no conteiner raio
	 * document.getElementById("lat").innerHTML = "Latitude: " +
	 * circle.getCenter().lat(); // mostra a latitude no conteiner lat
	 * document.getElementById("lng").innerHTML = "Longitude: " +
	 * circle.getCenter().lng(); // mostra a longitude no conteiner lng
	 */

	// adicionar o listener do evento de mudança de raio
	google.maps.event.addListener(document.circle, "radius_changed",
			function() {

				/*
				 * Aqui irá mandar uma requisição ajax, atualizando os pontos
				 * dentro do raio
				 * 
				 */
				atualizarPontosRaio(document.circle);
				criarInfoWindowMeuLocal(document.meuLocalmarker);
				atualizarFronteirasMapa();

			})
	// adicionar o listener do evento de mover o círculo
	google.maps.event.addListener(document.circle, "center_changed",
			function() {
				// mover o marcador para o novo local do círculo
				document.meuLocal = document.circle.getCenter();
				document.meuLocalmarker.setPosition(document.meuLocal);
				atualizarPontosRaio(document.circle);
				criarInfoWindowMeuLocal(document.meuLocalmarker);
				atualizarFronteirasMapa();
				/*
				 * document.getElementById("lat").innerHTML = "Latitude: " +
				 * circle.getCenter().lat(); // mostra a latitude alterada no
				 * conteiner lat document.getElementById("lng").innerHTML =
				 * "Longitude: " + circle.getCenter().lng(); // mostra a
				 * longitude alterada no conteiner lng
				 */
			})

	// adicionar o listener do evento de click no circulo
	google.maps.event.addListener(document.circle, "click",
			function() {
				// mostrar modal de raio
				$('#modalRaio').modal().modal('open');
			})

	// criar infoWindow do marcador 'meu local'
	criarInfoWindowMeuLocal(document.meuLocalmarker);

	/**
	 * Para testes - ao clicar no mapa (fora do circulo) printa no console de
	 * debug as coordenadas ( para exploração e inserts de pontos de teste)
	 */
	google.maps.event.addListener(document.map, "click", function(event) {
		var latLng = event.latLng;
		console.log("lat: " + latLng.lat() + "\nlng: " + latLng.lng());
	})

}
/**
 * Ao clicar em um botão de filtro de categoria, varre os marcadores e
 * desativa/ativa todos estes marcadores pelo mapa
 */
function filtrarCategorias(nomeCategoria) {
	if (document.markers != undefined && document.markers != null) {
		// varre os marcadores
		for (var i = 0; i < document.markers.length; i++) {
			// compara a url do icone com o mapa de url de icones (baseado no
			// nome da categoria)
			if (document.markers[i].icon.url == document.mapIcones
					.get(nomeCategoria)) {
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
};

function getLocal() {
	// se o brower suportar, pega a geolocalizacao
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(success);
	} else {
		inicializaMapa(-23.507962, -46.188789); // posição da FATEC < em caso de
		// erro ao recuperar posição
		// atual
	}
};
function fecharModalRaio(){
	$('#modalRaio').modal().modal('close');
}
function atualizarValorRaio(){
	var valorRaio = document.getElementById('inputRaioModal').value;
	if( valorRaio != null && valorRaio > 0){
		document.circle.setRadius(Number(valorRaio));
		atualizarFronteirasMapa();
		$('#modalRaio').modal().modal('close');
	}
	
}

function atualizarFronteirasMapa(){
	document.map.fitBounds(document.circle.getBounds());
}

// executar o método depois de carregar a página
/* window.onload = inicializaMapa(-23.505457, -46.187097); */

// executa para mostrar o botão nesta página
function mostraSalvarMeuLocal() {
	document.getElementById('divBotaoMeuLocal').style.visibility = "visible";
}
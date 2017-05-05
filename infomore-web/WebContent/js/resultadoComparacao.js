function atualizarDetalhesDoLocal(id) {
	alert('CHAMOOOOOO');
	var mapa = document.mapaId.get(id);
	document.getElementById('quantidadeSaude').innerHTML = mapa.get('Saúde');
	document.getElementById('quantidadeEducacao').innerHTML = mapa.get('Educação');
	document.getElementById('quantidadeSeguranca').innerHTML = mapa.get('Segurança');
	document.getElementById('quantidadeComodidades').innerHTML = mapa.get('Comodidades');
	document.getElementById('quantidadeLazerCultura').innerHTML = mapa.get('Lazer e Cultura');
	document.getElementById('quantidadeTransportes').innerHTML = mapa.get('Transportes');
	document.getElementById('quantidadeOcorrencias').innerHTML = mapa.get('Ocorrências');
	
}

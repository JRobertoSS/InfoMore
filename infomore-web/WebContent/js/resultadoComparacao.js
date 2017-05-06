
function atualizarDetalhesCategorias(id) {
	var saude = document.getElementById('quantidadeSaude');
	var educacao = document.getElementById('quantidadeEducacao');
	var seguranca = document.getElementById('quantidadeSeguranca');
	var comodidades = document.getElementById('quantidadeComodidades');
	var lazerCultura = document.getElementById('quantidadeLazerCultura');
	var transportes = document.getElementById('quantidadeTransportes');
	var ocorrencias = document.getElementById('quantidadeOcorrencias');

	if (saude != null && educacao != null && seguranca != null
			&& comodidades != null && lazerCultura != null
			&& transportes != null && ocorrencias != null) {
		saude.innerHTML = document.mapaCategoriaQuantidade[id]['Saúde'];
		educacao.innerHTML = document.mapaCategoriaQuantidade[id]['Educação'];
		seguranca.innerHTML = document.mapaCategoriaQuantidade[id]['Segurança'];
		comodidades.innerHTML = document.mapaCategoriaQuantidade[id]['Comodidades'];
		lazerCultura.innerHTML = document.mapaCategoriaQuantidade[id]['Lazer e Cultura'];
		transportes.innerHTML = document.mapaCategoriaQuantidade[id]['Transportes'];
		ocorrencias.innerHTML = document.mapaCategoriaQuantidade[id]['Ocorrências'];
		$('.modal').modal().modal('open');
	}
}

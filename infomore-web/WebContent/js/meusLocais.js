function mostrarDescricao(descricao){
	if (descricao == null || ($.trim(descricao).length === 0 ))
			descricao = 'Este local não possui uma descrição!';
	
	document.getElementById('descricaoLocal').innerHTML = descricao;
	$('#modalDescricao').modal().modal('open');
}
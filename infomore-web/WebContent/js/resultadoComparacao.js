function atualizarDetalhesCategorias(id, nome) {
	var tituloLista = document.getElementById('tituloLista');
	var saude = document.getElementById('quantidadeSaude');
	var educacao = document.getElementById('quantidadeEducacao');
	var seguranca = document.getElementById('quantidadeSeguranca');
	var comodidades = document.getElementById('quantidadeComodidades');
	var lazerCultura = document.getElementById('quantidadeLazerCultura');
	var transportes = document.getElementById('quantidadeTransportes');
	var ocorrencias = document.getElementById('quantidadeOcorrencias');
	var total = document.getElementById('quantidadeTotal');

	var valorSaude = document.mapaCategoriaQuantidade[id]['Saúde'];
	var valorEducacao = document.mapaCategoriaQuantidade[id]['Educação'];
	var valorSeguranca = document.mapaCategoriaQuantidade[id]['Segurança'];
	var valorComodidades = document.mapaCategoriaQuantidade[id]['Comodidades'];
	var valorLazerCultura = document.mapaCategoriaQuantidade[id]['Lazer e Cultura'];
	var valorTransportes = document.mapaCategoriaQuantidade[id]['Transportes'];
	var valorOcorrencias = document.mapaCategoriaQuantidade[id]['Ocorrências'];

	var valorTotal = valorSaude + valorEducacao + valorSeguranca
			+ valorComodidades + valorLazerCultura + valorTransportes
			+ valorOcorrencias;

	if (tituloLista != null && saude != null && educacao != null && 
			seguranca != null && comodidades != null && lazerCultura != null
			&& transportes != null && ocorrencias != null && total != null) {
		tituloLista.innerHTML = nome;
		saude.innerHTML = valorSaude;
		educacao.innerHTML = valorEducacao;
		seguranca.innerHTML = valorSeguranca;
		comodidades.innerHTML = valorComodidades;
		lazerCultura.innerHTML = valorLazerCultura;
		transportes.innerHTML = valorTransportes;
		ocorrencias.innerHTML = valorOcorrencias;
		total.innerHTML = valorTotal;
		$('#modalDetalhes').modal().modal('open');
	}
}

function montarTooltip(nomeCategoria, valorCategoria, totalPontos, mediaAvaliacao ){
    var htmlMedia = '<p>Avaliações Médias<p><p>'; 
    var estrelas = '<img src="images/icon_star.png" class="estrela"> </img></p>';
    var tooltip = '<p>'+ nomeCategoria + '<p>' 
    			+ '<p>' + valorCategoria +' ('+ ((valorCategoria/totalPontos) * 100).toFixed(2) + '%)</p>'
    			+ htmlMedia + '<h7>X '+mediaAvaliacao+'</h7>' +  estrelas;
    return tooltip;
}

function montarTooltipOcorrencias(valorCategoria, totalPontos){
   
    var tooltip = '<p class="paragrafoOcorrencia">Ocorrências<p>' 
    			+ '<p>' + valorCategoria +' ('+ ((valorCategoria/totalPontos) * 100).toFixed(2) + '%)</p>';
    return tooltip;
}

function atualizarGraficoCategorias(id, nomeLocal) {
	var valorSaude = document.mapaCategoriaQuantidade[id]['Saúde'];
	var valorEducacao = document.mapaCategoriaQuantidade[id]['Educação'];
	var valorSeguranca = document.mapaCategoriaQuantidade[id]['Segurança'];
	var valorComodidades = document.mapaCategoriaQuantidade[id]['Comodidades'];
	var valorLazerCultura = document.mapaCategoriaQuantidade[id]['Lazer e Cultura'];
	var valorTransportes = document.mapaCategoriaQuantidade[id]['Transportes'];
	var valorOcorrencias = document.mapaCategoriaQuantidade[id]['Ocorrências'];
	
	var totalPontos = valorSaude + valorEducacao + valorSeguranca +
		valorComodidades + valorLazerCultura + valorTransportes + valorOcorrencias;
	
	var mediaSaude = document.mapaCategoriaMedia[id]['Saúde'];
	var mediaEducacao = document.mapaCategoriaMedia[id]['Educação'];
	var mediaSeguranca = document.mapaCategoriaMedia[id]['Segurança'];
	var mediaComodidades = document.mapaCategoriaMedia[id]['Comodidades'];
	var mediaLazerCultura = document.mapaCategoriaMedia[id]['Lazer e Cultura'];
	var mediaTransportes = document.mapaCategoriaMedia[id]['Transportes'];

	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
		
		
		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Categoria');
		data.addColumn('number', 'Quantidade de pontos');
		 // A column for custom tooltip content
        data.addColumn({type: 'string', role: 'tooltip', 'p': {'html': true}});
        
 
		data.addRows([ 
						[ 'Saúde', valorSaude, montarTooltip('Saúde', valorSaude, totalPontos, mediaSaude)], 
						[ 'Educação', valorEducacao, montarTooltip('Educação', valorEducacao, totalPontos, mediaEducacao) ],
						[ 'Segurança', valorSeguranca, montarTooltip('Segurança', valorSeguranca, totalPontos, mediaSeguranca) ],
						[ 'Comodidades', valorComodidades, montarTooltip('Comodidades', valorComodidades, totalPontos, mediaComodidades) ],
						[ 'Lazer e Cultura', valorLazerCultura, montarTooltip('Lazer e Cultura', valorLazerCultura, totalPontos, mediaLazerCultura) ],
						[ 'Transportes', valorTransportes, montarTooltip('Transportes', valorTransportes, totalPontos, mediaTransportes) ],
						[ 'Ocorrências', valorOcorrencias, montarTooltipOcorrencias(valorOcorrencias, totalPontos) ] 
		              ]);

		// Set chart options
		var options = {
			title : 'Categorias em ' + nomeLocal,
			titleTextStyle: { 
				fontSize: 14,
				bold: true,
			},
			legend : {
				position : 'top',
				maxLines: 8,
				textStyle : {
					color : 'black',
					fontSize : 10,
					bold: true
				}
				
			},
			tooltip: {isHtml: true},
			
			chartArea : {
				left : 60,
				top : 150 ,
				width : '62%',
				height : '62%'
			},
			is3D : true,
			/*width : 650,
			heigth : 1000,*/
			backgroundColor : '#97d5d1',
			colors : [ '#4caf50', '#2196f3', '#757575', '#9c27b0', '#fdd835',
					'#000', '#e53935' ]
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chartCategorias'));
		$('#chartCategorias').modal().modal('open');
		chart.draw(data, options);

	}
}

function atualizarGraficoComparacao() {

	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {

		var data = new google.visualization.arrayToDataTable
		([ 
			[ 
				{
					label : 'Local',
					id : 'Local',
					type : 'string'
				}, {
					label : 'Saúde',
					id : 'Saúde',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Educação',
					id : 'Educação',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Segurança',
					id : 'Segurança',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Comodidades',
					id : 'Comodidades',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Lazer/Cultura',
					id : 'Lazer e Cultura',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Transportes',
					id : 'Transportes',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}},
				{
					label : 'Ocorrências',
					id : 'Ocorrências',
					type : 'number'
				},
				{type: 'string', role: 'tooltip', 'p': {'html': true}}
			] 
		]);

		 
		for (key in document.idLocais) {
			var valorSaude = document.mapaCategoriaQuantidade[document.idLocais[key]]['Saúde'];
			var valorEducacao = document.mapaCategoriaQuantidade[document.idLocais[key]]['Educação'];
			var valorSeguranca = document.mapaCategoriaQuantidade[document.idLocais[key]]['Segurança'];
			var valorComodidades = document.mapaCategoriaQuantidade[document.idLocais[key]]['Comodidades'];
			var valorLazerCultura = document.mapaCategoriaQuantidade[document.idLocais[key]]['Lazer e Cultura'];
			var valorTransportes = document.mapaCategoriaQuantidade[document.idLocais[key]]['Transportes'];
			var valorOcorrencias = document.mapaCategoriaQuantidade[document.idLocais[key]]['Ocorrências'];
			
			var totalPontos = valorSaude + valorEducacao + valorSeguranca +
			valorComodidades + valorLazerCultura + valorTransportes + valorOcorrencias;
		
			var mediaSaude = document.mapaCategoriaMedia[document.idLocais[key]]['Saúde'];
			var mediaEducacao = document.mapaCategoriaMedia[document.idLocais[key]]['Educação'];
			var mediaSeguranca = document.mapaCategoriaMedia[document.idLocais[key]]['Segurança'];
			var mediaComodidades = document.mapaCategoriaMedia[document.idLocais[key]]['Comodidades'];
			var mediaLazerCultura = document.mapaCategoriaMedia[document.idLocais[key]]['Lazer e Cultura'];
			var mediaTransportes = document.mapaCategoriaMedia[document.idLocais[key]]['Transportes'];
	
			
				var nomeLocal = document.locais.get(document.idLocais[key]);
			data.addRows([ [ nomeLocal, 
				valorSaude, 
				montarTooltip('Saúde', valorSaude, totalPontos, mediaSaude),
				valorEducacao,
				montarTooltip('Educação', valorEducacao, totalPontos, mediaEducacao),
				valorSeguranca,
				montarTooltip('Segurança', valorSeguranca, totalPontos, mediaSeguranca),
				valorComodidades, 
				montarTooltip('Comodidades', valorComodidades, totalPontos, mediaComodidades),
				valorLazerCultura,
				montarTooltip('Lazer e Cultura', valorLazerCultura, totalPontos, mediaLazerCultura),
				valorTransportes, 
				montarTooltip('Transportes', valorTransportes, totalPontos, mediaTransportes),
				valorOcorrencias,
				montarTooltipOcorrencias(valorOcorrencias, totalPontos)] ]);
	}

		var options = {
			title : 'Categorias nos Locais Comparados',
			titleTextStyle: { 
				fontSize: 14,
				bold: true,
			},
			/*width : 360,
			heigth : 1300,*/
			legend : {
				position : 'top',
				maxLines: 4,
				textStyle : {
					color : 'black',
					fontSize : 10,
					bold: true
				}
			},
			bar : {
				groupWidth : '60%'
			},
			isStacked : true,
			is3D : true,
			backgroundColor : '#97d5d1',
			colors : [ '#4caf50', '#2196f3', '#757575', '#9c27b0', '#fdd835',
					'#000', '#e53935' ],
			
			hAxis : {

				baselineColor : '#000',
				gridlineColor : '#000'

			},
			vAxis : {

				baselineColor : '#000',
				gridlineColor : '#000'

			},
			chartArea : {
				top : 120 ,
				width : '60%',
				height : '60%'
			},
			tooltip: {isHtml: true}
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById("chartComparacao"));
		$('#chartComparacao').modal().modal('open');
		chart.draw(data, options);
	}
}

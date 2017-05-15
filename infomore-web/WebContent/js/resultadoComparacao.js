function atualizarDetalhesCategorias(id) {
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

	if (saude != null && educacao != null && seguranca != null
			&& comodidades != null && lazerCultura != null
			&& transportes != null && ocorrencias != null && total != null) {
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

function atualizarGraficoCategorias(id, nomeLocal) {
	var valorSaude = document.mapaCategoriaQuantidade[id]['Saúde'];
	var valorEducacao = document.mapaCategoriaQuantidade[id]['Educação'];
	var valorSeguranca = document.mapaCategoriaQuantidade[id]['Segurança'];
	var valorComodidades = document.mapaCategoriaQuantidade[id]['Comodidades'];
	var valorLazerCultura = document.mapaCategoriaQuantidade[id]['Lazer e Cultura'];
	var valorTransportes = document.mapaCategoriaQuantidade[id]['Transportes'];
	var valorOcorrencias = document.mapaCategoriaQuantidade[id]['Ocorrências'];

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
		data.addRows([ [ 'Saúde', valorSaude ], [ 'Educação', valorEducacao ],
				[ 'Segurança', valorSeguranca ],
				[ 'Comodidades', valorComodidades ],
				[ 'Lazer e Cultura', valorLazerCultura ],
				[ 'Transportes', valorTransportes ],
				[ 'Ocorrências', valorOcorrencias ] ]);

		// Set chart options
		var options = {
			title : 'Distribuição das Categorias em ' + nomeLocal,
			titleTextStyle: { 
				fontSize: 14,
				bold: true,
			},
			legend : {
				position : 'right',
				textStyle : {
					color : 'black',
					fontSize : 11
				}
			},
			chartArea : {
				left : 10,
				top : 50,
				width : '50%',
				height : '80%'
			},
			is3D : true,
			width : 650,
			heigth : 1000,
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

	for (key in document.idLocais) {
		console.log(document.locais.get(document.idLocais[key]));
	}

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

		var data = new google.visualization.arrayToDataTable([ [ {
			label : 'Local',
			id : 'Local',
			type : 'string'
		}, {
			label : 'Saúde',
			id : 'Saúde',
			type : 'number'
		}, {
			label : 'Educação',
			id : 'Educação',
			type : 'number'
		}, {
			label : 'Segurança',
			id : 'Segurança',
			type : 'number'
		}, {
			label : 'Comodidades',
			id : 'Comodidades',
			type : 'number'
		}, {
			label : 'Lazer e Cultura',
			id : 'Lazer e Cultura',
			type : 'number'
		}, {
			label : 'Transportes',
			id : 'Transportes',
			type : 'number'
		}, {
			label : 'Ocorrências',
			id : 'Ocorrências',
			type : 'number'
		} ] ]);

		for (key in document.idLocais) {
			var valorSaude = document.mapaCategoriaQuantidade[document.idLocais[key]]['Saúde'];
			var valorEducacao = document.mapaCategoriaQuantidade[document.idLocais[key]]['Educação'];
			var valorSeguranca = document.mapaCategoriaQuantidade[document.idLocais[key]]['Segurança'];
			var valorComodidades = document.mapaCategoriaQuantidade[document.idLocais[key]]['Comodidades'];
			var valorLazerCultura = document.mapaCategoriaQuantidade[document.idLocais[key]]['Lazer e Cultura'];
			var valorTransportes = document.mapaCategoriaQuantidade[document.idLocais[key]]['Transportes'];
			var valorOcorrencias = document.mapaCategoriaQuantidade[document.idLocais[key]]['Ocorrências'];

			var nomeLocal = document.locais.get(document.idLocais[key]);
			data.addRows([ [ nomeLocal, valorSaude, valorEducacao,
					valorSeguranca, valorComodidades, valorLazerCultura,
					valorTransportes, valorOcorrencias ] ]);
		}

		var options = {
			title : 'Distribuição das Categorias nos Locais',
			titleTextStyle: { 
				fontSize: 14,
				bold: true,
			},
			width : 360,
			heigth : 1300,
			legend : {
				top: 20,
				position : 'top',
				maxLines : 12,
				textStyle : {
					color : 'black',
					fontSize : 11
				}
			},
			bar : {
				groupWidth : '50%'
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

			}
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById("chartComparacao"));
		$('#chartComparacao').modal().modal('open');
		chart.draw(data, options);
	}
}

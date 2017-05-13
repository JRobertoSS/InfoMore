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

	var chart = new CanvasJS.Chart("chartCategorias", {
		height : 450,
		width : 340,
		backgroundColor : "#97d5d1",
		title : {
			text : "Distribuição das Categorias em " + nomeLocal,
			fontSize : 18
		},
		animationEnabled : true,
		legend : {
			verticalAlign : "bottom",
			horizontalAlign : "center",
			fontSize : 14,
			fontFamily : "Helvetica",
			maxWidth : 300,
			itemWidth : 150
		},
		theme : "theme1",
		data : [ {
			type : "pie",
			indexLabelFontColor : "black",
			indexLabelFontWeight : "bold",
			indexLabelMaxWidth : 50,
			indexLabelFontSize : 15,
			indexLabelLineThickness : 2,
			startAngle : -20,
			showInLegend : true,
			toolTipContent : "{legendText} {y}%",
			dataPoints : [ {
				y : valorSaude,
				legendText : "Saúde",
				label : "Saúde",
				color : "#4caf50",
				indexLabel : "{y}%"
			}, {
				y : valorEducacao,
				legendText : "Educação",
				label : "Educação",
				color : "#2196f3",
				indexLabel : "{y}%"
			}, {
				y : valorSeguranca,
				legendText : "Segurança",
				label : "Segurança",
				color : "#757575",
				indexLabel : "{y}%"
			}, {
				y : valorComodidades,
				legendText : "Comodidades",
				label : "Comodidades",
				color : "#9c27b0",
				indexLabel : "{y}%"
			}, {
				y : valorLazerCultura,
				legendText : "Lazer e Cultura",
				label : "Lazer e Cultura",
				color : "#fdd835",
				indexLabel : "{y}%"
			}, {
				y : valorTransportes,
				legendText : "Transportes",
				label : "Transportes",
				color : "#000",
				indexLabel : "{y}%"
			}, {
				y : valorOcorrencias,
				legendText : "Ocorrências",
				label : "Ocorrências",
				color : "#e53935",
				indexLabel : "{y}%"
			}, ]
		} ]
	});
	chart.render();

	$('#chartCategorias').modal().modal('open');
}

 
 
function atualizarGraficoComparacao() {

	var chart = new CanvasJS.Chart("chartComparacao", {
		height : 450,
		width : 340,
		backgroundColor : "#97d5d1",
		title : {
			text : "Distribuição das Categorias nos Locais Analisados",
			fontSize : 18
		},

		data : [ {
			type : "stackedBar",
			dataPoints : [ {
				x : new Date(2012, 01, 1),
				y : 71
			}, {
				x : new Date(2012, 02, 1),
				y : 55
			}, {
				x : new Date(2012, 03, 1),
				y : 50
			}, {
				x : new Date(2012, 04, 1),
				y : 65
			}, {
				x : new Date(2012, 05, 1),
				y : 95
			}

			]
		}, {
			type : "stackedBar",
			dataPoints : [ {
				x : new Date(2012, 01, 1),
				y : 71
			}, {
				x : new Date(2012, 02, 1),
				y : 55
			}, {
				x : new Date(2012, 03, 1),
				y : 50
			}, {
				x : new Date(2012, 04, 1),
				y : 65
			}, {
				x : new Date(2012, 05, 1),
				y : 95
			}

			]
		}, {
			type : "stackedBar",
			dataPoints : [ {
				x : new Date(2012, 01, 1),
				y : 71
			}, {
				x : new Date(2012, 02, 1),
				y : 55
			}, {
				x : new Date(2012, 03, 1),
				y : 50
			}, {
				x : new Date(2012, 04, 1),
				y : 65
			}, {
				x : new Date(2012, 05, 1),
				y : 95
			}

			]
		},

		{
			type : "stackedBar",
			dataPoints : [ {
				x : new Date(2012, 01, 1),
				y : 61
			}, {
				x : new Date(2012, 02, 1),
				y : 75
			}, {
				x : new Date(2012, 03, 1),
				y : 80
			}, {
				x : new Date(2012, 04, 1),
				y : 85
			}, {
				x : new Date(2012, 05, 1),
				y : 105
			}

			]
		}, {
			type : "stackedBar",
			dataPoints : [ {
				x : new Date(2012, 01, 1),
				y : 20
			}, {
				x : new Date(2012, 02, 1),
				y : 35
			}, {
				x : new Date(2012, 03, 1),
				y : 30
			}, {
				x : new Date(2012, 04, 1),
				y : 45
			}, {
				x : new Date(2012, 05, 1),
				y : 25
			}

			]
		}

		]
	});

	chart.render();

	$('#chartComparacao').modal().modal('open');

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
			legend: {position: 'bottom', textStyle: {color: 'black', fontSize: 12}},
			is3D : true,
			width : 340,
			heigth: 500,
			backgroundColor : '#97d5d1',
			colors: ['#4caf50', '#2196f3', '#757575', '#9c27b0', '#fdd835', '#000', '#e53935']
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chartCategorias'));
		chart.draw(data, options);
		$('#chartCategorias').modal().modal('open');
	}
}
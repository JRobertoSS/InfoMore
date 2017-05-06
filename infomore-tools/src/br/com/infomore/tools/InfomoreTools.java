package br.com.infomore.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.infomore.core.IFachada;
import br.com.infomore.core.impl.controle.Fachada;
import br.com.infomore.core.impl.dao.PontoDAO;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Ponto;


/**
 * Classe para gerar pontos aleat�rios, com Categoria e Descri��o, e dentro de um 
 * limite pr� estabelecido
 * @author Jos�Roberto
 *
 */
public class InfomoreTools {
	
	private static IFachada fachada = new Fachada();
	private static List<Categoria> categorias = new ArrayList<>();
	private static final Map<String, List<String>> mapaCategoriaDescricoes = new HashMap<>();

	private static final Ponto pontoMinimoMogi = new Ponto(); // lat: -23.57972091130017 | lng: -46.22428894042969
	private static final Ponto pontoMaximoMogi = new Ponto(); // lat: -23.487179247052328 | lng: -46.142578125
	
	private static final Double latitudeMinima = -23.57972091130017;
	private static final Double latitudeMaxima = -23.487179247052328;
	private static final Double longitudeMinima = -46.22428894042969;
	private static final Double longitudeMaxima = -46.142578125;
	
	
	private static final Random random = new Random();
	private static final Integer seedMaxCategoria = 7; // seed das categorias, exclu�ndo a �ltima (Meu Local)

	public static void main(String[] args) {
		
		
		// consultar todas as categorias
		consultarCategorias();
		// criar lista de descri��es de locais, e associar com as categorias
		criarListaDescricoes();
		// definir limites de pontos m�ximo e m�nimo
		definirLimitesPontos();
		/*
		 * la�o de repeti��o para criar os pontos:
		 * 		- gerar uma latitude, baseado na diferen�a de m�xima-m�nima + valor da m�nima  
		 * 		- gerar uma longitude, baseado na diferen�a de m�xima-m�nima + valor da m�nima 
		 * 		- gerar uma categoria, baseado no seed e na lista de categorias
		 * 		- preencher uma descri��o aleat�ria, baseado na categoria gerada + mapa + lista de descri��es ( sendo o tamanho da lista o seed)
		 * 		- criar o objeto de ponto e associar os dados gerados, al�m de marcar como certeza e, se for uma ocorr�ncia, sinalizar a flag
		 * 		- salvar este ponto
		 */
		int pontosParaGerar = 2000; // quantidade depontos a serem gerados
		int i;
		for(i = 0; i < pontosParaGerar; i++){
			
			Double latitude = getLatitudeRandom();
			Double longitude = getLongitudeRandom();
			
			int indiceCategoria =  random.nextInt(seedMaxCategoria);
			Categoria categoria = categorias.get(indiceCategoria);
			
			List<String> listaDescricoes = mapaCategoriaDescricoes.get(categoria.getNome());
			int indiceDescricao = random.nextInt( listaDescricoes.size() );
			String descricao = listaDescricoes.get(indiceDescricao);
			
			Ponto pontoGerado = new Ponto();
			pontoGerado.setLatitude(latitude);
			pontoGerado.setLongitude(longitude);
			pontoGerado.setCategoria(categoria);
			pontoGerado.setDescricao(descricao);
			pontoGerado.setOcorrencia( categoria.getDescricao().equals(Categoria.OCORRENCIAS) ? true : false);
			pontoGerado.setCerteza(1.0);
			/**
			 * Persistir o ponto gerado
			 */
			fachada.salvar(pontoGerado);
		}
	}



	private static void printPonto(Ponto ponto) {
		System.out.println("");
		System.out.println(ponto.getDescricao() + " | "+ ponto.getCategoria().getNome());
		System.out.println("Lat - " + ponto.getLatitude() + " | Lng - "+ ponto.getLongitude());
		System.out.println("");
		
	}



	/**
	 * Compara a latitude e longitude informados, para ver se foram
	 * geradas dentro do limite m�ximo e m�nimo estabelecidos
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	private static boolean dentroDoRange(Double latitude, Double longitude) {
		return latitude >= latitudeMinima && latitude <= latitudeMaxima &&
				longitude >= longitudeMinima && longitude <= longitudeMaxima;
	}




	private static double getLongitudeRandom() {
		return pontoMinimoMogi.getLongitude() + ( random.nextDouble() * ( pontoMaximoMogi.getLongitude() - pontoMinimoMogi.getLongitude() ) );
	}


	private static double getLatitudeRandom() {
		return pontoMinimoMogi.getLatitude() + ( random.nextDouble() * ( pontoMaximoMogi.getLatitude() - pontoMinimoMogi.getLatitude() ) );
	}


	private static void definirLimitesPontos() {
		// TODO Auto-generated method stub
		pontoMinimoMogi.setLatitude(latitudeMinima);
		pontoMinimoMogi.setLongitude(longitudeMinima);
		
		pontoMaximoMogi.setLatitude(latitudeMaxima);
		pontoMaximoMogi.setLongitude(longitudeMaxima);
	}


	private static void consultarCategorias() {
		List<EntidadeDominio> entidades = fachada.listar(new Categoria()).getEntidades();
		
		for(EntidadeDominio ed : entidades){
			Categoria cat = (Categoria) ed;
			categorias.add(cat);
		}
	}
	
	private static void criarListaDescricoes() {
		List<String> listaSaude = Arrays.asList("Hospital", "Hospital Maternidade", "Farm�cia", "Posto de Sa�de", "Cl�nica Odontologia", 
				"Cl�nica Geral", "Cl�nica Cir�rgica", "Cl�nica Pediatria", "Cl�nica Dermatologia", "Cl�nica Otorrinolaringologia",
				"Cl�nica Oftalmologia", "Cl�nica Fisioterapia", "Cl�nica Veterin�ria");
		
		List<String> listaEducacao = Arrays.asList("Ber��rio", "Maternal", "Pr� Escola", "Escola Ensino Fundamental", "Escola Ensino M�dio",
				"Escola Ensino Especial", "Universidade", "Faculdade", "Escola T�cnica", "Faculdade T�cnica", "Curso", "Escola de M�sica", 
				"Escola de Esportes");
		
		List<String> listaSeguranca = Arrays.asList("Pol�cia Militar", "Pol�cia Civil", "Bombeiros", "Pol�cia das For�as Armadas", "Quartel Militar",
				"Seguran�a Particular", "Pol�cia Federal", "Pol�cia Rodovi�ria Federal", "Pol�cia Ferrovi�ria Federal", "Guarda Portu�ria",
				"Guarda Municipal", "Pol�cia Cient�fica", "For�a Nacional de Seguran�a P�blica", "Pol�cia Legislativa Federal");
		
		List<String> listaComodidades = Arrays.asList("Venda", "Bazar", "Mercado", "Supermercado", "Hipermercado", "Atacado", "Feira",
				"Shopping Center", "Galeria", "Padaria", "Restaurante", "Posto de Gasolina", "Loja de conveni�ncia", "Churrascaria", 
				"Armaz�m", "Oficina Mec�nica");
		
		List<String> listaLazerCultura = Arrays.asList("Parque Municipal", "Teatro", "Cinema", "Bar", "Casa Noturna", "Biblioteca", "Museu", "Parque de Divers�es",
				"Parque Estadual", "Casa de Shows");
		
		List<String> listaTransportes = Arrays.asList("Ponto de T�xi", "Ponto de �nibus", "Metr�", "Aluguel de Carros", "Aeroporto");
		
		List<String> listaOcorrencias = Arrays.asList("Acidente de Tr�nsito", "Assalto", "Homic�dio", "Agress�o", "Enchente", "Desabamento", 
				"Furto", "Latroc�nio", "Assalto � M�o Armada", "Atropelamento");
		
		mapaCategoriaDescricoes.put(Categoria.COMODIDADES, listaComodidades);
		mapaCategoriaDescricoes.put(Categoria.EDUCACAO, listaEducacao);
		mapaCategoriaDescricoes.put(Categoria.LAZER_CULTURA, listaLazerCultura);
		mapaCategoriaDescricoes.put(Categoria.OCORRENCIAS, listaOcorrencias);
		mapaCategoriaDescricoes.put(Categoria.SAUDE, listaSaude);
		mapaCategoriaDescricoes.put(Categoria.SEGURANCA, listaSeguranca);
		mapaCategoriaDescricoes.put(Categoria.TRANSPORTES, listaTransportes);
		
	}

}

package br.com.infomore.controle.web.view;

import java.util.HashMap;
import java.util.Map;

import br.com.infomore.dominio.Categoria;

/**
 * Classe para auxiliar com a construção da view respectiva, contendo nomes,
 * ids, icones
 * 
 * @author José Roberto
 *
 */
public class ClassificacaoView {
    private Categoria categoria; // categoria com nome e descrição
    private String nomeId; // para utilizar nos atributos name e id do elemento html
    private String nomeIcone; // o nome do icone do material-icon

    public static Map<String, String> mapaNomeId;
    public static Map<String, String> mapaIcone;

    public final static String INPUT_SAUDE = "rangeSaude";
    public final static String INPUT_EDUCACAO = "rangeEducacao";
    public final static String INPUT_SEGURANCA = "rangeSeguranca";
    public final static String INPUT_COMODIDADES = "rangeComodidades";
    public final static String INPUT_LAZER = "rangeLazer";
    public final static String INPUT_TRANSPORTE = "rangeTransporte";
    public final static String INPUT_OCORRENCIAS = "rangeOcorrencias";

    public static final String ICONE_SAUDE = "local_hospital";
    public static final String ICONE_EDUCACAO = "school";
    public static final String ICONE_SEGURANCA = "security";
    public static final String ICONE_COMODIDADES = "shopping_cart";
    public static final String ICONE_LAZER = "tag_faces";
    public static final String ICONE_TRANSPORTE = "directions_bus";
    public static final String ICONE_OCORRENCIAS = "report";

    public ClassificacaoView() {
	mapaNomeId = new HashMap<>();
	mapaNomeId.put(Categoria.SAUDE, INPUT_SAUDE);
	mapaNomeId.put(Categoria.EDUCACAO, INPUT_EDUCACAO);
	mapaNomeId.put(Categoria.SEGURANCA, INPUT_SEGURANCA);
	mapaNomeId.put(Categoria.COMODIDADES, INPUT_COMODIDADES);
	mapaNomeId.put(Categoria.LAZER_CULTURA, INPUT_LAZER);
	mapaNomeId.put(Categoria.TRANSPORTES, INPUT_TRANSPORTE);
	mapaNomeId.put(Categoria.OCORRENCIAS, INPUT_OCORRENCIAS);

	mapaIcone = new HashMap<>();
	mapaIcone.put(Categoria.SAUDE, ICONE_SAUDE);
	mapaIcone.put(Categoria.EDUCACAO, ICONE_EDUCACAO);
	mapaIcone.put(Categoria.SEGURANCA, ICONE_SEGURANCA);
	mapaIcone.put(Categoria.COMODIDADES, ICONE_COMODIDADES);
	mapaIcone.put(Categoria.LAZER_CULTURA, ICONE_LAZER);
	mapaIcone.put(Categoria.TRANSPORTES, ICONE_TRANSPORTE);
	mapaIcone.put(Categoria.OCORRENCIAS, ICONE_TRANSPORTE);
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public String getNomeId() {
	return nomeId;
    }

    public void setNomeId(String nomeId) {
	this.nomeId = nomeId;
    }

    public String getNomeIcone() {
	return nomeIcone;
    }

    public void setNomeIcone(String nomeIcone) {
	this.nomeIcone = nomeIcone;
    }

}

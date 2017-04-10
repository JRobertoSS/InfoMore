package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria extends EntidadeDominio {
    public static final String SAUDE = "Saúde";
    public static final String EDUCACAO = "Educação";
    public static final String SEGURANCA = "Segurança";
    public static final String COMODIDADES = "Comodidades";
    public static final String LAZER_CULTURA = "Lazer e Cultura";
    public static final String TRANSPORTES = "Transportes";
    public static final String OCORRENCIAS = "Ocorrências";
    public static final String MEU_LOCAL = "Meu Local";

    public Categoria() {
    }

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    /*
     * Isso dá problema de loop infinito no JSON....
     * 
     * @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
     * 
     * @Cascade(CascadeType.ALL) private List<Categoria> categoria;
     */

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    /*
     * public List<Categoria> getCategoria() { return categoria; }
     * 
     * public void setCategoria(List<Categoria> categoria) { this.categoria =
     * categoria; }
     */
}

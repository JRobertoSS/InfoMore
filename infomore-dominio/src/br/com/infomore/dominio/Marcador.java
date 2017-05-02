package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Marcador extends EntidadeDominio {

    public Marcador() {
    }

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ocorrencia")
    private boolean ocorrencia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Categoria categoria; 

    @OneToMany(mappedBy = "marcador", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes;

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public boolean isOcorrencia() {
	return ocorrencia;
    }

    public void setOcorrencia(boolean ocorrencia) {
	this.ocorrencia = ocorrencia;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public List<Avaliacao> getAvaliacoes() {
	return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
	this.avaliacoes = avaliacoes;
    }

}

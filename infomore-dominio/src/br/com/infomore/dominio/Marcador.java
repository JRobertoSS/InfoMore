package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class Marcador extends EntidadeDominio{

	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;

	@Column(name="descricao")
	private String descricao;

	@Column(name="ocorrencia")
	private boolean ocorrencia;

	@ManyToOne
	private TipoMarcador tipoMarcador;
	
    @OneToMany
	private List<Avaliacao> avaliacoes;
    
    @OneToMany
	private List<Confirmacao> confirmacoes;

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

	public TipoMarcador getTipoMarcador() {
		return tipoMarcador;
	}

	public void setTipoMarcador(TipoMarcador tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Confirmacao> getConfirmacoes() {
		return confirmacoes;
	}

	public void setConfirmacoes(List<Confirmacao> confirmacoes) {
		this.confirmacoes = confirmacoes;
	}

    
}

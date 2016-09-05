package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tipos_usuario")
public class TipoUsuario extends EntidadeDominio{

	public TipoUsuario() {
	}
	
	@Column(name="tipo")
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}

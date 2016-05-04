package br.com.infomore.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tipos_usuario")
public class TipoUsuario extends EntidadeDominio{

	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}

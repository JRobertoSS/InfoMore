package br.com.infomore.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="regioes")
public class Regiao extends Marcador {

	private double raio;

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	
}

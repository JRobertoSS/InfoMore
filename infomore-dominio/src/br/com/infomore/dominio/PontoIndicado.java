package br.com.infomore.dominio;

public class PontoIndicado extends PontoDeUsuario {
	private boolean certeza;
	
	public boolean isCerteza() {
		return certeza;
	}

	public void setCerteza(boolean certeza) {
		this.certeza = certeza;
	}
}

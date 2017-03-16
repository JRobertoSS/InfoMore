package br.com.infomore.dominio;

public class SenhaUsuario extends EntidadeDominio {

    private boolean atualizacaoSenha;
    private String senhaAtual;
    private String senhaNova;
    private String confirmaSenhaNova;

    public boolean isAtualizacaoSenha() {
	return atualizacaoSenha;
    }

    public void setAtualizacaoSenha(boolean atualizacaoSenha) {
	this.atualizacaoSenha = atualizacaoSenha;
    }

    public String getSenhaAtual() {
	return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
	this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
	return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
	this.senhaNova = senhaNova;
    }

    public String getConfirmaSenhaNova() {
	return confirmaSenhaNova;
    }

    public void setConfirmaSenhaNova(String confirmaSenhaNova) {
	this.confirmaSenhaNova = confirmaSenhaNova;
    }

}

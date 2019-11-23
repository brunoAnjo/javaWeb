package br.com.alura.gerenciador.model;

public class LoginModelo {

	private String nome;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean ehIgual(String loginParametro, String senhaParametro) {
		if(!this.nome.equals(loginParametro)) {
			return false;
		}
		if(!this.senha.equals(senhaParametro)) {
			return false;
		}
		
		return true;
	}
	
}

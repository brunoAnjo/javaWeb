package br.com.alura.gerenciador.model;

public class Login {

	private String nome = "brunoAnjo";
	private String senha = "123";
	
	public boolean testarLogin(String nome2, String senha2) {
		if(this.nome.equals(nome2) && this.senha.equals(senha2)) {
			return true;
		}
		return false;
	}
	
	
}

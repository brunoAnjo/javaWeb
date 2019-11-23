package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.LoginModelo;

public class Login implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginParametro = request.getParameter("login");
		String senhaParametro = request.getParameter("senha");
		
		Banco banco = new Banco(); 
		LoginModelo login = banco.usuarioExiste(loginParametro, senhaParametro);
		if(login != null) {
			System.out.println("Usuario Existente");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", login);
			return "redirect:entrada?acao=ListaEmpresa";
		}else {
			System.out.println("Usuario nao existe " + loginParametro + " " + senhaParametro);
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}

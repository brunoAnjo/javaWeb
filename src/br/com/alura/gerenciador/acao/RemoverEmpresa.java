package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoverEmpresa {

	public void removerEmpresa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idParametro = request.getParameter("id");
    	Integer id = Integer.valueOf(idParametro);
    	
    	Banco banco = new Banco();
    	banco.removerEmpresa(id);
    	
    	System.out.println(id);
    	
    	response.sendRedirect("entrada?acao=ListaEmpresa");
	}

}

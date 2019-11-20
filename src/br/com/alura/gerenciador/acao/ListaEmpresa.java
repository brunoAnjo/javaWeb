package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executando metodo");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getListaEmpresas();
		
		request.setAttribute("empresas", lista);
		
		return "forwar:/listaEmpresa.jsp";
	}
	
//	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		Banco banco = new Banco();
//		List<Empresa> lista = banco.getListaEmpresas();
//		
//		
//		request.setAttribute("empresas", lista);
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa.jsp");
//		rd.forward(request, response);
//		
//		
//	}

}

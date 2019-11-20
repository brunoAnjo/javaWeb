package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostrarEmpresa implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		Empresa empresa = (Empresa)banco.buscarEmpresaId(id);
		
		//System.out.println(empresa.getNome());
		request.setAttribute("empresa", empresa);
		
		return "forwar:formAlteraEmpresa.jsp";
		
	}
	
	

}

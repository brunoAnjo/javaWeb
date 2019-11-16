package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class NovaEmpresa {

	public void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("Cadastrando nova Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaParam = request.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberturaParam);
		} catch (ParseException e) {
			throw new ServletException(e.getMessage());
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		request.setAttribute("empresaNova", empresa.getNome());
		
		response.sendRedirect("entrada?acao=ListaEmpresa");
		
	}

}

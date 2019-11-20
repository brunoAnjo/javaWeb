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

public class AlterarEmpresa implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "rederect:entrada?acao=ListaEmpresa";
	}

}

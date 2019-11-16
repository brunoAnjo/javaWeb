package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlterarEmpresa;
import br.com.alura.gerenciador.acao.ListarEmpresas;
import br.com.alura.gerenciador.acao.MostrarEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoverEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroAcao = request.getParameter("acao");
		
		if(parametroAcao.equals("ListaEmpresa")){
			System.out.println("Listando empresa");
			
			ListarEmpresas acao = new ListarEmpresas();
			acao.executa(request, response);
			
		}
		
		else if(parametroAcao.equals("RemovaEmpresa")){
			System.out.println("removendo empresa");
			
			RemoverEmpresa acaoRemover = new RemoverEmpresa();
			acaoRemover.removerEmpresa(request, response);
			
		}
		
		else if(parametroAcao.equals("MostrarEmpresa")){
			System.out.println("mostrando empresa");
			
			MostrarEmpresa acaoMostrar = new MostrarEmpresa();
			acaoMostrar.mostrarEmpresa(request, response);
		}
		
		else if(parametroAcao.equals("AlterarEmpresa")){
			System.out.println("alterando empresa");
			
			AlterarEmpresa acaoAlterar = new AlterarEmpresa();
			acaoAlterar.alterarEmpresa(request, response);
		}
		
		else if(parametroAcao.equals("NovaEmpresa")){
			System.out.println("nova empresa");
			
			NovaEmpresa acaoNova = new NovaEmpresa();
			acaoNova.novaEmpresa(request, response);
		}
	}
	

}

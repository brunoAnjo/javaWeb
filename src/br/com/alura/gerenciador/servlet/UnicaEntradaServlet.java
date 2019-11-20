package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlterarEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresa;
import br.com.alura.gerenciador.acao.MostrarEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoverEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroAcao = request.getParameter("acao");
		
		String nome = null;
		
		if(parametroAcao.equals("ListaEmpresa")){
			System.out.println("Listando empresa");
			ListaEmpresa acao = new ListaEmpresa();
			nome = acao.executa(request, response);
		}
		
		else if(parametroAcao.equals("RemovaEmpresa")){
			System.out.println("removendo empresa");
			RemoverEmpresa acaoRemover = new RemoverEmpresa();
			nome = acaoRemover.removerEmpresa(request, response);
			
		}
		
		else if(parametroAcao.equals("MostrarEmpresa")){
			System.out.println("mostrando empresa");
			MostrarEmpresa acaoMostrar = new MostrarEmpresa();
			nome = acaoMostrar.mostrarEmpresa(request, response);
		}
		
		else if(parametroAcao.equals("AlterarEmpresa")){
			System.out.println("alterando empresa");
			
			AlterarEmpresa acaoAlterar = new AlterarEmpresa();
			nome = acaoAlterar.alterarEmpresa(request, response);
		}
		
		else if(parametroAcao.equals("NovaEmpresa")){
			System.out.println("nova empresa");
			NovaEmpresa acaoNova = new NovaEmpresa();
			nome = acaoNova.novaEmpresa(request, response);
		}
		
		String[] redirecionamento = nome.split(":");
		
		if(redirecionamento[0].equals("forwar")){
			RequestDispatcher rd = request.getRequestDispatcher(redirecionamento[1]);
			rd.forward(request, response);
		}else{
			System.out.println("Tentando redirecionar " + redirecionamento[1]);
			response.sendRedirect(redirecionamento[1]);
		}
		
	}
	

}

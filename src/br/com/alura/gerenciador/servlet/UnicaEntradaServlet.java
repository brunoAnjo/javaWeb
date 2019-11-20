package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
		String fullNameClasse = "br.com.alura.gerenciador.acao." + parametroAcao;

		String nomeParaoRedirecionamento = null;

		try {
			Class classe;
			classe = Class.forName(fullNameClasse);
			Acao acao = (Acao) classe.newInstance();
			nomeParaoRedirecionamento = acao.executar(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] redirecionamento = nomeParaoRedirecionamento.split(":");

		if (redirecionamento[0].equals("forwar")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + redirecionamento[1]);
			rd.forward(request, response);
		} else {
			System.out.println("Tentando redirecionar " + redirecionamento[1]);
			response.sendRedirect(redirecionamento[1]);
		}

	}

}

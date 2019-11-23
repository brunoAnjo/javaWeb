package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter{


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest requesteServlet = (HttpServletRequest) request;
		HttpServletResponse responseServlet = (HttpServletResponse) response;
		
		String parametroAcao = requesteServlet.getParameter("acao");
		
		String fullNameClasse = "br.com.alura.gerenciador.acao." + parametroAcao;

		String nomeParaoRedirecionamento = null;

		try {
			Class classe = Class.forName(fullNameClasse);
			Acao acao = (Acao) classe.newInstance();
			nomeParaoRedirecionamento = acao.executar(requesteServlet, responseServlet);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] redirecionamento = nomeParaoRedirecionamento.split(":");

		if (redirecionamento[0].equals("forwar")) {
			RequestDispatcher rd = requesteServlet.getRequestDispatcher("WEB-INF/view/" + redirecionamento[1]);
			rd.forward(requesteServlet, responseServlet);
		} else {
			System.out.println("Tentando redirecionar: " + redirecionamento[1]);
			responseServlet.sendRedirect(redirecionamento[1]);
		}

		
		//chain.doFilter(request, response);
	}
}

package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/entrada")
public class Autorizacao implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Autorizacao");
		
		HttpServletRequest requestServlet = (HttpServletRequest) request;
		HttpServletResponse responseServlete = (HttpServletResponse) response;
		
		String parametroAcao = requestServlet.getParameter("acao");
		
		HttpSession session = requestServlet.getSession();
		
		boolean usuarioNaoLogado = ( session.getAttribute("usuarioLogado") == null );
		boolean eUmaCaoProtegida = !( parametroAcao.equals("Login") || parametroAcao.equals("LoginForm") );
		
		
		if(usuarioNaoLogado && eUmaCaoProtegida) {
			responseServlete.sendRedirect("rederict:entrada?acao=LoginForm");
			return;
		}
		
		
		
		chain.doFilter(request, response);
	}
	
	

}

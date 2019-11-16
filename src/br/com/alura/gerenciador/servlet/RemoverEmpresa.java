package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

/**
 * Servlet implementation class RemoverEmpresa
 */
@WebServlet("/removerEmpresa")
public class RemoverEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String idParametro = request.getParameter("id");
    	Integer id = Integer.valueOf(idParametro);
    	
    	Banco banco = new Banco();
    	banco.removerEmpresa(id);
    	
    	System.out.println(id);
    	
    	response.sendRedirect("listaEmpresa");
    }

}

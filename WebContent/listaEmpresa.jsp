<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Importe da biblioteca -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Importe da biblioteca -->
<c:url value="/removerEmpresa" var="linkServletRemoverEmpresa"></c:url>
<c:url value="/mostrarEmpresa" var="linkServletMostarEmpresa"></c:url> 
  
<!DOCTYPE html>	
<html>
	<body>
		<c:if test="${not empty empresa}">
			Empresa ${empresa} Cadastrada!!
		</c:if>
		</br>
		Lista de Empresas: </br>
		<ul>
			<c:forEach items="${empresas}" var="empresa"><!-- Var se torna a variavel-->
				<fmt:formatDate value="${empresa.dataAbertura}" var="data" pattern="dd/MM/yyyy"/>
				<li>${empresa.nome} ${data}<!-- Chamara o metodo getNome() -->
					<a href="${linkServletMostarEmpresa}?id=${empresa.id}">Editar</a>
					<a href="${linkServletRemoverEmpresa}?id=${empresa.id}">Remover</a>
				</li>
				
			</c:forEach>
		</ul>
		
	</body>
</html>
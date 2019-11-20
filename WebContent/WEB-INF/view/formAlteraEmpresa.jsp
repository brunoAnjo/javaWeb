<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkServletAlterarEmpresa"></c:url>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletAlterarEmpresa}" method="post">
		<fmt:formatDate value="${empresa.dataAbertura}" var="data" pattern="dd/MM/yyyy"/>
	    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
	    Data Abertura: <input type="text" name="data" value="${data}"/>
	    <input type="hidden" name="id" value="${empresa.id }">
	    <input type="hidden" name="acao" value="AlterarEmpresa">
	    <input type="submit" value="Altear">
    </form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Importe da biblioteca -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<c:url value="/listaEmpresa" var="linkServletListaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Insert title here</title>
</head>
<body class="text-center">
	
	<form action="${linkServletNovaEmpresa}" method="post">
	  <div class="form-group row">
	    <label for="inputNome" class="col-sm-2 col-form-label">Nome da Empresa</label>
	    <div class="col-sm-4">
	      <input type="name" name="nome" class="form-control" id="inputNome" placeholder="Nome da Empresa">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="inputdata" class="col-sm-2 col-form-label">Data Abertura</label>
	    <div class="col-sm-4">
	    	
	     <input name="data" type="text" class="form-control" id="inputDate" placeholder="Data de Abertura" value="<fmt:formatDate value="${empresa.dataAbertura}" var="data" pattern="dd/MM/yyyy"/>">
	    </div>
	  </div>
	  <div class="form-group row">
	    <div class="col-sm-10">
	      <button type="submit" class="btn btn-primary">Cadastrar</button>
	      <a href="${linkServletListaEmpresa }">Listar Empresas</a>
	    </div>
	  </div>
	</form>
	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
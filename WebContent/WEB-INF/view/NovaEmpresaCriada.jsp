<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Importe da biblioteca -->

<html>
	<body>
		
		<c:if test="${not empty empresa}">
			Empresa ${empresa} Cadastrada!!
		</c:if>
		<c:if test="${empty empresa}">
			Nem uma Empresa Cadastrada!!
		</c:if>
	</body>
</html>
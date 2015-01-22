<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>

<!DOCTYPE html>
<html>
<head>
	<link href="css/jquery-ui.css" rel="stylesheet">
	<link href="css/form.css" rel="stylesheet">
	
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	
	<meta charset="ISO-8859-1">
	<title>Tarefas</title>
</head>
<body>
	<h3>Editar tarefa</h3>
	
	<form action="editaTarefa" method="post" class="basic-grey">
	
		<input type="hidden" name="id" value="${tarefa.id}">
		
		Descrição:
		<br>
		<textarea name="descricao" rows="5" cols="100">${tarefa.descricao}</textarea>
		<br>
		
		Finalizado? <input name="finalizado" type="checkbox" value="1" ${tarefa.finalizado == 0 ? '' : "checked"}>
		<br>
		
		<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" var="data" />
		
		Data de finalização:
		<br>
		<util:campoData id="dataFinalizacao" value="${data}"></util:campoData>
		<br>
		
		<input type="submit" class="button" value="Salvar">
	</form>
</body>
</html>
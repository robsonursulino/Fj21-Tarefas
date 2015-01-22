<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<link href="css/form.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Tarefa</title>
</head>
<body>
	<h3>Adicionar tarefas</h3>
	
	<form:errors path="tarefa.descricao" cssStyle="color:red"></form:errors>
	
	<form action="adicionaTarefa" method="post" class="basic-grey">
		Descrição:
		<br>
		<textarea rows="5" cols="100" name="descricao"></textarea>
		<br>
		<input type="submit" class="button" value="Salvar">
	</form>
	
</body>
</html>
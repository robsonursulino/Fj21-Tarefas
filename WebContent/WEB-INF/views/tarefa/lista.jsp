<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/estilo_tabela.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Tarefas</title>
</head>
<body>
	<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {"id" : id}, function(dados) {
				$("#tarefa_" + id).html(dados);
			});
		}
		function removeAgora(id) {
			$.post("removeTarefa", {"id" : id}, function() {
				$("#tarefa_" + id).hide();
			});
		}
	</script>

	<a href="novaTarefa">Criar nova tarefa</a>   <a href="logout">Logout</a>
	<br>
	<br>
	<table class="datagrid" cellspacing="0">
		<tr>
			<td>Código</td>
			<td>Descrição</td>
			<td>Finalizado</td>
			<td>Data de finalização</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa" varStatus="id"> 
			<tr id="tarefa_${tarefa.id}" class="${id.index % 2 == 0 ? 'even' : 'odd'}">
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:choose>
					<c:when test="${tarefa.finalizado == 0}">
						<td><a href="#" onclick="finalizaAgora(${tarefa.id})">Finalizar agora</a></td>	
					</c:when>
					<c:otherwise>
						<td>Finalizado</td>
					</c:otherwise>
				</c:choose>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="mostraTarefa?id=${tarefa.id}">Editar</a>
				<td><a href="#" onclick="removeAgora(${tarefa.id})">Remover</a>
			</tr>	
		</c:forEach>	
	</table>
</body>
</html>
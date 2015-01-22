<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<td>${tarefa.id}</td>
<td>${tarefa.descricao}</td>
<td>Finalizado</td>
<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
<td><a href="mostraTarefa?id=${tarefa.id}">Editar</a>
<td><a href="#" onclick="removeAgora(${tarefa.id})">Remover</a>

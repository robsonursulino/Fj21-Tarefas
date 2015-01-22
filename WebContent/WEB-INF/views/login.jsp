<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/form.css" rel="stylesheet">
	<title>Tarefas</title>
</head>
<body>
	<form action="efetuaLogin" method="post" class="basic-grey">
	    <h1 align="center">Sistema de Tarefas 
    	    <span>Acesso ao sistema</span>
    	</h1>
    
    	<label>
        	<span>Login</span>
        	<input id="login" type="text" name="login"/>
    	</label>
   
    	<label>
	        <span>Senha</span>
    	    <input id="senha" type="password" name="senha"/>
    	</label>
   
	     <label>
    	    <span>&nbsp;</span>
        	<input type="submit" class="button" value="Entrar" />
    	</label>    
	</form>
</body>
</html>
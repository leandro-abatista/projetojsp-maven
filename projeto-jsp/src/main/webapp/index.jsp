<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto JSP</title>
</head>
<body>

	<h1>Olá, Seja Bem vindo ao projeto JSP</h1>
	
	<br>
	<br>
	<h4>Os campos com (*) são obrigatórios</h4>
	<br>
	<br>
	
	
	<h3>${msg}</h3>
	
	<form action="ServletLogin" method="post">
		
		<table>
			<tr>
				<td><label id="login">Login:*</label></td>
				<td>
					<input type="text" name="login">
				</td>
			</tr>
			
			<tr>
				<td><label id="senha">Senha:*</label></td>
				<td>
					<input type="password" name="senha">
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Enviar">
				</td>
			</tr>
			
		</table>
		
	</form>
</body>
</html>
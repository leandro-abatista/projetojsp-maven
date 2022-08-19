<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    	
    <script type="text/javascript" src="resources/js/notify.js"></script>
    
    <link rel="stylesheet" href="resources/css/styles-pag-erro.css" type="text/css">
	<title>Projeto JSP</title>
</head>
<body>

	<div class="card text-center">
		<div class="card-header bg-danger mb-3">Mensagem de erro!</div>
		<div class="card-body">
			<h5 class="card-title">Entre em contato com a equipe de suporte do sistema.</h5>
			<textarea class="form-control" id="message" rows="3">${msgPagErro}</textarea>
		</div>
		<div class="card-footer text-muted">
			<output>
			<% 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				dtf.format(LocalDateTime.now());
			%>
			</output>
		</div>
	</div>

</body>
</html>
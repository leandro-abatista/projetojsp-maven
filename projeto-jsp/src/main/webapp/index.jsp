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
    
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css">
	<title>Projeto JSP</title>
</head>
<body>
	
	<div class="card">
		
		<div class="alert alert-primary" role="alert">
			<strong><h6 id="msgErro">${msgErro}</h6></strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	
		<div class="card-body">

			<form action="<%= request.getContextPath() %>/ServletLogin" method="post" 
				class="row g-3 needs-validation" novalidate>

				<input type="hidden" value="<%=request.getParameter("url")%>">

				<div class="mb-3">
					<label for="login" class="form-label">Login:</label> 
					<input id="login" type="text" name="login" class="form-control" 
						placeholder="Digite seu login" required="required">
					<div class="invalid-feedback">
				       Campo obrigatório
				    </div>
				</div>
				
				<div class="mb-3">
					<label for="senha" class="form-label">Senha:</label> 
					<input id="senha" type="password" name="senha" class="form-control"
						placeholder="Digite sua senha" required="required">
					<div class="invalid-feedback">
				      Campo obrigatório
				    </div>
				</div>

				<div class="d-grid gap-2">
					<input id="botaoEntrar" type="submit" value="Acessar" class="btn btn-primary">
				</div>

			</form>
		</div>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    <script type="text/javascript">

		
	    (function () {
	  	  'use strict'
	
	  	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  	  var forms = document.querySelectorAll('.needs-validation')
	
	  	  // Loop over them and prevent submission
	  	  Array.prototype.slice.call(forms)
	  	    .forEach(function (form) {
	  	      form.addEventListener('submit', function (event) {
	  	        if (!form.checkValidity()) {
	  	          event.preventDefault()
	  	          event.stopPropagation()
	  	        }
	
	  	        form.classList.add('was-validated')
	  	      }, false)
	  	    })
	  	})()
	  	
    </script>
</body>
</html>
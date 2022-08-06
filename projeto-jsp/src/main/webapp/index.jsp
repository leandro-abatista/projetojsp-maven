<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css">
<title>Projeto JSP</title>
</head>
<body>

	<div id="message">
		<h4>${msg}</h4>
	</div>

	<div class="card">

		<div class="card-header text-center">
			<h1>Olá, Seja Bem vindo ao projeto JSP</h1>
		</div>
		
		<div class="card-body">

			<form action="ServletLogin" method="post" class="row g-3 needs-validation" novalidate>

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
					<input type="submit" value="Entrar" class="btn btn-primary">
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
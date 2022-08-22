<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt_BR">

<jsp:include page="head.jsp" /><!-- Aqui está incluindo nesta página o nosso head -->

<body>
	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp" />
	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<!-- Aqui chama a página de inclusão navbar -->
			<jsp:include page="navbar.jsp" />

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbar-main-menu.jsp" />

					<div class="pcoded-content">
						<!-- Page-header start -->

						<!-- Aqui chama a página page-header -->
						<jsp:include page="page-header.jsp" />

						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">
										<!-- Início Aqui dentro, fica todo o conteúdo -->

										<div class="alert alert-success d-flex align-items-center" role="alert"
											style="padding: 15px;">
											<svg class="bi flex-shrink-0 me-2" width="24" height="24"
												role="img" aria-label="Success:">
												<use xlink:href="#check-circle-fill" /></svg>
											<div style="font-weight: 700;" id="mensagem">${msg}</div>
										</div>

										<div class="card-block">
											<h1 
											style="font-size: 25px; background: #B0C4DE; border-radius: 4px; padding: 5px; font-weight: 400;"
												class="sub-title">Cadastro - Usuário</h1>
										</div>
										
										<div class="card" style="background: #B0C4DE;">
										<!-- Formulário de cadastro de usuário -->
										<form id="formUsuario" action="<%= request.getContextPath() %>/ServletUsuarioController" 
											method="post">
											
											<input type="hidden" name="acao" id="acao" value="">
											
											<div class="card-block">
											
												<div class="form-group row">
													<label for="id" class="form-control-label col-form-label-lg">ID:</label>
													<div class="col-md-2">
														<input id="id" type="text" name="id" class="form-control form-control-lg" 
															readonly="readonly" value="${modelo.id}">
													</div>
												</div>
												
												<div class="form-group row">
													<label for="nome" class="form-control-label col-form-label-lg">Nome:</label>
													<div class="col-md-6">
														<input id="nome" type="text" name="nome" class="form-control form-control-lg" 
															maxlength="120" required="required" value="${modelo.nome}">
													</div>
													
													<label for="cpf" class="form-control-label col-form-label-lg">CPF:</label>
													<div class="col-md-3">
														<input id="cpf" type="text" name="cpf" class="form-control form-control-lg" 
															maxlength="14" required="required" value="${modelo.cpf}">
													</div>
												</div>
												
												<div class="form-group row">
													<label for="email" class="form-control-label col-form-label-lg">Email:</label> 
													<div class="col-md-6">
														<input type="email" name="email" class="form-control form-control-lg"
															id="email" autocomplete="off" required="required" value="${modelo.email}">
													</div>												
												</div>

												<div class="form-group row">
													<label for="login" class="form-control-label col-form-label-lg">Login:</label>
													<div class="col-md-5">
														<input id="login" type="text" name="login" class="form-control form-control-lg" 
															maxlength="50" autocomplete="off" required="required" value="${modelo.login}">
													</div>
													
													<label for="senha" class="form-control-label col-form-label-lg">Senha:</label>
													<div class="col-md-5">
														<input id="senha" type="password" name="senha" class="form-control form-control-lg" 
															maxlength="10" autocomplete="off" required="required" value="${modelo.senha}">
													</div>
												</div>
												
												
												
												<div class="form-group">
													<button type="button"  style="font-weight: bold; font-size: 18px" 
														onclick="limparForm();"	class="btn btn-primary waves-effect waves-light">Novo </button>
													<button  style="font-weight: bold; font-size: 18px" 
														class="btn btn-success waves-effect waves-light">Salvar</button>
                    								<button type="button" style="font-weight: bold; font-size: 18px" 
                    									onclick="criarDeleteAjax();" class="btn btn-danger waves-effect waves-light">Excluir</button>

														<!-- Button trigger modal -->
														<button
															style="font-weight: bold; font-size: 18px" 
															type="button" class="btn btn-secondary"
															data-toggle="modal" data-target="#modalusuario">
															Consultar
														</button>
													</div>
											</div>
										</form>
									</div>

										<!-- Fim Aqui dentro, fica todo o conteúdo -->
									</div>
								</div>
								<!-- Page-body end -->
							</div>
							<div id="styleSelector"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Aqui chama a página javascriptfile -->
	<jsp:include page="javascriptfile.jsp" />
	
	<!-- Modal -->
	<div class="modal fade" id="modalusuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Pesquisa de Usuário</h5>
	        <button type="button" class="close" data-dismiss="modal" style="font-weight: bold; font-size: 18px" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">

					<div class="input-group mb-6">
						<input id="nomeBusca" type="text" class="form-control form-control-lg" placeholder="Informe o nome">
						<div class="input-group-append">
							<button id="botaoBusca" class="btn btn-success" style="font-weight: bold; font-size: 18px" 
							type="button" onclick="buscarUsuario();">Buscar</button>
						</div>
					</div>

					<table class="table table-sm table-responsive" style="font-size: 18px; font-weight: 600;">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">NOME</th>
								<th scope="col">CPF</th>
								<th scope="col">EMAIL</th>
								<th scope="col">DATA CADASTRO</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>

				</div>
	      <div class="modal-footer">
	        <button type="button" style="font-weight: bold; font-size: 18px" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<script type="text/javascript">

		function limparForm() {
			var elements = document.getElementById("formUsuario").elements;/*retorna os elementos html dentro do form*/

			for(p = 0; p < elements.length; p++){
				elements[p].value = '';
			}
		}

		function criarDelete() {
			if (confirm('Deseja realmente excluir o registro?')) {
				document.getElementById("formUsuario").method = 'get';
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formUsuario").submit();
			} 
		}
		
		function criarDeleteAjax() {
			if (confirm('Deseja realmente excluir o registro?')) {
				var urlAction = document.getElementById('formUsuario').action;
				var idUser = document.getElementById('id').value;

				//fazendo o ajax
				$.ajax({
					method: 'GET',
					url: urlAction,
					data: 'id=' + idUser + '&acao=deletarComAjax',
					success: function(response) {
						limparForm();//após a exclusão, limpa o formulário
						//alert(response);//a string com a response de exclusão, vem da servletUsuarioController
						document.getElementById('mensagem').textContent = response;
					}
					
				}).fail(function(xhr, status, errorThrow) {
					alert('Erro ao deletar registro por ID: ' + xhr.responseText);
				});
			}
		}

		function limparCampoBusca() {
			document.getElementById("nomeBusca").value = '';/*limpa o campo após a busca*/
		}

		/*Com ajax não existe redicrecionamento e nem recarregamento*/
		function buscarUsuario() {
			var nomeBusca = document.getElementById('nomeBusca').value;
			if (nomeBusca != null && nomeBusca != '' && nomeBusca.trim() != '') {//validando para verificar se tem valor para buscar no banco de dados

				var urlAction = document.getElementById('formUsuario').action;
				
				//fazendo o ajax
				$.ajax({
					method: 'GET',
					url: urlAction,
					data: 'nomeBusca=' + nomeBusca + '&acao=buscarUserComAjax',
					success: function(response) {
						
						
					}
					
				}).fail(function(xhr, status, errorThrow) {
					alert('Erro ao buscar registro por nome: ' + xhr.responseText);
				});
				limparCampoBusca();
			}
		}

		
	</script>

</body>

</html>

package br.com.ats.projsp.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ats.projsp.classes.model.ModelLogin;
import br.com.ats.projsp.dao.DaoUsuarioRepository;


@WebServlet("/ServletUsuarioController")
public class ServletUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuarioRepository repository = new DaoUsuarioRepository();
       
    
    public ServletUsuarioController() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String mensagemSucesso = "Operação realizada com sucesso!";
			String mensagemUpdateSucesso = "Registro atualizado com sucesso!";
			String mensagemAlerta = "Já existe usuário com o mesmo login, informe um login válido!";
				
			//PEGANDO OS PARÂMETROS QUE VEM DA TELA
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			//INICIANDO O OBJETO SETANDO OS DADOS NO OBJETO
			ModelLogin modelo = new ModelLogin();
			modelo.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelo.setNome(nome);
			modelo.setCpf(cpf);
			modelo.setEmail(email);
			modelo.setLogin(login);
			modelo.setSenha(senha);
			modelo.setDataCadastro(Timestamp.valueOf(LocalDateTime.now()));
			
			if (repository.validarLogin(modelo.getLogin()) && modelo.getId() == null) {
				request.setAttribute("msg", mensagemAlerta);
			} else {
				if (modelo.isNovo()) {
					request.setAttribute("msg", mensagemSucesso);
				} else {
					request.setAttribute("msg", mensagemUpdateSucesso);
				}
				modelo = repository.salvar(modelo);
			}
			//APÓS SALVAR, A PÁGINA É REDIRECIONADA PARA CADASTRO-USUARIO.JSP
			request.setAttribute("modelo", modelo);
			request.getRequestDispatcher("principal/cadastro-usuario.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			//CASO HAJA ALGUM ERRO, SERÁ DIRECIONADO PARA A PÁGINA DE ERRO
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			request.setAttribute("msgPagErro", e.getMessage());
		}
		
	}

}

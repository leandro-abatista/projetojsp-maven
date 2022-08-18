package br.com.ats.projsp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ats.projsp.classes.model.ModelLogin;


@WebServlet("/ServletUsuarioController")
public class ServletUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public ServletUsuarioController() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		//APÓS SALVAR, A PÁGINA É REDIRECIONADA PARA CADASTRO-USUARIO.JSP
		request.setAttribute("modelo", modelo);
		request.getRequestDispatcher("principal/cadastro-usuario.jsp").forward(request, response);
	}

}

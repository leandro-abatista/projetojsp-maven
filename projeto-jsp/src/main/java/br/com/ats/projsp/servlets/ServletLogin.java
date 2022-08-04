package br.com.ats.projsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ats.projsp.classes.model.ModelLogin;

/**
 * O chamado Controller -> são as servlets ou nesse caso ServletLoginController
 */
@WebServlet("/ServletLogin")/*Mapeamento URL onde são enviados os dados da tela por parâmetros*/
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUTOR PADRÃO
	 */
    public ServletLogin() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Pegando os parâmetros vindos da tela*/
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		/**
		 * Validando os dados vindos da tela por parâmetro
		 */
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			/*Setando os parâmetros no objeto*/
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			/**
			 * Simulação de autenticação
			 */
			if (modelLogin.getLogin().equalsIgnoreCase("admin") 
				&& modelLogin.getSenha().equalsIgnoreCase("admin")) {
				
				/*Pegando os atributos de sessão e manter o usuário logaod no sistema
				 * Se quiser, pode deixar apenas o login para a senha não ficar na sessão*/
				request.getSession().setAttribute("usuarioLogado", modelLogin.getLogin());
				
				/**
				 * redirecionando a página após a autenticação está correta
				 * 
				 */
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/principal.jsp");
				request.setAttribute("msg", "Usuário Logado com sucesso!");
				redirecionar.forward(request, response);
				
			} else {
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente!");
				redirecionar.forward(request, response);
			}
			
		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o login e senha corretamente!");
			redirecionar.forward(request, response);
		}
		
		
	}

}

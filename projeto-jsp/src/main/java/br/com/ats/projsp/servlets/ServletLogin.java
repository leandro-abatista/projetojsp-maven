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
 * O chamado Controller -> s�o as servlets ou nesse caso ServletLoginController
 */
@WebServlet("/ServletLogin")/*Mapeamento URL onde s�o enviados os dados da tela por par�metros*/
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUTOR PADR�O
	 */
    public ServletLogin() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Pegando os par�metros vindos da tela*/
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		/**
		 * Validando os dados vindos da tela por par�metro
		 */
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			/*Setando os par�metros no objeto*/
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			/**
			 * Simula��o de autentica��o
			 */
			if (modelLogin.getLogin().equalsIgnoreCase("admin") 
				&& modelLogin.getSenha().equalsIgnoreCase("admin")) {
				
				/*Pegando os atributos de sess�o e manter o usu�rio logaod no sistema
				 * Se quiser, pode deixar apenas o login para a senha n�o ficar na sess�o*/
				request.getSession().setAttribute("usuarioLogado", modelLogin.getLogin());
				
				/**
				 * redirecionando a p�gina ap�s a autentica��o est� correta
				 * 
				 */
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/principal.jsp");
				request.setAttribute("msg", "Usu�rio Logado com sucesso!");
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

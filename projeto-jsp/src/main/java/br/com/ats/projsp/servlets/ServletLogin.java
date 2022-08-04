package br.com.ats.projsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ats.projsp.classes.model.ModelLogin;
import br.com.ats.projsp.dao.DaoModelLoginRepository;

/**
 * O chamado Controller -> são as servlets ou nesse caso ServletLoginController
 */
@WebServlet(urlPatterns = {"/principal/ServletLogin","/ServletLogin"})/*Mapeamento URL onde são enviados os dados da tela por parâmetros*/
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoModelLoginRepository loginRepository = new DaoModelLoginRepository();

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
		String url = request.getParameter("url");
		
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
			if (loginRepository.validarAutenticacao(modelLogin)) {
				
				/*Pegando os atributos de sessão e manter o usuário logaod no sistema
				 * Se quiser, pode deixar apenas o login para a senha não ficar na sessão*/
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				if (url == null || url.equals("null")) {
					url = "/principal/principal.jsp";
				}
				
				/**
				 * redirecionando a página após a autenticação está correta
				 * 
				 */
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);
				request.setAttribute("msg", "Usuário Logado com sucesso!");
				redirecionar.forward(request, response);
				
			} else {
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Login e/ou senha incorretos!\nPor favor informe dados válidos!");
				redirecionar.forward(request, response);
			}
			
		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "Informe o login e senha corretamente!");
			redirecionar.forward(request, response);
		}
		
		
	}

}

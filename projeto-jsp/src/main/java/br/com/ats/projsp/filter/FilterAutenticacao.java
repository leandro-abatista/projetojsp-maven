package br.com.ats.projsp.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ats.projsp.classes.model.ModelLogin;
import br.com.ats.projsp.connection.SingleConnectionBanco;

@WebFilter(urlPatterns = {"/principal/*"})/*Intercepta todas as requisi��es que virem do projeto ou mapeamento*/
public class FilterAutenticacao extends HttpFilter implements Filter {
	
	private static Connection connection;
       
	/**
	 * CONSTRUTOR PADR�O
	 */
    public FilterAutenticacao() {
    }

    /**
     * Encerra/mata os processos de conex�o quando o servidor � parado
     */
	public void destroy() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Intercepta as requisi��es e resposta no sistema. Tudo passa pelo doFilter, 
	 * seja valida��o de autentica��o, redirecionamentos espec�ficos e etc
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
		
			HttpServletRequest requisicao = (HttpServletRequest) request;
			HttpSession sessao = requisicao.getSession();
			
			/*Pegando o objeto logado na sess�o*/
			//ModelLogin usuarioLogadoNaSessao = (ModelLogin) httpSession.getAttribute("usuario");
			String usuarioLogadoNaSessao = (String) sessao.getAttribute("usuario");
			
			/*Pegando a url que est� sendo acessada*/
			String urlParaAutenticar = requisicao.getServletPath();
			
			/*validar se est� logado, se n�o, redireciona para a tela de login*/
			if (usuarioLogadoNaSessao == null 
					&& !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {/*N�o est� logado na sess�o*/
				
				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Para acesso ao sistema, informe o login e senha!");
				redireciona.forward(request, response);
				return;/*Para a execu��o e redireciona para o login*/
				
			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();/*Se deu tudo certo commita as altera��oes*/
		
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
	}
	
	/**
	 * Inicia os processos ou recursos quando o servidor sobe o projeto
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/**
		 * Assim que inicia o sistema, tamb�m � criado uma conex�o com o banco de dados
		 */
		connection = SingleConnectionBanco.getConnection();
	}

}

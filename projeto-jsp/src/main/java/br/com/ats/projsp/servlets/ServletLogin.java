package br.com.ats.projsp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idade"));
	}

}

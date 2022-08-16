package br.com.ats.projsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SingleConnectionBanco {

	
	private static String banco = "jdbc:postgresql://localhost:5433/banco_projsp?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "1234";
	private static Connection connection = null;
	
	/**
	 * Chama de forma direta de qualquer lugar do sistema
	 */
	static {
		conectar();
	}
	
	/**
	 * Quando tiver uma instância vai conectar
	 */
	public SingleConnectionBanco() {
		conectar();
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	private static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");/*carrega o driver de conexão do banco*/
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);/*Coloquei falso para não efetuar alterações no banco sem autorização*/
				System.out.println("Banco conectado com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

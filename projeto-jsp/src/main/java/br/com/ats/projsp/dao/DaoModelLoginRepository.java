package br.com.ats.projsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ats.projsp.classes.model.ModelLogin;
import br.com.ats.projsp.connection.SingleConnectionBanco;

public class DaoModelLoginRepository {

	private Connection connection;
	
	public DaoModelLoginRepository(){
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin modelLogin) {
		
		String sql = "select login, senha from model_login where login = ? and senha = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, modelLogin.getLogin());
			statement.setString(2, modelLogin.getSenha());
			
			ResultSet resultadoDaConsulta = statement.executeQuery();
			
			if (resultadoDaConsulta.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}

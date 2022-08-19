package br.com.ats.projsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ats.projsp.classes.model.ModelLogin;
import br.com.ats.projsp.connection.SingleConnectionBanco;

public class DaoUsuarioRepository {

	private Connection connection;
	
	public DaoUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public ModelLogin salvar(ModelLogin objeto) throws Exception {
		
		if(objeto.isNovo()) {
			
			String sql = "INSERT INTO public.model_login(nome, cpf, email, login, senha, data_cadastro)"
					+ "    VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, objeto.getNome());
			statement.setString(2, objeto.getCpf());
			statement.setString(3, objeto.getEmail());
			statement.setString(4, objeto.getLogin());
			statement.setString(5, objeto.getSenha());
			statement.setTimestamp(6, objeto.getDataCadastro());
			
			statement.execute();
			connection.commit();
		
		} else {
			
			String sql = "UPDATE public.model_login"
					+ " SET nome=?, cpf=?, email=?, login=?, senha=?"
					+ " WHERE id = "+objeto.getId()+";";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, objeto.getNome());
			statement.setString(2, objeto.getCpf());
			statement.setString(3, objeto.getEmail());
			statement.setString(4, objeto.getLogin());
			statement.setString(5, objeto.getSenha());
			
			statement.executeUpdate();
			connection.commit();
			
		}
		
		return this.consultar(objeto.getLogin(), objeto.getCpf());
	}
	
	public ModelLogin consultar(String login, String cpf) throws Exception {
		ModelLogin modelo = new ModelLogin();
		
		String sql = "SELECT id, nome, cpf, email, login, senha "
				+ " FROM model_login"
				+ " WHERE upper(login) = upper('"+login+"') OR cpf = ('"+cpf+"');";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		if (resultado.next()) {//Se tem um resultado
			modelo.setId(resultado.getLong("id"));
			modelo.setNome(resultado.getString("nome"));
			modelo.setCpf(resultado.getString("cpf"));
			modelo.setEmail(resultado.getString("email"));
			modelo.setLogin(resultado.getString("login"));
			modelo.setSenha(resultado.getString("senha"));
		}
		
		return modelo;
	}
	
	public boolean validarLogin(String login) throws Exception {
		
		String sql = "SELECT count(1) > 0 as existe FROM model_login"
				+ " WHERE upper(login) = upper('"+login+"');";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		if (resultado.next()) {//o next() entra nos resultados do sql
			return resultado.getBoolean("existe");
		}
		
		return false;
	}
	
	public void deletar(Long idUser) throws Exception {
		
		String sql = "DELETE FROM public.model_login "
				+ " WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, idUser);
		
		statement.executeUpdate();
		connection.commit();
	}
}

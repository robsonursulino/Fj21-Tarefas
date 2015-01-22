package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Usuario;

@Repository
public class JdbcUsuarioDAO {
	
	private Connection connection;
	
	@Autowired
	public JdbcUsuarioDAO(DataSource datasource) {
		try {
			connection = datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		
		String sql = "select * from usuario where login=? and senha=?";
		boolean existe = false;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				existe = true;
			}
			
			rs.close();
			stmt.close();
			
			return existe;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}

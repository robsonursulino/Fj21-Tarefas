package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository(value="JdbcTarefaDAO")
public class JdbcTarefasDAO implements TarefaDAO {

	private Connection connection;
	
	@Autowired
	public JdbcTarefasDAO(DataSource datasource) {
		try {
			connection = datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Tarefa tarefa) {
		
		String sql = "insert into tarefa(descricao, finalizado) values(?, ?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setInt(2, tarefa.getFinalizado());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Tarefa tarefa) {
		
		String sql = "update tarefa set descricao=?, finalizado=?, data_finalizacao=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setInt(2, tarefa.getFinalizado());
			if (tarefa.getDataFinalizacao() != null) {
				stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			} else {
				stmt.setDate(3, null);
			}
			
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		
		String sql = "delete from tarefa where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Tarefa> lista() {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		String sql = "select * from tarefa";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getInt("finalizado"));
				
				Date data = rs.getDate("data_finalizacao");
				if (data != null) {
					Calendar dataFinalizacao = Calendar.getInstance();
					dataFinalizacao.setTime(data);
					tarefa.setDataFinalizacao(dataFinalizacao);
				}
				
				tarefas.add(tarefa);
			}
			
			rs.close();
			stmt.close();
			
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa buscaPorId(long id) {
		
		String sql = "select * from tarefa where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Tarefa tarefa = new Tarefa();
			
			if (rs.next()) {
				tarefa.setId(id);
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getInt("finalizado"));
				
				if (rs.getDate("data_finalizacao") != null) {
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data_finalizacao"));
					tarefa.setDataFinalizacao(data);
				}	
			}
			
			rs.close();
			stmt.close();
			
			return tarefa;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);	
		}
	}
	
	public void finaliza(long id) {

		String sql = "update tarefa set finalizado=1, data_finalizacao=current_date() where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}

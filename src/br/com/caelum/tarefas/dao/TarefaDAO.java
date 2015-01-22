package br.com.caelum.tarefas.dao;

import java.util.List;

import br.com.caelum.tarefas.modelo.Tarefa;

public interface TarefaDAO {
	
	void adiciona(Tarefa tarefa);
	void altera(Tarefa tarefa);
	void remove(Tarefa tarefa);
	void finaliza(long id);
	List<Tarefa> lista();
	Tarefa buscaPorId(long id);

}

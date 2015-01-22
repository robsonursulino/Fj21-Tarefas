package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository(value="JpaTarefaDAO")
public class JpaTarefaDAO implements TarefaDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void adiciona(Tarefa tarefa) {
		em.persist(tarefa);
	}

	@Override
	public void altera(Tarefa tarefa) {
		em.merge(tarefa);
	}

	@Override
	public void remove(Tarefa tarefa) {
		Tarefa tarefaRemover = em.find(Tarefa.class, tarefa.getId());
		em.remove(tarefaRemover);
	}

	@Override
	public void finaliza(long id) {
		Tarefa tarefa = em.find(Tarefa.class, id);
		tarefa.setFinalizado(1);
		tarefa.setDataFinalizacao(Calendar.getInstance());
	}

	@Override
	public List<Tarefa> lista() {
		List<Tarefa> lista = em.createQuery("select t from Tarefa t").getResultList();
		return lista;
	}
	
	@Override
	public Tarefa buscaPorId(long id) {
		return em.find(Tarefa.class, id);
	}

}

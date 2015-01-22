package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;

public class BuscaTarefas {
	
	public static void main(String[] args) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager m = f.createEntityManager();

		Query q = m.createQuery("select t from Tarefa as t where t.finalizado = :finalizado");
		q.setParameter("finalizado", 1);
		
		List<Tarefa> tarefas = q.getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.getDescricao());
		}
		
		m.close();
	}

}

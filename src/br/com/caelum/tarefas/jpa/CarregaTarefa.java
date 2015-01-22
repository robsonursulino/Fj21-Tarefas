package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class CarregaTarefa {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager m = f.createEntityManager();
		
		Tarefa tarefa = m.find(Tarefa.class, 21L);
		
		System.out.println("Tarefa encontrada: " + tarefa.getDescricao());
		
		m.close();
	}

}

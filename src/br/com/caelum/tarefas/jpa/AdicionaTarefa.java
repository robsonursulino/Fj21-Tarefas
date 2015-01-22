package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AdicionaTarefa {
	
	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("teste3");
		tarefa.setFinalizado(0);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("ID da nova tarefa: " + tarefa.getId());
		
		manager.close();
	}

}

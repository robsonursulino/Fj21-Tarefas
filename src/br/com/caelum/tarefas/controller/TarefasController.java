package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	@Qualifier("JpaTarefaDAO")
	private TarefaDAO dao;
	
	@RequestMapping("novaTarefa")
	public String novaTarefa() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(@Valid Tarefa tarefa, BindingResult result) {
		
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("listaTarefas")
	public String listaTarefas(Model model) {
		
		List<Tarefa> tarefas = dao.lista();
		
		model.addAttribute("tarefas", tarefas);
		
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public void removeTarefa(Tarefa tarefa, HttpServletResponse response) {
		
		dao.remove(tarefa);
		
		response.setStatus(200);
		
	}
	
	@RequestMapping("mostraTarefa")
	public String mostraTarefa(long id, Model model) {
		
		model.addAttribute("tarefa", dao.buscaPorId(id));
		
		return "tarefa/mostra";
	}
	
	@RequestMapping("editaTarefa")
	public String editaTarefa(Tarefa tarefa) {
		
		dao.altera(tarefa);
		
		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public String finalizaTarefa(long id, Model model) {
		
		dao.finaliza(id);
		
		model.addAttribute("tarefa", dao.buscaPorId(id));
		
		return "tarefa/finalizada";
	}

}

package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("OlaMundoSpring")
	public String execute() {
		System.out.println("Olá mundo com Spring MVC!");
		return "ok";
	}
	
}

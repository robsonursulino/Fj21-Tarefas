package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JpaUsuarioDAO;
import br.com.caelum.tarefas.modelo.Usuario;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	private JpaUsuarioDAO dao;
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuario", usuario);
			return "menu";
		} else {
			return "redirect:loginForm";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}

package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Usuario;

@Repository
public class JpaUsuarioDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public boolean existeUsuario(Usuario usuario) {
		
		boolean existe = false;
		
		Query qr = em.createQuery("select u from Usuario u where u.login=:login and u.senha=:senha");
		qr.setParameter("login", usuario.getLogin());
		qr.setParameter("senha", usuario.getSenha());
		
		List<Usuario> usuarios = qr.getResultList();
		
		existe = !usuarios.isEmpty();

		return existe;
	}

}

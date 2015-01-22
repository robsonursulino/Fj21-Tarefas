package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		String uri = request.getRequestURI();
		
		if (uri.endsWith("loginForm") ||
				uri.endsWith("efetuaLogin") ||
				uri.endsWith("css") ||
				uri.endsWith("js") ||
				uri.endsWith("images")) {
			return true;
		}
		
		if (request.getSession().getAttribute("usuario") != null) {
			return true;
		}
		
		response.sendRedirect("loginForm");
		return false;
	}

}

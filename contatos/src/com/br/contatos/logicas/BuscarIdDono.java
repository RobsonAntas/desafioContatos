package com.br.contatos.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.dao.DaoContatos;

public class BuscarIdDono implements Logica {

	@Override
	public void executaRetorno(HttpServletRequest request, HttpServletResponse response) {
		String id;
		String email = request.getParameter("email");
	    DaoContatos dao = new DaoContatos();
	    try {
	    	if(dao.buscarIdDono(email)!=0) {
			id=Integer.toString(dao.buscarIdDono(email));
			response.setContentType("text/plain");
			response.getWriter().write(id);
			}else {
				response.setContentType("text/plain");
				response.getWriter().write("fail");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}

}

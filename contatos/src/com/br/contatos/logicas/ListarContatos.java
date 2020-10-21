package com.br.contatos.logicas;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.dao.DaoContatos;
import com.br.contatos.model.Usuario;
import com.google.gson.Gson;


public class ListarContatos implements Logica {

	public ListarContatos() {
		
	}
	@Override
	public void executaRetorno(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<Usuario> contatos = new DaoContatos().getContatos();
			String json = new Gson().toJson(contatos);
			response.setContentType("text/plain");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

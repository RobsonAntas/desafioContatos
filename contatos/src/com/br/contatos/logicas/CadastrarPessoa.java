package com.br.contatos.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.dao.DaoContatos;

public class CadastrarPessoa implements Logica {

	@Override
	public void executaRetorno(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		DaoContatos dao = new DaoContatos();
		
		try {
			if(!nome.equals("")|!email.equals("")|!senha.equals("")){
			dao.criarCadastro(nome, email, senha);
			response.setContentType("text/plain");
			response.getWriter().write("success");
			}else {
				response.setContentType("text/plain");
				response.getWriter().write("fail");}
		} catch (Throwable e) {
				e.printStackTrace();
		}
		
	}
}

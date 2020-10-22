package com.br.contatos.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.dao.DaoContatos;

public class AdicionarContatos implements Logica {

	@Override
	public void executaRetorno(HttpServletRequest request, HttpServletResponse response) {
		int idContato = Integer.parseInt(request.getParameter("idContato"));
		String nomeContato = request.getParameter("nomeContato");
		String telContato = request.getParameter("telContato");
		String emailContato = request.getParameter("emailContato");
		String dddContato = request.getParameter("dddContato");
		String tipo = request.getParameter("tipo");
		
		DaoContatos dao = new DaoContatos();
		try {
			dao.adicionarContato(idContato,nomeContato,telContato,emailContato,dddContato,tipo);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		

	}

}

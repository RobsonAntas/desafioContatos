package com.br.contatos.entrar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.dao.DaoContatos;

public class Triagem extends HttpServlet{
	private boolean resultado= false;
	private String email;
	private String pass;
	/**
	 * 
	 */
	private static final long serialVersionUID = 103331935248113873L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.email = req.getParameter("email");
		this.pass = req.getParameter("pass");	    
		
		try {
			DaoContatos dao = new DaoContatos();
			resultado = dao.autenticacaoUsuario(email, pass);
			if(resultado==true) {
				resp.getWriter().print(1);
			}else{
				resp.getWriter().print(0);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
		
	}

}

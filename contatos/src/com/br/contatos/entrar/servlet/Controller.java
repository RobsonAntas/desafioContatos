package com.br.contatos.entrar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.contatos.logicas.Logica;

//import com.rantas.contactBook.logic.Logica;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Controller() {
		
	}	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("classe");
		String className = "com.br.contatos.logicas." + parametro;
		try {
			Class<?> classe = Class.forName(className, true, this.getClass().getClassLoader());
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
		    logica.executaRetorno(request, response);
			//request.getRequestDispatcher(page).forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi possível criar o objeto" + className, e);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

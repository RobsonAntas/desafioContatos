package com.br.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.br.contatos.conexao.Conexao;
import com.br.contatos.model.Usuario;

public class DaoContatos {
	
	private Connection connection;
	private long id_usuario;
	private PreparedStatement ps2;

	
	public DaoContatos() {
		
	}	
	
	public boolean autenticacaoUsuario(String email, String senha) throws Throwable {
		boolean autentica = false;
		
			this.connection = new Conexao().getConexao();
			PreparedStatement ps = this.connection.prepareStatement("select email, senha from usuarios where email=?");
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			
			Usuario user = new Usuario();
			
				while (result.next()) {
					user.setEmail(result.getString("email"));
					user.setSenha(result.getString("senha"));
							}
				if(user.getEmail()!=null) {
				if(user.getEmail().equals(email)&user.getSenha().equals(senha)) {
					autentica = true;
				  }
				}
			
			result.close();
			ps.close();
			this.connection.close();
		
		     return autentica;
	}

	}

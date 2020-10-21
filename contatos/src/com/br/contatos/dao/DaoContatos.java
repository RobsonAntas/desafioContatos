package com.br.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.br.contatos.conexao.Conexao;
import com.br.contatos.model.Telefone;
import com.br.contatos.model.Usuario;

public class DaoContatos {

	private Connection connection;

	public DaoContatos() {

	}
	
	public void criarCadastro(String nome, String email, String senha) throws Throwable {
	
		this.connection = new Conexao().getConexao();
		PreparedStatement p = this.connection.prepareStatement("SELECT id_dono FROM donotabela ORDER BY id_dono DESC LIMIT 1");
		ResultSet result = p.executeQuery();
		if(result.equals(null)) {
			int id =1;
			PreparedStatement ps = this.connection.prepareStatement("insert into donotabela(id_dono,nome, senha, email) values (?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.setString(3, senha);
			ps.setString(3, email);
		    ps.executeUpdate();
		}else {
		PreparedStatement ps = this.connection.prepareStatement("insert into donotabela(nome, senha, email) values (?,?,?)");
		
		ps.setString(1, nome);
		ps.setString(2, senha);
		ps.setString(3, email);
		
		ps.executeUpdate();
		ps.close();
		this.connection.close();
		System.out.println("cadastrado com sucesso !");
		}
	}

	public boolean autenticacaoUsuario(String email, String senha) throws Throwable {
		boolean autentica = false;

		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("select id_dono, email, senha from donotabela where email=?");
		ps.setString(1, email);
		ResultSet result = ps.executeQuery();

		Usuario user = new Usuario();

		while (result.next()) {
			user.setEmail(result.getString("email"));
			user.setSenha(result.getString("senha"));
			user.setId(result.getInt("id_dono"));
		}
		if (user.getEmail() != null) {
			if (user.getEmail().equals(email) & user.getSenha().equals(senha)) {
				autentica = true;
			}
		}

		result.close();
		ps.close();
		this.connection.close();

		return autentica;
	}

	public List<Usuario> getContatos() {
		try {
			List<Usuario> contatos = new ArrayList<>();
			this.connection = new Conexao().getConexao();
			PreparedStatement ps = this.connection.prepareStatement("");
		     
			ps.close();
			this.connection.close();
			return contatos;

		} catch (Exception e) {
			throw new RuntimeException("Lista não retornada", e);
		}
	}

	
	public void adicionarContato() throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("");
		
		
		ps.close();
		this.connection.close();
	}
	
	public void atualizarCadastro() throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("");
		
		
		ps.close();
		this.connection.close();
	}
	
	public void atualizarContatos() throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("");
		
		
		ps.close();
		this.connection.close();
	}
	
	public void apagarContatos() throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("");
		
		
		ps.close();
		this.connection.close();
	}
}
package com.br.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.br.contatos.conexao.Conexao;
import com.br.contatos.model.Usuario;

public class DaoContatos {

	private Connection connection;
	private int id;

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

	
	public void adicionarContato(int idContato, String nomeContato,String telContato, String emailContato, String dddContato,String tipo) throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement p = this.connection.prepareStatement("SELECT id_telefone FROM telefone ORDER BY id_telefone DESC LIMIT 1");
		ResultSet result = p.executeQuery();
		if(result.equals(null)) {
			p.close();
			result.close();
		int id =1;		
		PreparedStatement ps1 = this.connection.prepareStatement("insert into telefone (id_telefone,donoId,ddd, numerotelefone, tipo) values(?,?,?,?,?)");
        ps1.setInt(1,id);
        ps1.setInt(2,idContato );
        ps1.setString(3,dddContato );
        ps1.setString(4, telContato);
        ps1.setString(5, tipo);
        ps1.close();
		}		
		else {
			PreparedStatement ps2 = this.connection.prepareStatement("insert into telefone (donoId,ddd, numerotelefone, tipo)  values(?,?,?,?)");
	        
	        ps2.setInt(1,idContato );
	        ps2.setString(2,dddContato );
	        ps2.setString(3, telContato);
	        ps2.setString(4, tipo);
	        ps2.close();
	        }
		
		/*tabela contatos
		PreparedStatement p3 = this.connection.prepareStatement("SELECT id_contato FROM contatos ORDER BY id_contato DESC LIMIT 1");
		ResultSet result3 = p3.executeQuery();
		if(result3.equals(null)) {
		int id =1;		
		PreparedStatement ps1 = this.connection.prepareStatement("insert into contatos (id_contato,nomeContato,emailContato, dono_id, telefone_id) values(?,?,?,?,?)");
        ps1.setInt(1,id);
        ps1.setInt(4,idContato );
        ps1.setString(2,nomeContato );
        ps1.setString(3, emailContato);
        PreparedStatement ps4 = this.connection.prepareStatement("select id_telefone from telefone where donoId=?");
        ResultSet num = ps4.executeQuery();
        
        while(num.next()) {
        	this.id=num.getInt("id_telefone");
        }
        ps1.setInt(5, this.id);
        ps1.close();
		}		
		else {
			PreparedStatement ps1 = this.connection.prepareStatement("insert (nomeContato,emailContato, dono_id, telefone_id) into contatos values(?,?,?,?)");
	        ps1.setString(1,nomeContato );
	        ps1.setString(2, emailContato);
	        PreparedStatement ps4 = this.connection.prepareStatement("select id_telefone from telefone where donoId=?");
	        ps4.setInt(3, idContato);
	        ResultSet num = ps4.executeQuery();
	        
	        while(num.next()) {
	        	this.id=num.getInt("id_telefone");
	        }
	        ps1.setInt(4, this.id);
	        ps1.close();    }
		
        
		p.close();
		this.connection.close();*/
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
	
	public int buscarIdDono(String email) throws Throwable {
		this.connection = new Conexao().getConexao();
		PreparedStatement ps = this.connection.prepareStatement("select id_dono from donotabela where email=?");
		ps.setString(1,email);
	    ResultSet result = ps.executeQuery();
	    while(result.next()) {
	    	this.id=result.getInt("id_dono");
	    }
		ps.close();
		this.connection.close();
		
		return this.id;
	}
}
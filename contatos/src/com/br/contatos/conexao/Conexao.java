package com.br.contatos.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Conexao() {
		
	}
	
public Connection getConexao() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3308/agendacontatos?useTimezone=true&serverTimezone=America/Sao_Paulo","root","");
			
		}catch(SQLException e) {
			throw new RuntimeException("Não foi possível conectar-se ao Banco de Dados",e);
		}
	}


}

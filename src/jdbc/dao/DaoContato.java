package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entidades.Contato;
import jdbc.interfaces.ICrud;
import jdbc.utilidades.Conexao;

public class DaoContato implements ICrud<Contato>{

	@Override
	public boolean salvar(Contato obj) {
		String sql = "insert into contato(nome, telefone, email)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			//fluxo da aplicação para o database
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,obj.getNome());
			stm.setString(2, obj.getTelefone());
			stm.setString(3, obj.getEmail());
			stm.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.desconectar();
		}
		return true;
	}

	@Override
	public boolean alterar(Contato obj) {
		String sql = "update contato set "
				+ "nome = ?,"
				+ "telefone = ?,"
				+ "email = ?"
				+ "where id = ?";
		Connection con = Conexao.conectar();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getTelefone());
			stm.setString(3, obj.getEmail());
			stm.setInt(4, obj.getId());
			stm.execute();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} 
		finally {
			Conexao.desconectar();
		}
		return false;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from contato where id= " + id;
		Connection con = Conexao.conectar();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			Conexao.desconectar();
		}
		
	}

	@Override
	public Contato consultar(int id) {
		Contato contato = new Contato();
		String sql = "select * from contato where id=" + id;
		Connection con = Conexao.conectar();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.desconectar();
		}
		return contato;
	}

	@Override
	public List<Contato> consultar() {
		List<Contato> contatos = new ArrayList<>();
		String sql = "select * from contato";
		Connection con = Conexao.conectar();
		try {
			// fluxo do database para a aplicação
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				contatos.add(contato);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.desconectar();
		}
		return contatos;
	}

}

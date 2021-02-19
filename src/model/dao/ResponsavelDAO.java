package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.AnimalVO;
import model.vo.ResponsavelVO;

public class ResponsavelDAO {
	private ConexaoDB conexao = null;

	public ResponsavelDAO() {
		conexao = new ConexaoDB();
	}

	public boolean inserir(ResponsavelVO responsavel) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"INSERT INTO Responsavel(nome, cpf, endereco, cidade, uf) VALUES ('%s', '%s', '%s', '%s', '%s')",
					responsavel.getNome(), responsavel.getCpf(), responsavel.getEndereco(), responsavel.getCidade(),
					responsavel.getUF());
			st.executeUpdate(sql);
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void atualizar(ResponsavelVO responsavel) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"UPDATE Responsavel SET nome='%s', cpf='%s, endereco='%s, cidade='%s, uf='%s' WHERE nome='%s'",
					responsavel.getNome(), responsavel.getCpf(), responsavel.getEndereco(), responsavel.getCidade(),
					responsavel.getUF(), responsavel.getNome());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(ResponsavelVO responsavel) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("DELETE FROM Responsavel WHERE cpf='%s'", responsavel.getCpf());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<ResponsavelVO> listarTodos() {
		try {
			ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();

			Connection con = conexao.getConection();
			PreparedStatement stm = con.prepareStatement("SELECT * FROM Responsavel");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ResponsavelVO res = new ResponsavelVO();

				res.setNome(rs.getString("nome"));
				res.setCpf(rs.getString("cpf"));
				res.setEndereco(rs.getString("endereco"));
				res.setCidade(rs.getString("cidade"));
				res.setUF(rs.getString("uf"));

				responsaveis.add(res);
			}
			rs.close();
			stm.close();
			con.close();

			return responsaveis;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ResponsavelVO listarPorCpf(ResponsavelVO responsavel) {
		try {
			Connection con = conexao.getConection();

			ResponsavelVO cliResp = new ResponsavelVO();

			String sql = String.format("SELECT * FROM Responsavel WHERE cpf='%s'", responsavel.getCpf());
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				cliResp.setNome(rs.getString("nome"));
				cliResp.setCpf(rs.getString("cpf"));
				cliResp.setEndereco(rs.getString("endereco"));
				cliResp.setCidade(rs.getString("cidade"));
				cliResp.setUF(rs.getString("uf"));

			}
			rs.close();
			stm.close();
			con.close();

			return cliResp;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

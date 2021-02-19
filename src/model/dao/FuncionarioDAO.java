package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.FuncionarioVO;

public class FuncionarioDAO {
	private ConexaoDB conexao = null;

	public FuncionarioDAO() {
		conexao = new ConexaoDB();
	}

	public void inserir(FuncionarioVO funcionario) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("INSERT INTO Funcionario(nome, area, cpf) VALUES ('%s', '%s', %s)",
					funcionario.getNome(), funcionario.getArea(), funcionario.getCpf());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(FuncionarioVO funcionario) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("UPDATE Funcionario SET nome='%s', area='%s', cpf='%d' WHERE nome='%s'",
					funcionario.getNome(), funcionario.getArea(), funcionario.getCpf(), funcionario.getNome());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(FuncionarioVO funcionario) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("DELETE FROM Funcionario WHERE nome='%s'", funcionario.getNome());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<FuncionarioVO> listarTodos() {
		try {
			ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();

			Connection con = conexao.getConection();
			PreparedStatement stm = con.prepareStatement("SELECT * FROM Funcionario");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				FuncionarioVO fun = new FuncionarioVO();

				fun.setNome(rs.getString("nome"));
				fun.setArea(rs.getString("area"));
				fun.setCpf(rs.getString("cpf"));

				funcionarios.add(fun);
			}
			rs.close();
			stm.close();
			con.close();

			return funcionarios;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

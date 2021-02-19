package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.AnimalVO;

public class AnimalDAO {
	private ConexaoDB conexao = null;

	public AnimalDAO() {
		conexao = new ConexaoDB();
	}

	public boolean inserir(AnimalVO animal) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"INSERT INTO Animal(nome, raca, idade, tipo, responsavelCpf) VALUES ('%s', '%s', %d, '%s', '%s')",
					animal.getNome(), animal.getRaca(), animal.getIdade(), animal.getTipo(),
					animal.getResponsavelCpf());
			st.executeUpdate(sql);
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void atualizar(AnimalVO animal) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("UPDATE Animal SET nome='%s', raca='%s', idade='%d', tipo='%s' WHERE nome='%s'",
					animal.getNome(), animal.getRaca(), animal.getIdade(), animal.getTipo(), animal.getNome());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(AnimalVO animal) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("DELETE FROM Animal WHERE responsavelCpf='%s'", animal.getResponsavelCpf());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<AnimalVO> listarTodos() {
		try {
			ArrayList<AnimalVO> animais = new ArrayList<AnimalVO>();

			Connection con = conexao.getConection();
			PreparedStatement stm = con.prepareStatement("SELECT * FROM Animal");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				AnimalVO ani = new AnimalVO();

				ani.setIdade(rs.getInt("id"));
				ani.setNome(rs.getString("nome"));
				ani.setRaca(rs.getString("raca"));
				ani.setIdade(rs.getInt("idade"));
				ani.setTipo(rs.getString("tipo"));

				animais.add(ani);
			}
			rs.close();
			stm.close();
			con.close();

			return animais;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public AnimalVO listarPorCpf(AnimalVO animal) {
		try {
			Connection con = conexao.getConection();

			AnimalVO aniResp = new AnimalVO();

			String sql = String.format("SELECT * FROM Animal WHERE responsavelCpf='%s'", animal.getResponsavelCpf());
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				aniResp.setIdade(rs.getInt("id"));
				aniResp.setNome(rs.getString("nome"));
				aniResp.setRaca(rs.getString("raca"));
				aniResp.setIdade(rs.getInt("idade"));
				aniResp.setTipo(rs.getString("tipo"));

			}
			rs.close();
			stm.close();
			con.close();

			return aniResp;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

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

	public void inserir(AnimalVO animal) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"INSERT INTO Animal(nome, raca, idade, tipo, responsavelid) VALUES ('%s', '%s', %d, '%s', %d)",
					animal.getNome(), animal.getRaca(), animal.getIdade(), animal.getTipo(), animal.getResponsavelId());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
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
			String sql = String.format("DELETE FROM Animal WHERE nome='%s'", animal.getNome());
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

}

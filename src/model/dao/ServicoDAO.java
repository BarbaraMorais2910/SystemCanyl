package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ServicoVO;

public class ServicoDAO {
	private ConexaoDB conexao = null;

	public ServicoDAO() {
		conexao = new ConexaoDB();
	}

	public void inserir(ServicoVO servico) {
		try {

			Connection con = conexao.getConection();

			// Statement st = (Statement) con.createStatement();
			// String sql = String.format(
			// "INSERT INTO Servico(tipo, dataInicio, dataFim, valor, responsavelCpf) "
			// + "VALUES ('%s', '%s', '%s', %f, '%s')",
			// servico.getTipo(), servico.getDataInicio(), servico.getDataFim(),
			// servico.getValor(),
			// servico.getResponsavelCpf());
			// st.executeUpdate(sql);

			String sql = "INSERT INTO Servico(tipo, dataInicio, dataFim, valor, responsavelCpf) VALUES(?,?,?,?,?)";
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, servico.getTipo());
			prest.setDate(2, new java.sql.Date(servico.getDataInicio().getTime()));
			prest.setDate(3, new java.sql.Date(servico.getDataFim().getTime()));
			prest.setDouble(4, servico.getValor());
			prest.setString(5, servico.getResponsavelCpf());
			prest.executeUpdate();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(ServicoVO servico) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"UPDATE Servico SET tipo='%s', dataInicio='%s', dataFim='%s', valor=%f, responsavelCpf='%s'"
							+ " WHERE responsavelCpf='%s'",
					servico.getTipo(), servico.getDataInicio(), servico.getDataFim(), servico.getValor(),
					servico.getResponsavelCpf(), servico.getResponsavelCpf());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(ServicoVO servico) {
		try {

			Connection con = conexao.getConection();
			Statement st = (Statement) con.createStatement();
			String sql = String.format("DELETE FROM Servico WHERE responsavelCpf='%s'", servico.getResponsavelCpf());
			st.executeUpdate(sql);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<ServicoVO> listarTodos() {
		try {
			ArrayList<ServicoVO> servicos = new ArrayList<ServicoVO>();

			Connection con = conexao.getConection();
			PreparedStatement stm = con.prepareStatement("SELECT * FROM Servico");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ServicoVO ser = new ServicoVO();

				ser.setTipo(rs.getString("tipo"));
				ser.setDataInicio(rs.getDate("dataInicio"));
				ser.setDataFim(rs.getDate("dataFim"));
				ser.setResponsavelCpf(rs.getString("responsavelCpf"));

				servicos.add(ser);
			}
			rs.close();
			stm.close();
			con.close();

			return servicos;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ServicoVO> listarPorCpf(ServicoVO servico) {
		try {
			ArrayList<ServicoVO> servicos = new ArrayList<ServicoVO>();

			Connection con = conexao.getConection();

			String sql = String.format("SELECT * FROM Servico WHERE responsavelCpf='%s'", servico.getResponsavelCpf());
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ServicoVO ser = new ServicoVO();

				ser.setId(rs.getInt("id"));
				ser.setTipo(rs.getString("tipo"));
				ser.setValor(rs.getDouble("valor"));
				ser.setDataInicio(rs.getDate("dataInicio"));
				ser.setDataFim(rs.getDate("dataFim"));
				ser.setResponsavelCpf(rs.getString("responsavelCpf"));

				servicos.add(ser);
			}
			rs.close();
			stm.close();
			con.close();

			return servicos;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

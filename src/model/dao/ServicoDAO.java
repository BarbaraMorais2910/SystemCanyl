package model.dao;

import java.sql.Connection;
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
			Statement st = (Statement) con.createStatement();
			String sql = String.format(
					"INSERT INTO Servico(codigo, nome, tipo, valor, responsavelCpf, funcionarioCpf, dataInicio, dataFim) "
							+ "VALUES (%d, '%s', %s, %f, '%s', '%s', %s, '%s')",
					servico.getCodigo(), servico.getNome(), servico.getTipo(), servico.getValor(),
					servico.getResponsavelCpf(), servico.getFuncionarioCpf(), servico.getDataInicio(),
					servico.getDataFim());
			st.executeUpdate(sql);
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
					"UPDATE Servico SET codigo=%d, nome='%s', tipo='%s', valor='%s', responsavelCpf='%s', "
							+ "funcionarioCpf='%s', dataInicio='%s', dataFim='%s' WHERE codigo=%d",
					servico.getCodigo(), servico.getNome(), servico.getTipo(), servico.getValor(),
					servico.getResponsavelCpf(), servico.getFuncionarioCpf(), servico.getDataInicio(),
					servico.getDataFim(), servico.getCodigo());
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
			String sql = String.format("DELETE FROM Servico WHERE codigo=%d", servico.getCodigo());
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

				ser.setCodigo(rs.getInt("codigo"));
				ser.setNome(rs.getString("nome"));
				ser.setTipo(rs.getString("tipo"));
				ser.setValor(rs.getDouble("valor"));
				ser.setResponsavelCpf(rs.getString("responsavelCpf"));
				ser.setFuncionarioCpf(rs.getString("funcionarioCpf"));
				ser.setDataInicio(rs.getDate("dataInicio"));
				ser.setDataFim(rs.getDate("dataFim"));

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

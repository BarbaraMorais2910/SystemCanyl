package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.dao.RelatorioDAO;
import model.dao.ServicoDAO;
import model.vo.AnimalVO;
import model.vo.ResponsavelVO;
import model.vo.ServicoVO;

public class RelatorioControle {
	private ServicoDAO serDAO;
	private RelatorioDAO relaDAO;

	public RelatorioControle() {
		serDAO = new ServicoDAO();
		relaDAO = new RelatorioDAO();
	}

	public void gerarRelatorio() {
		try {
			relaDAO.gerar("relatorios/relatorio.jrxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adicionarServico() {
		System.out.println("Serviço adicionado!");
	}

	public void encherTabela(DefaultTableModel tabelaModelo) {

		ArrayList<ServicoVO> servicos = new ArrayList<ServicoVO>();

		try {
			servicos = (ArrayList<ServicoVO>) serDAO.listarTodos();
		} catch (Exception e) {
		}

		for (ServicoVO ser : servicos) {
			tabelaModelo.addRow(new Object[] { ser.getResponsavelCpf(), ser.getTipo(), ser.getValor(),
					ser.getDataInicio(), ser.getDataFim(), });

		}

	}

	public void limparTabela(DefaultTableModel tabelaModelo) {
		for (int i = tabelaModelo.getRowCount() - 1; i >= 0; i--) {
			tabelaModelo.removeRow(i);
		}
	}

}

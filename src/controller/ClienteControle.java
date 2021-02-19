package controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.AnimalDAO;
import model.dao.ResponsavelDAO;
import model.dao.ServicoDAO;
import model.vo.AnimalVO;
import model.vo.ResponsavelVO;
import model.vo.ServicoVO;

public class ClienteControle {
	private ResponsavelDAO respDAO;
	private AnimalDAO aniDAO;
	private ServicoDAO serDAO;

	public ClienteControle() {
		respDAO = new ResponsavelDAO();
		aniDAO = new AnimalDAO();
		serDAO = new ServicoDAO();
	}
	
	public boolean salvarClienteAnimal(String nomeCliente, String cpf, String endereco, String cidade, String uF,
			String nomeAnimal, String raca, int idade, String tipo) {

		ResponsavelVO respVO = new ResponsavelVO(nomeCliente, cpf, endereco, cidade, uF);
		AnimalVO aniVO = new AnimalVO(nomeAnimal, raca, idade, tipo, cpf);

		boolean statusResp = respDAO.inserir(respVO);
		boolean statusAni = aniDAO.inserir(aniVO);

		return (statusResp && statusAni);
	}

	public void encherTabela(DefaultTableModel tabelaModelo) {

		ArrayList<ResponsavelVO> responsaveis = new ArrayList<ResponsavelVO>();

		try {
			responsaveis = (ArrayList<ResponsavelVO>) respDAO.listarTodos();
		} catch (Exception e) {
		}

		for (int i = 0; i < responsaveis.size(); i++) {

			String nomeResp = responsaveis.get(i).getNome();
			String cpfResp = responsaveis.get(i).getCpf();

			AnimalVO aniVO = new AnimalVO();
			aniVO.setResponsavelCpf(cpfResp);

			AnimalVO resp = aniDAO.listarPorCpf(aniVO);

			tabelaModelo.addRow(new Object[] { nomeResp, cpfResp, resp.getNome(), resp.getTipo(), });

		}
	}

	public void limparTabela(DefaultTableModel tabelaModelo) {
		for (int i = tabelaModelo.getRowCount() - 1; i >= 0; i--) {
			tabelaModelo.removeRow(i);
		}
	}

	public void excluirCliente(JTable tabela, DefaultTableModel tabelaModelo) {
		int idLinha = tabela.getSelectedRow();
		String cpfSele = (String) tabelaModelo.getValueAt(idLinha, 1);

		AnimalVO animal = new AnimalVO();
		animal.setResponsavelCpf(cpfSele);
		aniDAO.excluir(animal);

		ServicoVO servico = new ServicoVO();
		servico.setResponsavelCpf(cpfSele);
		serDAO.excluir(servico);

		ResponsavelVO responsavel = new ResponsavelVO();
		responsavel.setCpf(cpfSele);
		respDAO.excluir(responsavel);

		System.out.println("Exclusao efetuada");

		limparTabela(tabelaModelo);
		encherTabela(tabelaModelo);
	}

	public ResponsavelVO getClientePorCpf(JTable tabela, DefaultTableModel tabelaModelo) {
		int idLinha = tabela.getSelectedRow();
		String cpfSele = (String) tabelaModelo.getValueAt(idLinha, 1);

		ResponsavelVO responsavel = new ResponsavelVO();
		responsavel.setCpf(cpfSele);
		ResponsavelVO responsavelResp = respDAO.listarPorCpf(responsavel);

		return responsavelResp;
	}

	public AnimalVO getAnimalPorCpf(JTable tabela, DefaultTableModel tabelaModelo) {
		int idLinha = tabela.getSelectedRow();
		String cpfSele = (String) tabelaModelo.getValueAt(idLinha, 1);

		AnimalVO animal = new AnimalVO();
		animal.setResponsavelCpf(cpfSele);
		AnimalVO animalResp = aniDAO.listarPorCpf(animal);

		return animalResp;
	}

	public boolean buscarClienteTabela(DefaultTableModel tabelaModelo, String textBuscaCpf) {

		ResponsavelVO responsavel = new ResponsavelVO();
		responsavel.setCpf(textBuscaCpf);

		AnimalVO animal = new AnimalVO();
		animal.setResponsavelCpf(textBuscaCpf);

		ResponsavelVO resResp = respDAO.listarPorCpf(responsavel);
		AnimalVO aniResp = aniDAO.listarPorCpf(animal);

		if (resResp.getNome() == null) {
			return false;
		} else {
			limparTabela(tabelaModelo);
			tabelaModelo.addRow(
					new Object[] { resResp.getNome(), resResp.getCpf(), aniResp.getNome(), aniResp.getTipo(), });

			return true;
		}
	}

}

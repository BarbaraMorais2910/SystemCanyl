package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controller.ClienteControle;
import controller.ServicoControle;
import model.dao.ServicoDAO;
import model.vo.AnimalVO;
import model.vo.ResponsavelVO;
import model.vo.ServicoVO;

public class PainelServicos extends JPanel implements ActionListener {
	private ClienteControle clienteControle;
	private ServicoControle servicoControle;
	private JTable tabelaCliente, tabelaServico;
	private DefaultTableModel tabelaClienteModelo, tabelaServicoModelo;

	private JScrollPane jScrollPane_IL;

	private JLabel labelTipo, labelDataInicio, labelDataFim, labelTotal;
	private JComboBox tipoServico;
	private DefaultComboBoxModel tipoServicoModel;

	private JDateChooser dataInicio, dataFim;

	private JButton butaoAdicionar, butaoExcluir, butaoSalvar;

	private JPanel painelBuscas, painelAdicionarServico;
	private static int larguraText = 30;

	private ArrayList<ServicoVO> servicos = new ArrayList<ServicoVO>();

	public PainelServicos() {
		// this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Serviços", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 128)));

		this.setLayout(null);

		clienteControle = new ClienteControle();
		servicoControle = new ServicoControle();

		montaPainelSelecao();
		montaPainelAdicionarServico();

		updateTabelCliente();
	}

	public void updateTabelCliente() {
		clienteControle.limparTabela(tabelaClienteModelo);
		clienteControle.encherTabela(tabelaClienteModelo);
	}

	public void montaPainelSelecao() {
		painelBuscas = new JPanel();

		painelBuscas.setBorder(BorderFactory.createTitledBorder(null, "Selecionar Cliente", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 128)));
		painelBuscas.setLayout(null);
		painelBuscas.setBounds(10, 30, 700, 290);
		this.add(painelBuscas);

		JLabel buscaNome = new JLabel("Nome:");
		buscaNome.setBounds(160, 15, 80, larguraText);
		painelBuscas.add(buscaNome);

		JTextField textBusca = new JTextField();
		textBusca.setBounds(250, 20, 300, larguraText);
		painelBuscas.add(textBusca);

		// tabela------

		tabelaCliente = new JTable();
		tabelaClienteModelo = new DefaultTableModel(new String[][] {},
				new String[] { "Cliente", "CPF", "Nome animal", "Tipo" });
		tabelaCliente.setModel(tabelaClienteModelo);

		tabelaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scPanel = new JScrollPane(tabelaCliente);
		scPanel.setBounds(10, 60, 680, 220);
		painelBuscas.add(scPanel);

		acaoTabelaCliente();

	}

	public void acaoTabelaCliente() {

		ServicoDAO serDAO = new ServicoDAO();
		ServicoVO ser = new ServicoVO();

		tabelaCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {

				if (tabelaCliente.getSelectedRow() > -1) {
					// print first column value from selected row
					// System.out.println(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(),
					// 0).toString());

					int clienteSelecionada = tabelaCliente.getSelectedRow();
					String cpfCliente = (String) tabelaClienteModelo.getValueAt(clienteSelecionada, 1);
					// System.out.println(cpfCliente);
					// System.out.println("oi");

					ser.setResponsavelCpf(cpfCliente);
					servicos = serDAO.listarPorCpf(ser);

					limparTabela();
					encherTabela();
					updateTotal();
				}

			}
		});
	}

	public void encherTabela() {

		for (int i = 0; i < servicos.size(); i++) {

			String tipo = servicos.get(i).getTipo();
			double valor = servicos.get(i).getValor();

			// System.out.println(valor);
			tabelaServicoModelo.addRow(new Object[] { tipo, valor, });

		}
	}

	public void limparTabela() {
		for (int i = tabelaServicoModelo.getRowCount() - 1; i >= 0; i--) {
			tabelaServicoModelo.removeRow(i);
		}
	}

	public void montaPainelAdicionarServico() {
		painelAdicionarServico = new JPanel();

		painelAdicionarServico.setBorder(BorderFactory.createTitledBorder(null, "Adicionar Serviço",
				TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14),
				new java.awt.Color(0, 0, 128)));
		painelAdicionarServico.setLayout(null);
		painelAdicionarServico.setBounds(10, 325, 700, 305);
		this.add(painelAdicionarServico);

		// tipo servico
		labelTipo = new JLabel("Escolha o Tipo:");
		labelTipo.setBounds(10, 30, 150, larguraText);
		painelAdicionarServico.add(labelTipo);

		tipoServicoModel = new DefaultComboBoxModel(new String[] { "Adestramento", "Hospedagem", "Locação" });
		tipoServico = new JComboBox();
		painelAdicionarServico.add(tipoServico);
		tipoServico.setModel(tipoServicoModel);
		tipoServico.setBounds(10, 60, 150, larguraText);

		// datas do servico
		labelDataInicio = new JLabel("Data inicio:");
		labelDataInicio.setBounds(10, 100, 150, larguraText);
		painelAdicionarServico.add(labelDataInicio);

		dataInicio = new JDateChooser();
		dataInicio.setDate(new Date());
		dataInicio.setBounds(10, 130, 150, larguraText);
		painelAdicionarServico.add(dataInicio);

		labelDataFim = new JLabel("Data final:");
		labelDataFim.setBounds(10, 160, 150, larguraText);
		painelAdicionarServico.add(labelDataFim);

		dataFim = new JDateChooser();
		dataFim.setDate(new Date());
		dataFim.setBounds(10, 190, 150, larguraText);
		painelAdicionarServico.add(dataFim);

		// adcionar servico
		butaoAdicionar = new JButton("Adicionar >>>");
		butaoAdicionar.setBounds(10, 240, 150, larguraText + 20);
		butaoAdicionar.addActionListener(this);
		painelAdicionarServico.add(butaoAdicionar);

		// separar
		JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
		separator1.setBounds(170, 9, 10, 293);
		painelAdicionarServico.add(separator1);

		// tabela------

		tabelaServico = new JTable();
		tabelaServicoModelo = new DefaultTableModel(new String[][] {}, new String[] { "Serviço", "valor" });
		tabelaServico.setModel(tabelaServicoModelo);

		tabelaServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scPanel = new JScrollPane(tabelaServico);
		scPanel.setBounds(180, 20, 510, 200);
		painelAdicionarServico.add(scPanel);

		// separar
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(170, 230, 527, 20);
		painelAdicionarServico.add(separator2);

		// total
		labelTotal = new JLabel("Total: 0.0");
		labelTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelTotal.setBounds(190, 250, 180, larguraText);
		painelAdicionarServico.add(labelTotal);

		// total
		butaoExcluir = new JButton("Excluir");
		butaoExcluir.setBounds(380, 240, 150, larguraText + 20);
		butaoExcluir.addActionListener(this);
		painelAdicionarServico.add(butaoExcluir);

		butaoSalvar = new JButton("Salvar");
		// butaoSalvar.setFont(new Font("Tahoma", Font.BOLD, 22));
		butaoSalvar.setBounds(540, 240, 150, larguraText + 20);
		butaoSalvar.addActionListener(this);
		painelAdicionarServico.add(butaoSalvar);

	}

	public void updateTotal() {
		double total = 0;
		for (ServicoVO servico : servicos) {
			total += servico.getValor();
		}

		labelTotal.setText(String.format("Total: %.2f", total));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (butaoAdicionar == e.getSource()) {
			int clienteSelecionada = tabelaCliente.getSelectedRow();
			if (clienteSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente para adicionar o serviço!");
			} else {

				servicoControle.adicionarServico();

				String tipo = tipoServico.getSelectedItem().toString();

				ServicoVO servico = new ServicoVO(tipo, dataInicio.getDate(), dataFim.getDate(), "");

				servicos.add(servico);

				// System.out.println();
				tabelaServicoModelo.addRow(new Object[] { servico.getTipo(), servico.getValor(), });

				updateTotal();
			}
		}

		else if (butaoExcluir == e.getSource()) {
			int idLinha = tabelaServico.getSelectedRow();
			System.out.println(idLinha);
			// System.out.println(tabelaModeloServico.getValueAt(idLinha, 1));
			// int idSele = (Integer) tabelaModeloServico.getValueAt(linhaSelecionada, 1);

			servicos.remove(idLinha);

			tabelaServicoModelo.removeRow(idLinha);
			updateTotal();

			// for (ServicoVO servicoVO : servicos) {
			// System.out.println(servicoVO.getTipo());
			// }
		}

		else if (butaoSalvar == e.getSource()) {
			int clienteSelecionada = tabelaCliente.getSelectedRow();
			int servicoConta = tabelaServico.getRowCount();

			if (clienteSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente para adicionar o serviço!");
			} else if (servicoConta <= 0) {
				JOptionPane.showMessageDialog(null, "Adicione pelo menos um serviço!");
			} else {

				String cpfCliente = (String) tabelaClienteModelo.getValueAt(clienteSelecionada, 1);

				ServicoDAO serDAO = new ServicoDAO();

				try {
					ServicoVO serEx = new ServicoVO();
					serEx.setResponsavelCpf(cpfCliente);
					serDAO.excluir(serEx);

				} catch (Exception e2) {
					// TODO: handle exception
				}

				// System.out.println(cpfCliente);
				for (ServicoVO ser : servicos) {

					ser.setResponsavelCpf(cpfCliente);
					System.out.println(String.format("CPF:%s Tipo:%s Incio:%s Fim:%s", ser.getResponsavelCpf(),
							ser.getTipo(), ser.getDataInicio(), ser.getDataFim()));

					serDAO.inserir(ser);
				}
				JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
			}

		}

	}

}

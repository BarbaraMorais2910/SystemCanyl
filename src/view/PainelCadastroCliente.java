package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteControle;
import model.vo.AnimalVO;
import model.vo.ResponsavelVO;

public class PainelCadastroCliente extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClienteControle clienteControle;

	private JButton butaoSalvar, butaoAbrir, butaoExcluir, butaoLimpar, botaoBuscaCpf;

	private JTable tabela;
	private DefaultTableModel tabelaModelo;

	private JLabel labelNome, labelCpf, labelEndereco, labelCidade, labelUf;
	private JTextField textNome, textCpf, textEndereco, textCidade, textUf;
	private JSeparator jSeparator;

	private JLabel labelNomeAnimal, labelRacaAnimal, labelIdadeAnimal, labelTipoAnimal;
	private JTextField textNomeAnimal, textRacaAnimal, textIdadeAnimal;
	private ComboBoxModel<String> tipoAnimalModel;
	private JComboBox<String> tipoAnimal;
	private static int larguraText = 30;

	private JTextField textBuscaCpf;

	private JPanel painelBuscas;

	public PainelCadastroCliente() {
		// this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Cadastro de Clientes", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 128)));
		this.setLayout(null);

		clienteControle = new ClienteControle();

		montaFormularioCliente();
		montaFormularioAnimal();
		montaPainelBusca();

		updateTabela();
	}

	public void updateTabela() {
		clienteControle.limparTabela(tabelaModelo);
		clienteControle.encherTabela(tabelaModelo);
	}

	public void montaFormularioCliente() {
		// nome
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 30, 80, larguraText);
		this.add(labelNome);

		textNome = new JTextField();
		textNome.setBounds(90, 30, 550, larguraText);
		this.add(textNome);

		// cpf
		labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(10, 50 + 30, 80, larguraText);
		this.add(labelCpf);

		textCpf = new JTextField();
		textCpf.setBounds(90, 50 + 30, 210, larguraText);
		this.add(textCpf);

		// cidade
		labelCidade = new JLabel("Cidade:");
		labelCidade.setBounds(320, 50 + 30, 80, larguraText);
		this.add(labelCidade);

		textCidade = new JTextField();
		textCidade.setBounds(400, 50 + 30, 240, larguraText);
		this.add(textCidade);

		// endereco
		labelEndereco = new JLabel("Endereço:");
		labelEndereco.setBounds(10, 100 + 30, 100, larguraText);
		this.add(labelEndereco);

		textEndereco = new JTextField();
		textEndereco.setBounds(90, 100 + 30, 300, larguraText);
		this.add(textEndereco);

		// uf
		labelUf = new JLabel("UF:");
		labelUf.setBounds(410, 100 + 30, 70, larguraText);
		this.add(labelUf);

		textUf = new JTextField();
		textUf.setBounds(450, 100 + 30, 190, larguraText);
		this.add(textUf);

		jSeparator = new JSeparator();
		jSeparator.setBounds(3, 176, 715, 10);
		this.add(jSeparator);

	}

	public void montaFormularioAnimal() {
		// formulario animal
		// nome
		labelNomeAnimal = new JLabel("Nome do animal:");
		labelNomeAnimal.setBounds(10, 200, 120, larguraText);
		this.add(labelNomeAnimal);

		textNomeAnimal = new JTextField();
		textNomeAnimal.setBounds(150, 200, 280, larguraText);
		this.add(textNomeAnimal);

		// raca
		labelRacaAnimal = new JLabel("Raça do animal:");
		labelRacaAnimal.setBounds(10, 200 + 50, 120, larguraText);
		this.add(labelRacaAnimal);

		textRacaAnimal = new JTextField();
		textRacaAnimal.setBounds(150, 200 + 50, 280, larguraText);
		this.add(textRacaAnimal);

		// idade
		labelIdadeAnimal = new JLabel("Idade do animal:");
		labelIdadeAnimal.setBounds(450, 200, 120, larguraText);
		this.add(labelIdadeAnimal);

		textIdadeAnimal = new JTextField();
		textIdadeAnimal.setBounds(580, 200, 80, larguraText);
		this.add(textIdadeAnimal);

		// tipo
		labelTipoAnimal = new JLabel("Tipo:");
		labelTipoAnimal.setBounds(450, 200 + 50, 120, larguraText);
		this.add(labelTipoAnimal);

		tipoAnimalModel = new DefaultComboBoxModel(new String[] { "Cachorro", "Gato" });
		tipoAnimal = new JComboBox();
		this.add(tipoAnimal);
		tipoAnimal.setModel(tipoAnimalModel);
		tipoAnimal.setBounds(530, 200 + 50, 130, 22);

	}

	public void montaPainelBusca() {
		painelBuscas = new JPanel();

		painelBuscas.setBorder(BorderFactory.createTitledBorder(null, "Gerenciamento de Clientes", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 128)));
		painelBuscas.setLayout(null);
		painelBuscas.setBounds(10, 300, 700, 330);
		this.add(painelBuscas);

		JLabel buscaCpf = new JLabel("CPF:");
		buscaCpf.setBounds(100, 15, 80, larguraText);
		painelBuscas.add(buscaCpf);

		textBuscaCpf = new JTextField();
		textBuscaCpf.setBounds(150, 20, 300, larguraText);
		painelBuscas.add(textBuscaCpf);

		botaoBuscaCpf = new JButton("Buscar");
		botaoBuscaCpf.setBounds(460, 20, 130, larguraText);
		botaoBuscaCpf.addActionListener(this);
		painelBuscas.add(botaoBuscaCpf);

		// tabela------

		tabela = new JTable();
		tabelaModelo = new DefaultTableModel(new String[][] {},
				new String[] { "Cliente", "CPF", "Nome animal", "Tipo" });
		tabela.setModel(tabelaModelo);

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scPanel = new JScrollPane(tabela);
		scPanel.setBounds(10, 60, 680, 220);
		painelBuscas.add(scPanel);

		int localBt = 140;

		butaoSalvar = new JButton("Salvar Novo");
		butaoSalvar.setBounds(localBt, 285, 130, 35);
		butaoSalvar.addActionListener(this);
		painelBuscas.add(butaoSalvar);

		butaoAbrir = new JButton("Abrir");
		butaoAbrir.setBounds(localBt + 140, 285, 130, 35);
		butaoAbrir.addActionListener(this);
		painelBuscas.add(butaoAbrir);

		butaoExcluir = new JButton("Excluir");
		butaoExcluir.setBounds(localBt + 280, 285, 130, 35);
		butaoExcluir.addActionListener(this);
		painelBuscas.add(butaoExcluir);

		butaoLimpar = new JButton("Limpar");
		butaoLimpar.setBounds(localBt + 420, 285, 130, 35);
		butaoLimpar.addActionListener(this);
		painelBuscas.add(butaoLimpar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (butaoSalvar == e.getSource()) {
			String tipo = tipoAnimal.getSelectedItem().toString();
			boolean status = clienteControle.salvarClienteAnimal(textNome.getText(), textCpf.getText(),
					textEndereco.getText(), textCidade.getText(), textUf.getText(), textNomeAnimal.getText(),
					textRacaAnimal.getText(), Integer.parseInt(textIdadeAnimal.getText()), tipo);

			if (status == false) {
				JOptionPane.showMessageDialog(null,
						String.format("Verifique se cliente com CPF %s já está cadastrado!", textCpf.getText()));
			} else {
				clienteControle.limparTabela(tabelaModelo);
				clienteControle.encherTabela(tabelaModelo);
			}

		}

		else if (butaoExcluir == e.getSource()) {

			int clienteSelecionada = tabela.getSelectedRow();
			if (clienteSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir!");
			} else {
				clienteControle.excluirCliente(tabela, tabelaModelo);
			}

		} else if (butaoLimpar == e.getSource()) {
			textNome.setText("");
			textCpf.setText("");
			textEndereco.setText("");
			textCidade.setText("");
			textUf.setText("");
			textNomeAnimal.setText("");
			textRacaAnimal.setText("");
			textIdadeAnimal.setText("");
		}

		else if (butaoAbrir == e.getSource()) {
			int clienteSelecionada = tabela.getSelectedRow();
			if (clienteSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente ver todos os dados!");
			} else {
				AnimalVO ani = clienteControle.getAnimalPorCpf(tabela, tabelaModelo);
				ResponsavelVO resp = clienteControle.getClientePorCpf(tabela, tabelaModelo);

				textNome.setText(resp.getNome());
				textCpf.setText(resp.getCpf());
				textEndereco.setText(resp.getEndereco());
				textCidade.setText(resp.getCidade());
				textUf.setText(resp.getUF());
				textNomeAnimal.setText(ani.getNome());
				textRacaAnimal.setText(ani.getRaca());
				textIdadeAnimal.setText(String.format("%d", ani.getIdade()));

				tipoAnimalModel.setSelectedItem(ani.getTipo());
			}
		}

		else if (botaoBuscaCpf == e.getSource()) {

			String cpfParaBuscar = textBuscaCpf.getText();
			if (cpfParaBuscar.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite um CPF para ser buscado!");
			} else {
				boolean status = clienteControle.buscarClienteTabela(tabelaModelo, cpfParaBuscar);

				if (status == false) {
					JOptionPane.showMessageDialog(null,
							String.format("O cliente com CPF %s não foi encontrado!", cpfParaBuscar));
				}

			}
		}

	}
}
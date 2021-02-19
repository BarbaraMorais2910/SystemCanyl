package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import controller.ClienteControle;
import controller.RelatorioControle;

public class PainelRelatorio extends JPanel {

	private JTable tabela;
	private DefaultTableModel tabelaModelo;
	private JScrollPane jScrollPane_IL;
	private JButton butaoBaixar;
	private RelatorioControle relatorioControle;
	private SimpleDateFormat dat;

	public PainelRelatorio() {
		// this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Relatórios", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 128)));

		this.setLayout(null);

		relatorioControle = new RelatorioControle();

		JLabel labelServicos = new JLabel("Histórico de serviços prestados aos clientes");
		labelServicos.setFont(new java.awt.Font("Tahoma", 1, 16));
		labelServicos.setBounds(100, 10, 400, 60);
		this.add(labelServicos);

		montaTabelaRelatorio();
		montaFuncoes();

		updateTabela();
	}

	public void updateTabela() {
		relatorioControle.limparTabela(tabelaModelo);
		relatorioControle.encherTabela(tabelaModelo);
	}

	public void montaTabelaRelatorio() {
		tabela = new JTable();
		tabelaModelo = new DefaultTableModel(new String[][] {},
				new String[] { " CPF", "Tipo", "Valor", "Data Inicio", "Data Fim" });
		tabela.setModel(tabelaModelo);

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scPanel = new JScrollPane(tabela);
		scPanel.setBounds(10, 70, 700, 500);
		this.add(scPanel);
	}

	public void montaFuncoes() {

		JSeparator jSeparator = new JSeparator();
		jSeparator.setBounds(3, 580, 715, 10);
		this.add(jSeparator);

		butaoBaixar = new JButton("Baixar");
		butaoBaixar.setBounds(580, 590, 130, 35);
		butaoBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportarRelatorio();
			}
		});
		this.add(butaoBaixar);

	}

	public void exportarRelatorio() {
		relatorioControle.gerarRelatorio();
	}

}

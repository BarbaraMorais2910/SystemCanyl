package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PainelBotoes extends JPanel {
	private JButton butaoCadastro;
	private JButton butaoServicos;
	private JButton butaoRelatorio;

	private ImageIcon imgCadastro, imgServico, imgRelatorio;
	private ImageIcon imgCadastroFoco, imgServicoFoco, imgRelatorioFoco;

	public PainelBotoes(JPanel painelCadastro, PainelServicos painelServicos, JPanel painelRelatorio) {
		// this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder(null, "Funções", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 128)));

		imgCadastro = new ImageIcon("imgs/imgCadastro.png");
		imgCadastroFoco = new ImageIcon("imgs/imgCadastroFoco.png");
		butaoCadastro = new JButton(imgCadastroFoco);
		butaoCadastro.setOpaque(false);
		butaoCadastro.setContentAreaFilled(false);
		butaoCadastro.setBorderPainted(false);
		// butaoCadastro.setFont(new Font("Tahoma", Font.BOLD, 28));
		butaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastro.setVisible(true);
				painelServicos.setVisible(false);
				painelRelatorio.setVisible(false);

				butaoCadastro.setIcon(imgCadastroFoco);
				butaoServicos.setIcon(imgServico);
				butaoRelatorio.setIcon(imgRelatorio);
			}
		});
		butaoCadastro.setBounds(10, 40, 180, 50);
		this.add(butaoCadastro);

		imgServico = new ImageIcon("imgs/imgServico.png");
		imgServicoFoco = new ImageIcon("imgs/imgServicoFoco.png");
		butaoServicos = new JButton(imgServico);
		butaoServicos.setOpaque(false);
		butaoServicos.setContentAreaFilled(false);
		butaoServicos.setBorderPainted(false);
		// butaoServicos.setFont(new Font("Tahoma", Font.BOLD, 28));
		butaoServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastro.setVisible(false);
				painelRelatorio.setVisible(false);
				painelServicos.setVisible(true);

				butaoCadastro.setIcon(imgCadastro);
				butaoServicos.setIcon(imgServicoFoco);
				butaoRelatorio.setIcon(imgRelatorio);

				painelServicos.updateTabelCliente();
			}
		});
		butaoServicos.setBounds(10, 100, 180, 50);
		this.add(butaoServicos);

		imgRelatorio = new ImageIcon("imgs/imgRelatorio.png");
		imgRelatorioFoco = new ImageIcon("imgs/imgRelatorioFoco.png");
		butaoRelatorio = new JButton(imgRelatorio);
		butaoRelatorio.setOpaque(false);
		butaoRelatorio.setContentAreaFilled(false);
		butaoRelatorio.setBorderPainted(false);
		butaoRelatorio.setFont(new Font("Tahoma", Font.BOLD, 28));
		butaoRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastro.setVisible(false);
				painelServicos.setVisible(false);
				painelRelatorio.setVisible(true);

				butaoCadastro.setIcon(imgCadastro);
				butaoServicos.setIcon(imgServico);
				butaoRelatorio.setIcon(imgRelatorioFoco);

			}
		});
		butaoRelatorio.setBounds(10, 160, 180, 50);
		this.add(butaoRelatorio);

	}
}

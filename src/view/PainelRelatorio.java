package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PainelRelatorio extends JPanel {

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane jScrollPane_IL;

	public PainelRelatorio() {
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Relatórios", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 128)));

		this.setLayout(null);



	}
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainAplicacao extends JFrame {

	/// com.sun.java.swing.plaf.gtk.GTKLookAndFeel
	// com.sun.java.swing.plaf.motif.MotifLookAndFeel
	// com.sun.java.swing.plaf.windows.WindowsLookAndFeel

	/*
	 * { // Set Look & Feel try { javax.swing.UIManager.setLookAndFeel(
	 * "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	 * //javax.swing.UIManager.setLookAndFeel(
	 * "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	private JPanel painelBotoes, painelCadastro, painelRelatorio;
	private PainelServicos painelServicos;

	public MainAplicacao() {
		super("Sistema de gerenciamento de PetShop");
		setLayout(null);

		painelCadastro = new PainelCadastroCliente();
		painelCadastro.setBounds(220, 10, 720, 640);
		this.add(painelCadastro);

		painelServicos = new PainelServicos();
		painelServicos.setBounds(220, 10, 720, 640);
		this.add(painelServicos);

		painelRelatorio = new PainelRelatorio();
		painelRelatorio.setBounds(220, 10, 720, 640);
		this.add(painelRelatorio);

		painelBotoes = new PainelBotoes(painelCadastro, painelServicos, painelRelatorio);
		painelBotoes.setBounds(10, 10, 200, 640);
		this.add(painelBotoes);

		painelServicos.setVisible(false);
		painelRelatorio.setVisible(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(950, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new MainAplicacao();
	}

}

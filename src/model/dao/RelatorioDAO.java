package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDAO {
	private ConexaoDB conexao;

	public RelatorioDAO() {
		conexao = new ConexaoDB();
	}

	public void gerar(String layout) throws JRException, ClassNotFoundException, SQLException {

		JasperDesign desenho = JRXmlLoader.load(layout);
		JasperReport relatorio = JasperCompileManager.compileReport(desenho);

		Connection con = conexao.getConection();
		PreparedStatement stm = con.prepareStatement("SELECT * FROM Servico");
		ResultSet rs = stm.executeQuery();

		JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

		Map parametros = new HashMap();
		JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

		// exibe o resultado
		JasperViewer viewer = new JasperViewer(impressao, true);
		viewer.show();

		// File file = new File("/home/user/Documentos/");
		// file.mkdirs();
		// JasperExportManager.exportReportToPdfFile(impressao,
		// file.getAbsolutePath() + "reportName.pdf");
	}
}

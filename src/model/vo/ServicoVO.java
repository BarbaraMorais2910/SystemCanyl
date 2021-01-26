package model.vo;

import java.util.Date;

public class ServicoVO {
	private int Id;
	private String tipo;
	private double valor;
	private String responsavelCpf;
	// private String funcionarioCpf;
	private Date dataInicio;
	private Date dataFim;

	public ServicoVO() {
		// TODO Auto-generated constructor stub
	}

	public ServicoVO(String tipo, Date dataInicio, Date dataFim, String responsavelCpf) {
		super();
		this.tipo = tipo;
		this.valor = 0;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.responsavelCpf = responsavelCpf;
		// this.funcionarioCpf = funcionarioCpf;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		if (this.tipo == "Adestramento")
			this.valor = 100;
		else if (this.tipo == "Hospedagem")
			this.valor = 70;
		else if (this.tipo == "Locação")
			this.valor = 180;

		return this.valor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getResponsavelCpf() {
		return responsavelCpf;
	}

	public void setResponsavelCpf(String responsavelCpf) {
		this.responsavelCpf = responsavelCpf;
	}

	/*
	 * public String getFuncionarioCpf() { return funcionarioCpf; }
	 * 
	 * public void setFuncionarioCpf(String funcionarioCpf) { this.funcionarioCpf =
	 * funcionarioCpf; }
	 */
}

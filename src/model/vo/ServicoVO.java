package model.vo;

import java.time.LocalDateTime;
import java.util.Date;

public class ServicoVO {
	private int codigo;
	private String nome;
	private String tipo;
	private double valor;
	private String responsavelCpf;
	private String funcionarioCpf;
	private Date dataInicio;
	private Date dataFim;

	public ServicoVO() {
		// TODO Auto-generated constructor stub
	}

	public ServicoVO(int codigo, String nome, String tipo, double valor, String responsavelCpf, String funcionarioCpf,
			Date dataInicio, Date dataFim) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.responsavelCpf = responsavelCpf;
		this.funcionarioCpf = funcionarioCpf;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getResponsavelCpf() {
		return responsavelCpf;
	}

	public void setResponsavelCpf(String responsavelCpf) {
		this.responsavelCpf = responsavelCpf;
	}

	public String getFuncionarioCpf() {
		return funcionarioCpf;
	}

	public void setFuncionarioCpf(String funcionarioCpf) {
		this.funcionarioCpf = funcionarioCpf;
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

}

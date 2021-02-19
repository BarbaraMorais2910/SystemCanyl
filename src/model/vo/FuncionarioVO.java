package model.vo;

public class FuncionarioVO {
	private String nome;
	private String cpf;
	private String area;

	public FuncionarioVO() {
		// TODO Auto-generated constructor stub
	}

	public FuncionarioVO(String nome, String cpf, String area) {
		this.nome = nome;
		this.cpf = cpf;
		this.area = area;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}

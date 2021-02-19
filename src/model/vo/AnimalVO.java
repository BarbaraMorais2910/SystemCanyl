package model.vo;

public class AnimalVO {
	private String nome;
	private String raca;
	private int idade;
	private String tipo;
	private String responsavelCpf;

	public AnimalVO() {
		// TODO Auto-generated constructor stub
	}

	public AnimalVO(String nome, String raca, int idade, String tipo) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.tipo = tipo;
	}

	public AnimalVO(String nome, String raca, int idade, String tipo, String responsavelCpf) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.tipo = tipo;
		this.responsavelCpf = responsavelCpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setResponsavelCpf(String responsavelCpf) {
		this.responsavelCpf = responsavelCpf;
	}

	public String getResponsavelCpf() {
		return responsavelCpf;
	}

}

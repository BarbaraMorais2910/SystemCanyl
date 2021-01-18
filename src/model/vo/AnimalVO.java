package model.vo;

public class AnimalVO {
	private String nome;
	private String raca;
	private int idade;
	private String tipo;
	private int responsavelId;

	public AnimalVO() {
		// TODO Auto-generated constructor stub
	}

	public AnimalVO(String nome, String raca, int idade, String tipo) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.tipo = tipo;
	}

	public AnimalVO(String nome, String raca, int idade, String tipo, int responsavelId) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.tipo = tipo;
		this.responsavelId = responsavelId;
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

	public int getResponsavelId() {
		return this.responsavelId;
	}

	public void setResponsavelId(int responsavelId) {
		this.responsavelId = responsavelId;
	}

}

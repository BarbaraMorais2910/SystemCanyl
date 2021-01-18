package model.vo;

public class ResponsavelVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String cidade;
	private String UF;

	public ResponsavelVO() {
	}

	public ResponsavelVO(String nome, String cpf, String endereco, String cidade, String uF) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cidade = cidade;
		UF = uF;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	
}

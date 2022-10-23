package br.com.fiap.fintech.model;

import java.sql.Date;

public class DadoPessoalModel {
	private int id;
	private Date data_registro;
	private int login_id;
	private String nomecompleto;
	private Date data_nascimento;
	private long cpf;
	private long registro_geral;
	
	public DadoPessoalModel() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_registro() {
		return data_registro;
	}

	public void setData_registro(Date data_registro) {
		this.data_registro = data_registro;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getRegistro_geral() {
		return registro_geral;
	}

	public void setRegistro_geral(long registro_geral) {
		this.registro_geral = registro_geral;
	}

	@Override
	public String toString() {
		return "DadoPessoalModel [id=" + id + ", data_registro=" + data_registro + ", login_id=" + login_id
				+ ", nomecompleto=" + nomecompleto + ", data_nascimento=" + data_nascimento + ", cpf=" + cpf
				+ ", registro_geral=" + registro_geral + "]";
	}
	
	
}

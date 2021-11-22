package br.com.fiap.healthtrack.model.beans;

import java.io.Serializable;

public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idAtividade;
	private String dataAtividade;
	private String horaAtividade;
	private String categoria;
	private short kcal;
	private String descricao;
	
	public Atividade() {
	}

	public long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getDataAtividade() {
		return dataAtividade;
	}

	public void setDataAtividade(String dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

	public String getHoraAtividade() {
		return horaAtividade;
	}

	public void setHoraAtividade(String horaAtividade) {
		this.horaAtividade = horaAtividade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public short getKcal() {
		return kcal;
	}

	public void setKcal(short kcal) {
		this.kcal = kcal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

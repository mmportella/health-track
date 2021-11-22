package br.com.fiap.healthtrack.model.beans;

import java.io.Serializable;

public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long idAlimento;
	private String dataAlimento;
	private String horaAlimento;
	private String categoria;
	private short kcal;
	private String descricao;

	public Alimento() {
	}

	public long getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}
	
	public String getDataAlimento() {
		return dataAlimento;
	}

	public void setDataAlimento(String dataAlimento) {
		this.dataAlimento = dataAlimento;
	}

	public String getHoraAlimento() {
		return horaAlimento;
	}

	public void setHoraAlimento(String hora) {
		this.horaAlimento = hora;
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

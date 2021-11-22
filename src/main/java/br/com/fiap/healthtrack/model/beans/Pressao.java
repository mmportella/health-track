package br.com.fiap.healthtrack.model.beans;

import java.io.Serializable;

public class Pressao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long idPressao;
	private short pressaoSistolica;
	private short pressaoDiastolica;
	private String dataPressao;
	
	public Pressao() {
	}

	public long getIdPressao() {
		return idPressao;
	}

	public void setIdPressao(long idPressao) {
		this.idPressao = idPressao;
	}

	public short getPressaoSistolica() {
		return pressaoSistolica;
	}

	public void setPressaoSistolica(short pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}

	public short getPressaoDiastolica() {
		return pressaoDiastolica;
	}

	public void setPressaoDiastolica(short pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}

	public String getDataPressao() {
		return dataPressao;
	}

	public void setDataPressao(String dataPressao) {
		this.dataPressao = dataPressao;
	}

}

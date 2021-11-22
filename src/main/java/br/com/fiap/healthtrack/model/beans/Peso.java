package br.com.fiap.healthtrack.model.beans;

import java.io.Serializable;

public class Peso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long idPeso;
	private float peso;
	private String dataPeso;

	public Peso() {
		
	}

	public long getIdPeso() {
		return idPeso;
	}

	public void setIdPeso(long idPeso) {
		this.idPeso = idPeso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDataPeso() {
		return dataPeso;
	}

	public void setDataPeso(String dataPeso) {
		this.dataPeso = dataPeso;
	}
	
}

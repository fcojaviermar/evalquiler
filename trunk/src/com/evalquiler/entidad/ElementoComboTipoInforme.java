package com.evalquiler.entidad;

public class ElementoComboTipoInforme {
	
	private String idTipoInforme = null;
	private String descripcion = null;
	
	
	public ElementoComboTipoInforme() {
		this.idTipoInforme = "0";
		this.descripcion = "";
	}

	public ElementoComboTipoInforme(final String idTipoInforme, final String desc) {
		this.idTipoInforme = idTipoInforme;
		this.descripcion = desc;
	}
	
	public String getIdTipoInforme() {
		return idTipoInforme;
	}
	
	public void setIdTipoInforme(String idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

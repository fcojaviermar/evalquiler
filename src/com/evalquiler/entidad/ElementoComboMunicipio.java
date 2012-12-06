package com.evalquiler.entidad;

public class ElementoComboMunicipio {
	private String idMunicipio = null;
	private String descripcion = null;

	public ElementoComboMunicipio() {
		this.idMunicipio = "0";
		this.descripcion = "";
	}
	
	public ElementoComboMunicipio(final String idMunicipio, final String desc) {
		this.idMunicipio = idMunicipio;
		this.descripcion = desc;
	}
	
	public String getIdMunicipio() {
		return idMunicipio;
	}
	
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

package com.evalquiler.entidad;

public class ElementoComboProvincia {
	private String idProvincia = null;
	private String descripcion = null;
	
	public ElementoComboProvincia(final String idProvincia, final String desc) {
		this.idProvincia = idProvincia;
		this.descripcion = desc;
	}

	public ElementoComboProvincia() {
		this.idProvincia = "0";
		this.descripcion = "";
	}

	public String getIdProvincia() {
		return idProvincia;
	}
	
	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

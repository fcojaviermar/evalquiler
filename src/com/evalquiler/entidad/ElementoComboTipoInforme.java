package com.evalquiler.entidad;

public class ElementoComboTipoInforme {
	
	private String idTipoInforme = null;
	private String descripcion = null;
	
	
	public ElementoComboTipoInforme() {
		this.idTipoInforme = "0";
		this.descripcion = "";
	}

	public ElementoComboTipoInforme(final String idTipoUsuario, final String desc) {
		this.idTipoInforme = idTipoUsuario;
		this.descripcion = desc;
	}
	
	public String getIdTipoUsuario() {
		return idTipoInforme;
	}
	
	public void setIdTipoDocumento(String idTipoUsuario) {
		this.idTipoInforme = idTipoUsuario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

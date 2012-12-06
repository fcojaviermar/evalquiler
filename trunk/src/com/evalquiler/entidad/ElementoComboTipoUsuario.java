package com.evalquiler.entidad;

public class ElementoComboTipoUsuario {
	
	private String idTipoUsuario = null;
	private String descripcion = null;
	
	
	public ElementoComboTipoUsuario() {
		this.idTipoUsuario = "0";
		this.descripcion = "";
	}

	public ElementoComboTipoUsuario(final String idTipoUsuario, final String desc) {
		this.idTipoUsuario = idTipoUsuario;
		this.descripcion = desc;
	}
	
	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}
	
	public void setIdTipoUsuario(String idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

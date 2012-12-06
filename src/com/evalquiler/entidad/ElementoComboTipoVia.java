package com.evalquiler.entidad;

public class ElementoComboTipoVia {
	
	private String idTipoVia = null;
	private String descripcion = null;
	
	
	public ElementoComboTipoVia() {
		this.idTipoVia = "0";
		this.descripcion = "";
	}

	public ElementoComboTipoVia(final String idTipoVia, final String desc) {
		this.idTipoVia = idTipoVia;
		this.descripcion = desc;
	}
	
	public String getIdTipoVia() {
		return idTipoVia;
	}
	
	public void setIdTipoVia(String idTipoVia) {
		this.idTipoVia = idTipoVia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

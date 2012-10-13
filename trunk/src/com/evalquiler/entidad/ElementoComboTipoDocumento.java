package com.evalquiler.entidad;

public class ElementoComboTipoDocumento {
	private String idTipoDocumento = null;
	private String descripcion = null;
	
	public ElementoComboTipoDocumento(final String idTipoDocumento, final String desc) {
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = desc;
	}
	
	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}
	
	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

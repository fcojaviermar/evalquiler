package com.evalquiler.entidad;

public class ElementoCombo {
	private String id = null;
	private String descripcion = null;
	
	public ElementoCombo(final String id, final String desc) {
		this.id = id;
		this.descripcion = desc;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

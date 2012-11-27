package com.evalquiler.comun.excepcion;

public class ExcepcionComun extends Exception {
	private String codigo 		    = null;
	private String mensaje 		    = null;
	private String mensajeExtendido = null;
	
	
	public ExcepcionComun(final String codigo , final String mensaje , final String mensajeExtendido) {
		this.codigo  		  = codigo;
		this.mensaje 		  = mensaje;
		this.mensajeExtendido = mensajeExtendido;
	}


	public final String getCodigo() {
		return codigo;
	}

	public final String getMensaje() {
		return mensaje;
	}

	public final String getMensajeExtendido() {
		return mensajeExtendido;
	}

	
	public final boolean esInformativo() {
		boolean esInfo = false;
		if ("I".equals(codigo.substring(0,1))) {
			esInfo = true;
		}
		
		return esInfo;
	}

	public final boolean esError() {
		boolean esInfo = false;
		if ("E".equals(codigo.substring(0,1))) {
			esInfo = true;
		}
		
		return esInfo;
	}

	
}

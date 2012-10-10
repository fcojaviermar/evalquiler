package com.evalquiler.comun.excepcion;

public class ExcepcionComun extends Exception {
	private int    codigo 		    = 0;
	private String mensaje 		    = null;
	private String mensajeExtendido = null;
	
	
	public ExcepcionComun(final int codigo , final String mensaje , final String mensajeExtendido) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.mensajeExtendido = mensajeExtendido;
	}


	public int getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getMensajeExtendido() {
		return mensajeExtendido;
	}

}

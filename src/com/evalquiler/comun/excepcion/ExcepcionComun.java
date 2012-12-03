package com.evalquiler.comun.excepcion;

import com.evalquiler.comun.utilidades.UtilidadesFechas;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;

public class ExcepcionComun extends Exception {
	private String codigo 		    = null;
	private String mensaje 		    = null;
	private String mensajeExtendido = null;
	
	
	public ExcepcionComun(final String codigo , final String mensaje , final String mensajeExtendido) {
		this.codigo  		  = codigo;
		this.mensaje 		  = mensaje;
		this.mensajeExtendido = mensajeExtendido;
		print();
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

	private final void print() {
		String cadena = "=====================================\n";
		cadena = cadena.concat(UtilidadesFechas.getAhora() + "\n");;
		cadena = cadena.concat("Código: " + this.getCodigo() + "\n");
		cadena = cadena.concat("Mensaje: " + this.getMensaje() + "\n");
		cadena = cadena.concat("Mensaje ampliado: " + this.getMensajeExtendido() + "\n");
		UtilidadesFicheros.escribir(cadena);
		
	}
	
}

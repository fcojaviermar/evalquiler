package com.evalquiler.excepciones;

import com.evalquiler.comun.excepcion.ExcepcionComun;

public class ExcepcionVivienda extends ExcepcionComun {

	public ExcepcionVivienda(final String codigo , final String mensaje , final String mensajeExtendido) {
		super(codigo, mensaje, mensajeExtendido);
	}
}

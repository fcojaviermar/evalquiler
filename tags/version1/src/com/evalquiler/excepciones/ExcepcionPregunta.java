package com.evalquiler.excepciones;

import com.evalquiler.comun.excepcion.ExcepcionComun;

public class ExcepcionPregunta extends ExcepcionComun {

	public ExcepcionPregunta(final String codigo , final String mensaje , final String mensajeExtendido) {
		super(codigo, mensaje, mensajeExtendido);
	}
}

package com.evalquiler.excepciones;

import com.evalquiler.comun.excepcion.ExcepcionComun;

public class ExcepcionRespuesta extends ExcepcionComun {

	public ExcepcionRespuesta(final String codigo , final String mensaje , final String mensajeExtendido) {
		super(codigo, mensaje, mensajeExtendido);
	}
}

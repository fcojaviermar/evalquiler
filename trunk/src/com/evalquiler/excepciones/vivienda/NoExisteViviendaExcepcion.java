package com.evalquiler.excepciones.vivienda;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public final class NoExisteViviendaExcepcion extends ExcepcionComun {

	public NoExisteViviendaExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "", 
			  "No existen encuestas para el tipo de usuario " + id);
	}
}

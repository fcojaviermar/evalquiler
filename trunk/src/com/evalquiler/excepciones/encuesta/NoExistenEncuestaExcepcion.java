package com.evalquiler.excepciones.encuesta;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NoExistenEncuestaExcepcion extends ExcepcionComun {

	public NoExistenEncuestaExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "error.no.existe.encuesta", 
			  "No existen encuestas para el tipo de usuario " + id);
	}
}

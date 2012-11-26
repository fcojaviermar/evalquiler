package com.evalquiler.excepciones.encuesta;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class RespuestasEncuestaNoGuardadasExcepcion extends ExcepcionComun {

	public RespuestasEncuestaNoGuardadasExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_GUARDADO)), 
			  "error.no.guardar.encuesta", 
			  "No se han guardado las respuestas a la encuesta.");
	}
}

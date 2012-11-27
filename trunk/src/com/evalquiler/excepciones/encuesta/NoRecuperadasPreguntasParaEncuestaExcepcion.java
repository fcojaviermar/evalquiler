package com.evalquiler.excepciones.encuesta;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NoRecuperadasPreguntasParaEncuestaExcepcion extends ExcepcionComun {

	public NoRecuperadasPreguntasParaEncuestaExcepcion(final String id, final String idEncuesta) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "error.no.existen.preguntas", 
			  "No se han recuperado preguntas para la encuesta " + idEncuesta + " del tipo de usuario " + id);
	}
}

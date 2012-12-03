package com.evalquiler.excepciones.encuesta;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NoRecuperadaEncuestaExcepcion extends ExcepcionComun {

	public NoRecuperadaEncuestaExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "error.no.existe.encuesta", 
			  "NoRecuperadaEncuestaExcepcion: No se ha recuperado una encuesta para el tipo de usuario " + id);
	}
}

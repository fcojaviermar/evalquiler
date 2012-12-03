package com.evalquiler.excepciones.encuesta;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class EncuestaRespondidaEnPeriodoEvaluacionExcepcion extends ExcepcionComun {

	public EncuestaRespondidaEnPeriodoEvaluacionExcepcion(final DatosRealizacionEncuestaActionForm datosRealizacionEncuesta) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_YA_EXISTE)), 
			  "", 
			  "EncuestaRespondidaEnPeriodoEvaluacionExcepcion: La encuesta ya ha sido realizada para el periodo desde" + datosRealizacionEncuesta.getFechaInicioEvaluacionAlquiler() + 
			  " hasta " + datosRealizacionEncuesta.getFechaFinEvaluacionAlquiler() + ".");
	}
}

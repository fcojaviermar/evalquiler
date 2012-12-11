/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoRespuestasEncuesta;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.EncuestaRespondidaEnPeriodoEvaluacionExcepcion;
import com.evalquiler.excepciones.encuesta.RespuestasEncuestaNoGuardadasExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpRespuestasEncuesta {
	
	public static final int insertar(final ActionForm datosEncuestaIn) 
		throws RespuestasEncuestaNoGuardadasExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		int iResultado = DaoRespuestasEncuesta.insertar((DatosRealizacionEncuestaActionForm)datosEncuestaIn);
		
		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new RespuestasEncuestaNoGuardadasExcepcion("");
		}

		return iResultado;
	}

	
	public static final Collection<DatosRealizacionEncuestaActionForm> consultarEncuestasRespondidas(final ActionForm datosUsuarioIn) 
			throws ExcepcionEjecutarSentancia, ExcepcionComun {
		
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = 
														DaoRespuestasEncuesta.consultar(datosUsuarioIn, 
														DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS);
		return encuestasRespondidas;
	}

	
	public static final Collection<DatosRealizacionEncuestaActionForm> getEncuestasRespondidasEnPeriodo (DatosRealizacionEncuestaActionForm datosRealizacionEncuestaIn) 
		throws EncuestaRespondidaEnPeriodoEvaluacionExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = 
														DaoRespuestasEncuesta.consultar(datosRealizacionEncuestaIn, 
														DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS);
		if (null != encuestasRespondidas) {
			if (!encuestasRespondidas.isEmpty())  {
				throw new EncuestaRespondidaEnPeriodoEvaluacionExcepcion(datosRealizacionEncuestaIn);
			}
		} else {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
		 											ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
		 												ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
		 										"error.ejecutar.sentencia", 
		 										"Se ha obtenido un resultado nulo al ejecutar la sentencia del DaoRespuestasEncuetas " + DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS);
			
		}
		return encuestasRespondidas;
	}
	
}

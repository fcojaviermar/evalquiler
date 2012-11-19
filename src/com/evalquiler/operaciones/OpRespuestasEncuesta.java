/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.dao.DaoRespuestasEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpRespuestasEncuesta {
	
	public static final int insertar(final ActionForm datosEncuestaIn) {
		int iResultado = DaoRespuestasEncuesta.insertar((DatosRealizacionEncuestaActionForm)datosEncuestaIn);
		if (iResultado != 0) {
			iResultado = Constantes.RESULTADO_OK;
		} else {
			iResultado = Constantes.RESULTADO_NOOK;
		}
		return iResultado;
	}

	
	public static final Collection<DatosRealizacionEncuestaActionForm> consultarEncuestasRespondidas(final ActionForm datosUsuarioIn) {
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = 
														DaoRespuestasEncuesta.consultar(datosUsuarioIn, 
														DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS);
		return encuestasRespondidas;
	}

	
	public static final boolean hayEncuestasRespondidasEnPeriodo (final DatosRealizacionEncuestaActionForm datosRealizacionEncuestaIn) {
		boolean hayEncuestas = true;
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = 
														DaoRespuestasEncuesta.consultar(datosRealizacionEncuestaIn, 
														DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS);
		
		if ( ((null != encuestasRespondidas) && encuestasRespondidas.isEmpty()) || (null == encuestasRespondidas) ) {
			hayEncuestas = false;
		}
		return hayEncuestas;
	}
	
}

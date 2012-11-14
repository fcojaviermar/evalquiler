/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.dao.DaoRespuestasEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpRespuestasEncuesta {
	
	public static final int insertar(ActionForm datosEncuestaIn) {
		int iResultado = DaoRespuestasEncuesta.insertar((DatosRealizacionEncuestaActionForm)datosEncuestaIn);
		return iResultado;
	}

	
	public static final Collection<DatosRealizacionEncuestaActionForm> consultarEncuestasRespondidas (ActionForm datosUsuarioIn) {
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = DaoRespuestasEncuesta.consultar(datosUsuarioIn, 
														  DaoRespuestasEncuesta.SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS);
		
		return encuestasRespondidas;
	}
}

/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.RespuestasPreguntaActionForm;
import com.evalquiler.dao.DaoRespuesta;

/**
 * @author cachorro
 *
 */
public final class OpRespuesta {
	
	public static final Collection<RespuestasPreguntaActionForm> consultarPorPk(ActionForm respuestaIn) {
		Collection<RespuestasPreguntaActionForm> listaRespuestas = 
												 DaoRespuesta.consultarPorPk( ((RespuestasPreguntaActionForm)respuestaIn).getIdRespuesta() );
		return listaRespuestas; 
	}

	
	public static final Collection<RespuestasPreguntaActionForm> consultar(ActionForm preguntaIn) {
		Collection<RespuestasPreguntaActionForm> listaRespuestas = 
												 DaoRespuesta.consultar( ((PreguntasEncuestaActionForm)preguntaIn).getIdPregunta() );
		return listaRespuestas; 
	}


	
	
		
}

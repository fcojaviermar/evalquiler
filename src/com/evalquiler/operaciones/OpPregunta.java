/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.dao.DaoPregunta;

/**
 * @author cachorro
 *
 */
public final class OpPregunta {
	
	public static final Collection<PreguntasEncuestaActionForm> consultarPorPk(ActionForm preguntaIn) {
		Collection<PreguntasEncuestaActionForm> listaPreguntas = DaoPregunta.consultarPorPk( ((PreguntasEncuestaActionForm)preguntaIn).getIdPregunta());
		return listaPreguntas; 
	}
	

	public static final Collection<PreguntasEncuestaActionForm> consultar(ActionForm encuestaIn) {
		Collection<PreguntasEncuestaActionForm> listaPreguntas = DaoPregunta.consultar( ((DatosEncuestaActionForm)encuestaIn).getIdEncuesta());
		return listaPreguntas; 
	}
	
	
}

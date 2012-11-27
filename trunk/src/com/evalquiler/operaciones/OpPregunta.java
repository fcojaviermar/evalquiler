/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.dao.DaoPregunta;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;

/**
 * @author cachorro
 *
 */
public final class OpPregunta {
	

	public static final Collection<PreguntasEncuestaActionForm> consultar(ActionForm encuestaIn) throws ExcepcionEjecutarSentancia {
		Collection<PreguntasEncuestaActionForm> listaPreguntas = DaoPregunta.consultar( ((DatosEncuestaActionForm)encuestaIn).getIdEncuesta());
		return listaPreguntas; 
	}
	
	
}

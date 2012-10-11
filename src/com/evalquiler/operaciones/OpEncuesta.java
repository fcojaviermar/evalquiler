/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.RespuestasPreguntaActionForm;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.dao.DaoRespuesta;

/**
 * @author cachorro
 *
 */
public final class OpEncuesta {
	
	public static final Collection<DatosEncuestaActionForm> consultarPorPk(ActionForm encuestaIn) {
		Collection<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consultarPorPk( ((DatosEncuestaActionForm)encuestaIn).getIdEncuesta());
		return listaEncuesta; 
	}

	public static final Collection<DatosEncuestaActionForm> consultar(ActionForm encuestaIn) {

		Collection<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consultar( ((DatosEncuestaActionForm)encuestaIn).getQuienContesta());

		if (!listaEncuesta.isEmpty()) {
			DatosEncuestaActionForm encuesta = (DatosEncuestaActionForm)listaEncuesta.iterator().next();
			Collection<PreguntasEncuestaActionForm> listaPreguntas = OpPregunta.consultar(encuesta);
			
			if (!listaPreguntas.isEmpty()) { 
				Collection<PreguntasEncuestaActionForm> listaPreguntasAux = new ArrayList<PreguntasEncuestaActionForm>(); 
			
				while (listaPreguntas.iterator().hasNext()) {
					PreguntasEncuestaActionForm pregunta = (PreguntasEncuestaActionForm)listaPreguntas.iterator().next();
					Collection<RespuestasPreguntaActionForm> listaRespuesta = DaoRespuesta.consultar(pregunta.getIdPregunta());		
				
					if (listaRespuesta.iterator().hasNext()) {
						pregunta.setRespuestas(listaRespuesta);
						listaPreguntasAux.add(pregunta);
					}
				}
			
				if (!listaPreguntasAux.isEmpty()) {
					encuesta.setPreguntas(listaPreguntasAux);
				}
			} else {
				
			}
		} else {
			
		}
		
		return listaEncuesta; 
	}
	
}

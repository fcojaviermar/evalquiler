/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.NoExistenEncuestasExcepcion;
import com.evalquiler.excepciones.encuesta.NoRecuperadaEncuestaExcepcion;
import com.evalquiler.excepciones.encuesta.NoRecuperadasPreguntasParaEncuestaExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpEncuesta {
	
	public static final Collection<DatosEncuestaActionForm> consultarParaTipoUsuario(ActionForm objetoIn, final String tipoConsulta) 
		throws NoExistenEncuestasExcepcion, ExcepcionEjecutarSentancia, NoRecuperadaEncuestaExcepcion, NoRecuperadasPreguntasParaEncuestaExcepcion {
		Collection<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consultar(objetoIn, tipoConsulta);
		
		if ( (null == listaEncuesta) || (listaEncuesta.isEmpty()) ) {
			throw new NoExistenEncuestasExcepcion(String.valueOf(((DatosUsuarioActionForm)objetoIn).getIdTipoUsuario()));
		}
		return listaEncuesta; 
	}
}

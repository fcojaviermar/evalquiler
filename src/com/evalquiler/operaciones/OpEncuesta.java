/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.excepciones.encuesta.NoExistenEncuestaExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpEncuesta {
	
	public static final Collection<DatosEncuestaActionForm> consultarParaTipoUsuario(ActionForm objetoIn, final String tipoConsulta) 
		throws NoExistenEncuestaExcepcion {
		Collection<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consultar(objetoIn, tipoConsulta);
		
		if ( (null == listaEncuesta) || (listaEncuesta.isEmpty()) ) {
			throw new NoExistenEncuestaExcepcion(String.valueOf(((DatosUsuarioActionForm)objetoIn).getIdTipoUsuario()));
		}
		return listaEncuesta; 
	}
}

/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.dao.DaoEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpEncuesta {
	
	public static final Collection<DatosEncuestaActionForm> consultar(final ActionForm objetoIn, final String tipoConsulta) {
		Collection<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consultar(objetoIn, tipoConsulta);
		return listaEncuesta; 
	}
}

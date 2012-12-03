/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.dao.DaoUsuario;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.usuario.UsuarioNoExisteExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioNoGuardadoExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioRepetidoExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpUsuario {
	
	public static final Collection<DatosUsuarioActionForm> consultarPorPk(ActionForm usuarioIn) 
		throws UsuarioNoExisteExcepcion, UsuarioRepetidoExcepcion, ExcepcionEjecutarSentancia {
		Collection<DatosUsuarioActionForm> listaUsuarios = DaoUsuario.consutarPorPk( ((DatosInicioSesionActionForm)usuarioIn).getUser());
		
		if ( (null != listaUsuarios) && (listaUsuarios.isEmpty()) ) {
			throw new UsuarioNoExisteExcepcion(((DatosInicioSesionActionForm)usuarioIn).getUser());
		} 
		
		if (listaUsuarios.size() > 1) {
			throw new UsuarioRepetidoExcepcion(((DatosInicioSesionActionForm)usuarioIn).getUser());
		}
		
		return listaUsuarios; 
	}
	
	public static final int insertar(ActionForm usuarioIn) throws UsuarioNoGuardadoExcepcion, ExcepcionEjecutarSentancia {
		int iResultado = DaoUsuario.insertar((DatosUsuarioActionForm)usuarioIn);

		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new UsuarioNoGuardadoExcepcion(((DatosUsuarioActionForm)usuarioIn).getUser());
		}
		
		return iResultado; 
	}	
}

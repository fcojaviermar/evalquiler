/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoUsuario;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.usuario.NifUsuarioRepetidoExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioNoExisteExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioNoGuardadoExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioRepetidoExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpUsuario {
	
	public static final DatosUsuarioActionForm consultarPorPk(ActionForm usuarioIn) 
		throws UsuarioNoExisteExcepcion, UsuarioRepetidoExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		DatosUsuarioActionForm usuario = null;
		
		Collection<DatosUsuarioActionForm> listaUsuarios = DaoUsuario.consutarPorPk( ((DatosInicioSesionActionForm)usuarioIn).getUser());
		
		if ( (null != listaUsuarios) && (listaUsuarios.isEmpty()) ) {
			throw new UsuarioNoExisteExcepcion(((DatosInicioSesionActionForm)usuarioIn).getUser());
		} 
		
		if (listaUsuarios.size() > 1) {
			throw new UsuarioRepetidoExcepcion(((DatosInicioSesionActionForm)usuarioIn).getUser());
		}

		usuario = listaUsuarios.iterator().next();
		
		ComboTipoUsuario comboUsuario = new ComboTipoUsuario();
		ElementoComboTipoUsuario tipoUsuario = comboUsuario.get(listaUsuarios.iterator().next().getIdTipoUsuario());
		usuario.setDescTipoUsuario(tipoUsuario.getDescripcion());
		
		return usuario; 
	}
	
	public static final int insertar(ActionForm usuarioIn) 
			throws UsuarioNoGuardadoExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		int iResultado = DaoUsuario.insertar((DatosUsuarioActionForm)usuarioIn);

		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new UsuarioNoGuardadoExcepcion(((DatosUsuarioActionForm)usuarioIn).getUser());
		}
		
		return iResultado; 
	}	
}

/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.dao.DaoUsuario;

/**
 * @author cachorro
 *
 */
public final class OpUsuario {
	
	public static final Collection<DatosInicioSesionActionForm> consultarPorPk(ActionForm usuarioIn) {
		Collection<DatosInicioSesionActionForm> listaUsuarios = DaoUsuario.consutarPorPk( ((DatosInicioSesionActionForm)usuarioIn).getUser());
		
		return listaUsuarios; 
	}
	
	public static final int insertar(ActionForm usuarioIn) {
		int iResultado = DaoUsuario.insertar((DatosUsuarioActionForm)usuarioIn);
		
		return iResultado; 
	}	
}

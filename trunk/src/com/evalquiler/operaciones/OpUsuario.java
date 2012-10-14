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
	
	public static final Collection<DatosUsuarioActionForm> consultarPorPk(ActionForm usuarioIn) {
		Collection<DatosUsuarioActionForm> listaUsuarios = DaoUsuario.consutarPorPk( ((DatosInicioSesionActionForm)usuarioIn).getUser());
		
		return listaUsuarios; 
	}
	
	public static final int insertar(ActionForm usuarioIn) {
		int iResultado = DaoUsuario.insertar((DatosUsuarioActionForm)usuarioIn);
		
		return iResultado; 
	}	
}

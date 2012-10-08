/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.dao.DaoUsuario;

/**
 * @author cachorro
 *
 */
public final class OpUsuario {
	
	public static final ArrayList<DatosInicioSesionActionForm> consutarPorPk(ActionForm usuarioIn) {
		ArrayList<DatosInicioSesionActionForm> listaUsuarios = DaoUsuario.consutarPorPk( ((DatosInicioSesionActionForm)usuarioIn).getUser());
		
		return listaUsuarios; 
	}
	
	public static final int insertar(ActionForm usuarioIn) {
		int iResultado = DaoUsuario.insertar((DatosUsuarioActionForm)usuarioIn);
		
		return iResultado; 
	}	
}

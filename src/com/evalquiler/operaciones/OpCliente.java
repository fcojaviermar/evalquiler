/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.dao.DaoCliente;

/**
 * @author cachorro
 *
 */
public final class OpCliente {
	
	public static final ArrayList<DatosInicioSesionActionForm> consutarPorPk(ActionForm ClienteIn) {
		ArrayList<DatosInicioSesionActionForm> listaClientes = DaoCliente.consutarPorPk( ((DatosInicioSesionActionForm)ClienteIn).getUser());
		
		return listaClientes; 
	}
	
	
	public static final int insertar(ActionForm usuarioIn) {
		int iResultado = DaoCliente.insertar((DatosClienteActionForm)usuarioIn);
		
		return iResultado; 
	}		
}

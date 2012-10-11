/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.dao.DaoCliente;

/**
 * @author cachorro
 *
 */
public final class OpCliente {
	
	public static final Collection<DatosInicioSesionActionForm> consultarPorPk(ActionForm ClienteIn) {
		Collection<DatosInicioSesionActionForm> listaClientes = DaoCliente.consultarPorPk( ((DatosInicioSesionActionForm)ClienteIn).getUser());
		
		return listaClientes; 
	}
	
	
	public static final int insertar(ActionForm usuarioIn) {
		int iResultado = DaoCliente.insertar((DatosClienteActionForm)usuarioIn);
		
		return iResultado; 
	}		
}

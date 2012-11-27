/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.dao.DaoCliente;
import com.evalquiler.excepciones.cliente.ClienteNoExisteExcepcion;
import com.evalquiler.excepciones.cliente.ClienteNoGuardadoExcepcion;
import com.evalquiler.excepciones.cliente.ClienteRepetidoExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpCliente {
	
	public static final Collection<DatosClienteActionForm> consultarPorPk(ActionForm ClienteIn) 
		throws ClienteNoExisteExcepcion, ClienteRepetidoExcepcion {
		Collection<DatosClienteActionForm> listaClientes = DaoCliente.consultarPorPk( ((DatosInicioSesionActionForm)ClienteIn).getUser());
		
		if ( (null != listaClientes) && (listaClientes.isEmpty()) ) {
			throw new ClienteNoExisteExcepcion(((DatosInicioSesionActionForm)ClienteIn).getUser());
		} 
		
		if (listaClientes.size() > 1) {
			throw new ClienteRepetidoExcepcion(((DatosInicioSesionActionForm)ClienteIn).getUser());
		}
		
		return listaClientes; 
	}
	
	
	public static final int insertar(ActionForm usuarioIn) throws ClienteNoGuardadoExcepcion {
		int iResultado = DaoCliente.insertar((DatosClienteActionForm)usuarioIn);
		
		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new ClienteNoGuardadoExcepcion(((DatosClienteActionForm)usuarioIn).getUser());
		}
		
		return iResultado; 
	}		
}

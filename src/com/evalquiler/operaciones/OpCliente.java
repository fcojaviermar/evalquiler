/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoCliente;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.cliente.ClienteNoExisteExcepcion;
import com.evalquiler.excepciones.cliente.ClienteNoGuardadoExcepcion;
import com.evalquiler.excepciones.cliente.ClienteRepetidoExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpCliente {
	
	public static final DatosClienteActionForm consultarPorPk(ActionForm ClienteIn) 
		throws ClienteNoExisteExcepcion, ClienteRepetidoExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		DatosClienteActionForm cliente = null;
		Collection<DatosClienteActionForm> listaClientes = DaoCliente.consultarPorPk( ((DatosInicioSesionActionForm)ClienteIn).getUser());
		
		if ( (null != listaClientes) && (listaClientes.isEmpty()) ) {
			throw new ClienteNoExisteExcepcion(((DatosInicioSesionActionForm)ClienteIn).getUser());
		} 
		
		if (listaClientes.size() > 1) {
			throw new ClienteRepetidoExcepcion(((DatosInicioSesionActionForm)ClienteIn).getUser());
		}
		
		cliente = listaClientes.iterator().next();
		return cliente; 
	}
	
	
	public static final int insertar(ActionForm usuarioIn) 
			throws ClienteNoGuardadoExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		int iResultado = DaoCliente.insertar((DatosClienteActionForm)usuarioIn);
		
		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new ClienteNoGuardadoExcepcion(((DatosClienteActionForm)usuarioIn).getUser());
		}
		
		return iResultado; 
	}		
}

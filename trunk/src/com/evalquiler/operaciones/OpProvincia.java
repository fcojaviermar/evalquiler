/**
 * 
 */
package com.evalquiler.operaciones;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.combo.ComboProvincia;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoCliente;
import com.evalquiler.dao.DaoProvincia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.cliente.ClienteNoGuardadoExcepcion;
import com.evalquiler.excepciones.provincias.NumeroDeProvinciasErroneoExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpProvincia {
	
	public static final ComboProvincia obtenerProvincias() 
			throws ExcepcionEjecutarSentancia, NumeroDeProvinciasErroneoExcepcion, ExcepcionComun {
		
		ComboProvincia comboProvincia = DaoProvincia.consultar();
		if (comboProvincia.size() != ComboProvincia.NUMERO_ELEMENTOS_PROVINCIAS) {
			throw new NumeroDeProvinciasErroneoExcepcion(comboProvincia.size());
		}
			
		return comboProvincia; 
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

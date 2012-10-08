/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.dao.DaoCliente;
import com.evalquiler.dao.DaoEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpEncuesta {
	
	public static final ArrayList<DatosEncuestaActionForm> consutarPorPk(ActionForm encuestaIn) {
		ArrayList<DatosEncuestaActionForm> listaEncuesta = DaoEncuesta.consutarPorPk( ((DatosEncuestaActionForm)encuestaIn).getUser());
		
		return listaEncuesta; 
	}
	
}

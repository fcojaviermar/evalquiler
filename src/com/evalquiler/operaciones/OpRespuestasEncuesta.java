/**
 * 
 */
package com.evalquiler.operaciones;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.dao.DaoRespuestasEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpRespuestasEncuesta {
	
	public static final int insertar(ActionForm datosEncuestaIn) {
		int iResultado = DaoRespuestasEncuesta.insertar((DatosRealizacionEncuestaActionForm)datosEncuestaIn);
		
		return iResultado;
	}

}

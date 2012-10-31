/**
 * 
 */
package com.evalquiler.operaciones;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.RespuestasEncuestaActionForm;
import com.evalquiler.dao.DaoRespuestasEncuesta;

/**
 * @author cachorro
 *
 */
public final class OpRespuestasEncuesta {
	
	public static final int insertar(ActionForm respuestasEncuestaIn) {
		int iResultado = DaoRespuestasEncuesta.insertar((RespuestasEncuestaActionForm)respuestasEncuestaIn);
		
		return iResultado;
	}

}

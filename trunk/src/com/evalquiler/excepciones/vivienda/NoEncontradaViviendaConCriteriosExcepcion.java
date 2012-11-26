package com.evalquiler.excepciones.vivienda;

import org.apache.struts.action.ActionForm;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public final class NoEncontradaViviendaConCriteriosExcepcion extends ExcepcionComun {

	public NoEncontradaViviendaConCriteriosExcepcion(final ActionForm vivienda) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
								  ConstantesCodigosExcepciones.CODIGO_NINGUN_REGISTRO_CON_ESOS_CRITERIOS)), 
			  "", 
			  "No existen viviendas con los criterios introducidos.");
	}
}

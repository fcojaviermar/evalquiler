package com.evalquiler.excepciones.vivienda;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public final class ViviendaNoSeleccionadaExcepcion extends ExcepcionComun {

	public ViviendaNoSeleccionadaExcepcion() {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
				ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
						  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_SELECCIONADO)), 
				"msg.vivienda.no.seleccionada", 
				"ViviendaNoSeleccionadaExcepcion: No se ha seleccionado ninguna vivienda");
	}
}

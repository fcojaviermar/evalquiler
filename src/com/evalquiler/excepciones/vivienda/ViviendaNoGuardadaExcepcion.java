package com.evalquiler.excepciones.vivienda;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class ViviendaNoGuardadaExcepcion extends ExcepcionComun {

	public ViviendaNoGuardadaExcepcion(final DatosViviendaActionForm datosVivienda) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_GUARDADO)), 
			  "msg.vivienda.no.guardada", 
			  "ViviendaNoGuardadaExcepcion: No se han podido guardar los datos de la vivienda." );
	}
}

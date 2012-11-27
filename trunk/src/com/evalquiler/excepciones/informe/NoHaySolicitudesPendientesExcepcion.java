package com.evalquiler.excepciones.informe;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NoHaySolicitudesPendientesExcepcion extends ExcepcionComun {

	public NoHaySolicitudesPendientesExcepcion() {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "msg.no.existen.solicitudes.informes", 
			  "No hay solicitudes de informes pendientes.");
	}
}

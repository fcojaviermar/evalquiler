package com.evalquiler.excepciones.informe;

import com.evalquiler.actionforms.informe.DatosSolicitudInformeActionForm;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class SolicitudinformeNoGuardadaExcepcion extends ExcepcionComun {

	public SolicitudinformeNoGuardadaExcepcion(final DatosSolicitudInformeActionForm solicitudInformeIn) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_GUARDADO)), 
			  "msg.solicitud.informe.no.guardado", 
			  "No se ha guardado la solicitud de informe");
	}
}

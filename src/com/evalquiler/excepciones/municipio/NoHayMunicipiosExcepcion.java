package com.evalquiler.excepciones.municipio;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NoHayMunicipiosExcepcion extends ExcepcionComun {

	public NoHayMunicipiosExcepcion(final String idProvincia) {
		super(ConstantesCodigosExcepciones.ERROR.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_MUNICIPIOS.concat(
								  ConstantesCodigosExcepciones.CODIGO_NUMERO_REGISTROS_ERRONEOS)), 
			  "error.no.hay.municipios", 
			  "NoHayMunicipiosExcepcion: No hay municipios para la provincia: " + idProvincia);
	}
}

package com.evalquiler.excepciones.provincias;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NumeroDeProvinciasErroneoExcepcion extends ExcepcionComun {

	public NumeroDeProvinciasErroneoExcepcion(final int numeroProvincias) {
		super(ConstantesCodigosExcepciones.ERROR.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_PROVINCIAS.concat(
								  ConstantesCodigosExcepciones.CODIGO_NUMERO_REGISTROS_ERRONEOS)), 
			  "error.numero.provincias.erroneo", 
			  "NumeroDeProvinciasErroneoExcepcion: " + numeroProvincias);
	}
}

package com.evalquiler.excepciones.vivienda;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public final class EncontradasMuchasViviendasExcepcion extends ExcepcionComun {

	public EncontradasMuchasViviendasExcepcion(final int numRegistros) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_ENCONTRADOS_EXCEDE_LIMITE)), 
			  "msg.vivienda.registros.excede.limite", 
			  "Se han encontrado " + numRegistros + " viviendas cuando el límite es " + Constantes.NUMERO_REGISTROS_MAXIMO);
	}
}

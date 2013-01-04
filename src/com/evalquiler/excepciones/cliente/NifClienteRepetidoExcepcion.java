package com.evalquiler.excepciones.cliente;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NifClienteRepetidoExcepcion extends ExcepcionComun {

	public NifClienteRepetidoExcepcion(final String nif) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_REPETIDO)), 
			  "error.un.cliente.mismo.cif", 
			  "NifClienteRepetidoExcepcion: Existen dos cliente con el mismo nif: " + nif );
	}
}

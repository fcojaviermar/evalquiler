package com.evalquiler.excepciones.usuario;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class NifUsuarioRepetidoExcepcion extends ExcepcionComun {

	public NifUsuarioRepetidoExcepcion(final String nif) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_REPETIDO)), 
			  "error.mas.de.un.usuario.mismo.nif", 
			  "NifUsuarioRepetidoExcepcion: Existen dos usuarios con el mismo nif: " + nif );
	}
}

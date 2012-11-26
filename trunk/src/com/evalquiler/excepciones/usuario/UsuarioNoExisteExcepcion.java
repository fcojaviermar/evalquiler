package com.evalquiler.excepciones.usuario;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class UsuarioNoExisteExcepcion extends ExcepcionComun {

	public UsuarioNoExisteExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_EXISTE)), 
			  "error.no.existe.usuairo", 
			  "El usuario con identificador " + id + " no existe");
	}
}

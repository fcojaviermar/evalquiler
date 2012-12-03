package com.evalquiler.excepciones.usuario;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class UsuarioNoGuardadoExcepcion extends ExcepcionComun {

	public UsuarioNoGuardadoExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_GUARDADO)), 
			  "msg.usuario.no.guardado", 
			  "UsuarioNoGuardadoExcepcion: El usuario con id: " + id + " no se ha podido guardar." );
	}
}

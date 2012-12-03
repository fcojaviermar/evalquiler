package com.evalquiler.excepciones.usuario;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class UsuarioRepetidoExcepcion extends ExcepcionComun {

	public UsuarioRepetidoExcepcion(final String id) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_REPETIDO)), 
			  "error.mas.de.un.usuario", 
			  "UsuarioRepetidoExcepcion: Existen dos usuarios con el mismo identificador: " + id );
	}
}

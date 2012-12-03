package com.evalquiler.excepciones.cliente;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

public class ClienteNoGuardadoExcepcion extends ExcepcionComun {

	public ClienteNoGuardadoExcepcion(final String idCliente) {
		super(ConstantesCodigosExcepciones.INFORMACION.concat(
						ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
								  ConstantesCodigosExcepciones.CODIGO_REGISTRO_NO_GUARDADO)), 
			  "msg.cliente.no.guardado", 
			  "ClienteNoGuardadoExcepcion: No se han podido guardar los datos del cliente");
	}
}

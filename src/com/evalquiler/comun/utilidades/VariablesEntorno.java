/**
 * 
 */
package com.evalquiler.comun.utilidades;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;

/**
 * @author cachorro
 *
 */
public final class VariablesEntorno {

	

	public static int getVariableEntornoEntera(final String nombreVariable) throws ExcepcionComun {
		Context initContext = null;
		String valor		= null;
		int valorVariable   = 0;
		try {
			initContext = new InitialContext();
			valor = (String)((javax.naming.Reference)initContext.lookup("VARIABLES_ENTORNO_NUMERO")).get(nombreVariable).getContent();
		} catch (NamingException e) {
			throw new ExcepcionComun(ConstantesCodigosExcepciones.ERROR.concat(
		 					ConstantesCodigosExcepciones.FUNCIONALIDAD_GENERAL.concat(
		 					ConstantesCodigosExcepciones.CODIGO_VARIABLE_ENTORNO_NO_ENCONTRADA)), 
									 "error.global.mesage", 
									 "No se ha podido recuperar la variable de entorno VARIABLES_ENTORNO_NUMERO." + nombreVariable);	
		}
		
		try {
			valorVariable = Integer.valueOf(valor).intValue();
		} catch (NumberFormatException e) {
			throw new ExcepcionComun(ConstantesCodigosExcepciones.ERROR.concat(
				ConstantesCodigosExcepciones.FUNCIONALIDAD_GENERAL.concat(
				ConstantesCodigosExcepciones.CODIGO_VARIABLE_ENTORNO_NO_ENCONTRADA)), 
					 "error.global.mesage", 
					 "El valor de la variable de entorno VARIABLES_ENTORNO_NUMERO." + nombreVariable + " no es un entero");	
			
		}
		
		return valorVariable;
	}
	

}

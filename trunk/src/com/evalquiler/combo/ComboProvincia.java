/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.entidad.ElementoComboProvincia;

/**
 * @author cachorro
 *
 */
public final class ComboProvincia extends ArrayList<ElementoComboProvincia> implements Serializable {

	public final static int ALAVA	  					= 1;
	public final static int MELILLA 					= 52;
	public final static int NUMERO_ELEMENTOS_PROVINCIAS	= 53;
	
	public ComboProvincia() {
		add(new ElementoComboProvincia(String.valueOf(Constantes.ELEMENTO_NO_SELECCIONADO), "--- Seleccione una provincia... ---" ));
	}

	
	public final static boolean elementoValido(String idProvicia) {
		boolean esValido = false;
		try {
			int id = Integer.parseInt(idProvicia);
			if ( (ALAVA <= id)  && (MELILLA <= 52) ) {
				esValido = true;
			}
		} catch (NumberFormatException e) {
			
		}
		return esValido;
	}
	
}

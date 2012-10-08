/**
 * 
 */
package com.evalquiler.entidad;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author cachorro
 *
 */
public final class ComboTipoDocumento extends ArrayList<ElementoCombo> implements Serializable {
	
	public ComboTipoDocumento() {
		add(new ElementoCombo("0", "--- Seleccione un elemento... ---" ));
		add(new ElementoCombo("1", "N.I.F." ));
		add(new ElementoCombo("2", "N.I.E."));
		add(new ElementoCombo("3", "C.I.F."));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
			esValido = true;
		}
		
		return esValido;
	}
	
}

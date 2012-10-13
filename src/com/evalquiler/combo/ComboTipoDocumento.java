/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.entidad.ElementoComboTipoDocumento;

/**
 * @author cachorro
 *
 */
public final class ComboTipoDocumento extends ArrayList<ElementoComboTipoDocumento> implements Serializable {
	
	public ComboTipoDocumento() {
		add(new ElementoComboTipoDocumento("0", "--- Seleccione un elemento... ---" ));
		add(new ElementoComboTipoDocumento("1", "N.I.F." ));
		add(new ElementoComboTipoDocumento("2", "N.I.E."));
		add(new ElementoComboTipoDocumento("3", "C.I.F."));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
			esValido = true;
		}
		
		return esValido;
	}
	
}

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
public final class ComboTipoUsuario extends ArrayList<ElementoComboTipoDocumento> implements Serializable {
	
	public ComboTipoUsuario() {
		add(new ElementoComboTipoDocumento("0", "--- Seleccione un elemento... ---" ));
		add(new ElementoComboTipoDocumento("1", "Inquilino" ));
		add(new ElementoComboTipoDocumento("2", "Arrendador"));
		add(new ElementoComboTipoDocumento("3", "Ambos"));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
			esValido = true;
		}
		
		return esValido;
	}
	
}

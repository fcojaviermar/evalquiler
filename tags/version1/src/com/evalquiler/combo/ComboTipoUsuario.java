/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.entidad.ElementoComboTipoUsuario;

/**
 * @author cachorro
 *
 */
public final class ComboTipoUsuario extends ArrayList<ElementoComboTipoUsuario> implements Serializable {
	
	public ComboTipoUsuario() {
		add(new ElementoComboTipoUsuario("0", "--- Seleccione un elemento... ---" ));
		add(new ElementoComboTipoUsuario("1", "Inquilino" ));
		add(new ElementoComboTipoUsuario("2", "Arrendador"));
		add(new ElementoComboTipoUsuario("3", "Ambos"));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
			esValido = true;
		}
		
		return esValido;
	}
	
}

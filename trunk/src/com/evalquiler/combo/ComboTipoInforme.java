/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.entidad.ElementoComboTipoInforme;

/**
 * @author cachorro
 *
 */
public final class ComboTipoInforme extends ArrayList<ElementoComboTipoInforme> implements Serializable {
	
	public ComboTipoInforme() {
		add(new ElementoComboTipoInforme("0", "--- Seleccione un elemento... ---" ));
		add(new ElementoComboTipoInforme("1", "Completo" ));
		add(new ElementoComboTipoInforme("2", "Sobre inquilinos"));
		add(new ElementoComboTipoInforme("3", "Sobre propietarios"));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
			esValido = true;
		}
		
		return esValido;
	}
	
}

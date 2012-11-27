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
public final class ComboProvincia extends ArrayList<ElementoComboTipoUsuario> implements Serializable {

	private final static int ALAVA	  = 1;
	private final static int MELILLA = 52;
	
	public ComboProvincia() {
		add(new ElementoComboTipoUsuario("0", "--- Seleccione una provincia... ---" ));
		add(new ElementoComboTipoUsuario("08", "Barcelona" ));
		add(new ElementoComboTipoUsuario("18", "Granada"));
		add(new ElementoComboTipoUsuario("28", "Madrid"));
		add(new ElementoComboTipoUsuario("38", "Tenerife"));
		add(new ElementoComboTipoUsuario("48", "Vizcaya"));
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

/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.entidad.ElementoComboTipoVia;

/**
 * @author cachorro
 *
 */
public final class ComboTipoVia extends ArrayList<ElementoComboTipoVia> implements Serializable {

	private final static int PRIMERA_VIA = 1;
	private final static int ULTIMA_VIA  = 2;
	
	public ComboTipoVia() {
		add(new ElementoComboTipoVia(String.valueOf(Constantes.ELEMENTO_NO_SELECCIONADO), "--- Seleccione una vía... ---" ));
		add(new ElementoComboTipoVia("1", "Calle" ));
		add(new ElementoComboTipoVia("2", "Plaza"));
		add(new ElementoComboTipoVia("3", "Avenida"));
		add(new ElementoComboTipoVia("4", "Paseo"));
		add(new ElementoComboTipoVia("5", "Ronda"));
		add(new ElementoComboTipoVia("6", "Calleja"));
	}

	
	public final static boolean elementoValido(String idVia) {
		boolean esValido = false;
		try {
			int id = Integer.parseInt(idVia);
			if ( (PRIMERA_VIA <= id)  && (ULTIMA_VIA <= 52) ) {
				esValido = true;
			}
		} catch (NumberFormatException e) {
			
		}
		return esValido;
	}
	
}

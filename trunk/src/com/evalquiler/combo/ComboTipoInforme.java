/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.entidad.ElementoComboTipoInforme;

/**
 * @author cachorro
 *
 */
public final class ComboTipoInforme extends ArrayList<ElementoComboTipoInforme> implements Serializable {
	
	public ComboTipoInforme() {
		add(new ElementoComboTipoInforme(String.valueOf(Constantes.ELEMENTO_NO_SELECCIONADO), "--- Seleccione un elemento... ---" ));
//		add(new ElementoComboTipoInforme("3", "Completo" ));
		add(new ElementoComboTipoInforme("1", "Respuestas de inquilinos"));
		add(new ElementoComboTipoInforme("2", "Respuestas de arrendadores"));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
//		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
		if ( ("1".equals(id)) || ("2".equals(id)) ) {			
			esValido = true;
		}
		
		return esValido;
	}
	
}

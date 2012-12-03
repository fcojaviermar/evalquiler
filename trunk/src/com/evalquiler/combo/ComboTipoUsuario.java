/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.entidad.ElementoComboTipoUsuario;

/**
 * @author cachorro
 *
 */
public final class ComboTipoUsuario extends ArrayList<ElementoComboTipoUsuario> implements Serializable {
	
	public ComboTipoUsuario() {
		add(new ElementoComboTipoUsuario(String.valueOf(Constantes.ELEMENTO_NO_SELECCIONADO), "--- Seleccione un elemento... ---" ));
		add(new ElementoComboTipoUsuario(Constantes.INQUILINO,  "Inquilino" ));
		add(new ElementoComboTipoUsuario(Constantes.ARRENDADOR, "Arrendador"));
//		add(new ElementoComboTipoUsuario("3", "Ambos"));
	}

	
	public final static boolean elementoValido(String id) {
		boolean esValido = false;
//		if ( ("1".equals(id)) || ("2".equals(id)) || ("3".equals(id)) ) {
		if ( (Constantes.INQUILINO.equals(id)) || (Constantes.ARRENDADOR.equals(id)) ) {			
			esValido = true;
		}
		
		return esValido;
	}
	
}

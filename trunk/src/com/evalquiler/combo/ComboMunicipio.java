/**
 * 
 */
package com.evalquiler.combo;

import java.io.Serializable;
import java.util.ArrayList;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.entidad.ElementoComboMunicipio;

/**
 * @author cachorro
 *
 */
public final class ComboMunicipio extends ArrayList<ElementoComboMunicipio> implements Serializable {

	
	public ComboMunicipio() {
		add(new ElementoComboMunicipio(String.valueOf(Constantes.ELEMENTO_NO_SELECCIONADO), "--- Seleccione un municipio... ---" ));
	}
	
}

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
	
	
	public ElementoComboMunicipio getId(final String indiceMunicipio) {
		boolean bEncontrado = false;
		ElementoComboMunicipio elemento = null;
		int indice = 0;
		while ( (!bEncontrado) && (indice <= this.size()) ) {
			elemento = this.get(indice);
			if (elemento.getIdMunicipio().equals(indiceMunicipio)) {
				bEncontrado = true;
			}
			indice = indice + 1;
		}
		
		return elemento;
	}
}

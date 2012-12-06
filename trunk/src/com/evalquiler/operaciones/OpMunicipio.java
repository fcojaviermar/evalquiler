/**
 * 
 */
package com.evalquiler.operaciones;

import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.dao.DaoMunicipio;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.municipio.NoHayMunicipiosExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpMunicipio {
	
	public static final ComboMunicipio obtenerMunicipio(final String idProvinciaIn) 
			throws ExcepcionEjecutarSentancia, NoHayMunicipiosExcepcion {
		
		ComboMunicipio comboMunicipio = DaoMunicipio.consultar(idProvinciaIn);
		if (comboMunicipio.isEmpty()) {
			throw new NoHayMunicipiosExcepcion(idProvinciaIn);
		}
			
		return comboMunicipio; 
	}
	
}

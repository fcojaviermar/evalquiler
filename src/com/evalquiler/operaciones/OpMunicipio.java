/**
 * 
 */
package com.evalquiler.operaciones;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.vivienda.CriteriosBusquedaViviendaActionForm;
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.dao.DaoMunicipio;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.municipio.NoHayMunicipiosExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpMunicipio {
	
	public static final ComboMunicipio obtenerMunicipio(ActionForm criteriosIn) 
			throws ExcepcionEjecutarSentancia, NoHayMunicipiosExcepcion {
		
		ComboMunicipio comboMunicipio = DaoMunicipio.consultar(criteriosIn);
		if (comboMunicipio.isEmpty()) {
			throw new NoHayMunicipiosExcepcion( ((CriteriosBusquedaViviendaActionForm)criteriosIn).getIdProvincia());
		}
			
		return comboMunicipio; 
	}
	
}

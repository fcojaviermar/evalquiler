/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.dao.DaoVivienda;

/**
 * @author cachorro
 *
 */
public final class OpVivienda {
	
	public static final Collection<DatosViviendaActionForm> consultarPorPk(ActionForm viviendaIn) {
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultarPorPk( ((DatosViviendaActionForm)viviendaIn).getIdVivienda());
		return listaViviendas; 
	}

	
	public static final Collection<DatosViviendaActionForm> consultar(ActionForm viviendaIn) {
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultar(viviendaIn, DaoVivienda.CONSULTA_VIVIENDA);
		return listaViviendas; 
	}

	
	public static final int insertar(ActionForm viviendaIn) {
		int iResultado = DaoVivienda.insertar((DatosViviendaActionForm)viviendaIn);
		return iResultado; 
	}
	

	public static final long ultimoIdVivienda() {
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultar(null, DaoVivienda.ULTIMO_ID_VIVIENDA);
		long lNumeroViviendas = listaViviendas.iterator().next().getIdVivienda();
		return lNumeroViviendas; 
	}
	
	
}

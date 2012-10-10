/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.dao.DaoVivienda;

/**
 * @author cachorro
 *
 */
public final class OpVivienda {
	
	public static final ArrayList<DatosViviendaActionForm> consultarPorPk(ActionForm viviendaIn) {
		ArrayList<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultarPorPk( ((DatosViviendaActionForm)viviendaIn).getIdVivienda());
		return listaViviendas; 
	}

	
	public static final ArrayList<DatosViviendaActionForm> consultar(ActionForm viviendaIn) {
		ArrayList<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultar(viviendaIn, DaoVivienda.CONSULTA_VIVIENDA);
		return listaViviendas; 
	}

	
	public static final int insertar(ActionForm viviendaIn) {
		int iResultado = DaoVivienda.insertar((DatosViviendaActionForm)viviendaIn);
		return iResultado; 
	}
	

	public static final long contar() {
		long lNumeroViviendas = DaoVivienda.contar();
		return lNumeroViviendas; 
	}
	
	
}

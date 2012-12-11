/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoVivienda;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.vivienda.EncontradasMuchasViviendasExcepcion;
import com.evalquiler.excepciones.vivienda.NoEncontradaViviendaConCriteriosExcepcion;
import com.evalquiler.excepciones.vivienda.NoExisteViviendaExcepcion;
import com.evalquiler.excepciones.vivienda.ViviendaNoGuardadaExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpVivienda {
	
	public static final Collection<DatosViviendaActionForm> consultarVivienda(final ActionForm viviendaIn, final String nifNavegante) 
			throws NoExisteViviendaExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultarPorPk( ((DatosViviendaActionForm)viviendaIn).getIdVivienda());
		
		if ( (null == listaViviendas) || (listaViviendas.isEmpty()) ) {
			throw new NoExisteViviendaExcepcion(String.valueOf(((DatosViviendaActionForm)viviendaIn).getIdVivienda()));
		}

//		if (nifNavegante.equals(listaViviendas.iterator().next().getNifPropietario())) {
//			listaViviendas.iterator().next().setEsElPropietario(true);
//		}
		
		return listaViviendas; 
	}

	
	public static final Collection<DatosViviendaActionForm> buscarVivienda(final ActionForm viviendaIn) 
			throws NoEncontradaViviendaConCriteriosExcepcion, ExcepcionEjecutarSentancia, EncontradasMuchasViviendasExcepcion, ExcepcionComun {
		
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultar(viviendaIn, DaoVivienda.CONSULTA_VIVIENDA);
		
		if ( (null == listaViviendas) || (listaViviendas.isEmpty()) ) {
			throw new NoEncontradaViviendaConCriteriosExcepcion(viviendaIn);
		}
		
		if (listaViviendas.size() > Constantes.NUMERO_REGISTROS_MAXIMO) {
			throw new EncontradasMuchasViviendasExcepcion(listaViviendas.size());
		}
		return listaViviendas; 
	}

	
	public static final int insertar(final ActionForm viviendaIn) 
			throws ViviendaNoGuardadaExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		int iResultado = DaoVivienda.insertar((DatosViviendaActionForm)viviendaIn);
		
		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new ViviendaNoGuardadaExcepcion(((DatosViviendaActionForm)viviendaIn));
		}

		
		return iResultado; 
	}
	

	public static final long ultimoIdVivienda() throws ExcepcionEjecutarSentancia, ExcepcionComun {
		Collection<DatosViviendaActionForm> listaViviendas = DaoVivienda.consultar(null, DaoVivienda.ULTIMO_ID_VIVIENDA);
		
		long lNumeroViviendas = 0;
		
		if (null != listaViviendas) {
			if (!listaViviendas.isEmpty())  {
				lNumeroViviendas = listaViviendas.iterator().next().getIdVivienda();
			}
		} else {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
												 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
												 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
												 "error.ejecutar.sentencia", 
												 "Se ha obtenido un resultado nulo al ejecutar la sentencia "+ DaoVivienda.ULTIMO_ID_VIVIENDA + " del DaoVivienda desde OpVivienda");
		}
		
		return lNumeroViviendas; 
	}
	
	
}

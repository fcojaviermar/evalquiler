/**
 * 
 */
package com.evalquiler.operaciones;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.informe.DatosSolicitudInformeActionForm;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.dao.DaoSolicitudInformes;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.informe.NoHaySolicitudesPendientesExcepcion;
import com.evalquiler.excepciones.informe.SolicitudinformeNoGuardadaExcepcion;

/**
 * @author cachorro
 *
 */
public final class OpSolicitudInforme {
	
	public static final Collection<DatosSolicitudInformeActionForm> consultarSolicitudesPendientes(ActionForm ClienteIn) 
		throws ExcepcionEjecutarSentancia, NoHaySolicitudesPendientesExcepcion, ExcepcionComun {
		
		Collection<DatosSolicitudInformeActionForm> listaInformes = DaoSolicitudInformes.consultar(null, DaoSolicitudInformes.SOLICITUDES_PENDIENTES);
		
		if ( (null != listaInformes) && (listaInformes.isEmpty()) ) {
			throw new NoHaySolicitudesPendientesExcepcion();
		} 
		
		return listaInformes; 
	}
	
	
	public static final int insertar(ActionForm solicitudInformeIn) 
		throws SolicitudinformeNoGuardadaExcepcion, ExcepcionEjecutarSentancia, ExcepcionComun {
		
		int iResultado = DaoSolicitudInformes.insertar((DatosSolicitudInformeActionForm) solicitudInformeIn);
		
		if (iResultado == Constantes.RESULTADO_NOOK) {
			throw new SolicitudinformeNoGuardadaExcepcion((DatosSolicitudInformeActionForm) solicitudInformeIn);
		}
		
		return iResultado; 
	}
	
	
	public static final long siguienteIdSolicitudInforme() throws ExcepcionEjecutarSentancia, ExcepcionComun {
		Collection<DatosSolicitudInformeActionForm> listaSolicitudes = 
													DaoSolicitudInformes.consultar(null, DaoSolicitudInformes.ULTIMO_ID_SOLICITUD);
		
		long lNumeroSolicitud = 0;
		
		if (null != listaSolicitudes) {
			if (!listaSolicitudes.isEmpty())  {
				lNumeroSolicitud = listaSolicitudes.iterator().next().getIdSolicitudInforme();
			}
		} else {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
												 	ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
												 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
												 "error.ejecutar.sentencia",
												 "Se ha obtenido un resultado nulo al ejecutar la sentencia " + 
												 DaoSolicitudInformes.ULTIMO_ID_SOLICITUD + " del DaoSolicitudInformes desde OpSolicitudInformes");
		}
		
		return lNumeroSolicitud+1; 
	}
	
}

/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.informe.DatosSolicitudInformeActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.utilidades.UtilidadesFechas;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoSolicitudInformes {
	
	public final static int SOLICITUDES_PENDIENTES 	= 1;
	public final static int ULTIMO_ID_SOLICITUD		= 2;
	
	private final static String CONSULTAR_SOLICITUD_PENDIENTES = "SELECT IDSOLICITUD, IDCLIENTE, IDVIVIENDA, IDTIPOINFORME, FECHAALTA " +
														   		 "FROM SOLICITUD WHERE ENVIADO = 0";
	
	private final static String SELECCIONAR_ULTIMA_SOLICITUD = "SELECT MAX(IDSOLICITUS) AS MAX_ID_SOLICITUD FROM SOLICITUD";	
	
	private final static String INSERTAR_SOLICITUD = "INSERT INTO SOLICITUD (IDSOLICITUD, IDCLIENTE, IDVIVIENDA, IDTIPOINFORME, FECHAALTA, ENVIADO) " +
												     "VALUES (?, ?, ?, ?, SYSDATE(), 0)";
	
	public static final Collection<DatosSolicitudInformeActionForm> consultar(final String idInforme, final int tipoConsulta) 
		throws ExcepcionEjecutarSentancia {
		
		Collection<DatosSolicitudInformeActionForm> listaSolicitudes = null;
		DatosSolicitudInformeActionForm solicitud  	  = null;
		DatosClienteActionForm 			datosCliente  = null;
		DatosViviendaActionForm 		datosVivienda = null;
		PreparedStatement 	   pstmt 	= null;
		ResultSet 		  	   rs 		= null;
		Connection conn = ConexionBD.getConnection();
		
		try {
			if (null != conn) {
				if (tipoConsulta == SOLICITUDES_PENDIENTES) {
					pstmt = conn.prepareStatement(CONSULTAR_SOLICITUD_PENDIENTES);
					if (null != pstmt) {
						rs = pstmt.executeQuery() ; 
						listaSolicitudes = new ArrayList<DatosSolicitudInformeActionForm>();
						while(rs.next()) {
							solicitud = new DatosSolicitudInformeActionForm();
							solicitud.setIdSolicitudInforme(rs.getLong("IDSOLICITUD"));
							datosCliente = new DatosClienteActionForm();
							datosCliente.setUser(rs.getString("IDCLIENTE"));
							solicitud.setDatosCliente(datosCliente);
							datosVivienda = new DatosViviendaActionForm();
							datosVivienda.setIdVivienda(rs.getLong("IDVIVIENDA"));
							solicitud.setDatosVivienda(datosVivienda);
							solicitud.setFechaAlta(UtilidadesFechas.getStringFromDate(rs.getDate("FECHAALTA")));
							
							listaSolicitudes.add(solicitud);
						}
					} else {
						throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
							 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
							 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
							 		"error.global.mesage", 
							 		"No se ha obtenido un preparedStatement en DaoSolicitudInformes.consultar.");
					}
					
				} else if (tipoConsulta == ULTIMO_ID_SOLICITUD) {
					pstmt = conn.prepareStatement(SELECCIONAR_ULTIMA_SOLICITUD);
					if (null != pstmt) {
						rs = pstmt.executeQuery() ; 
						while(rs.next()) {
							listaSolicitudes = new ArrayList<DatosSolicitudInformeActionForm>();
							solicitud = new DatosSolicitudInformeActionForm();
							solicitud.setIdSolicitudInforme(rs.getLong("MAX_ID_SOLICITUD"));
							listaSolicitudes.add(solicitud);
						}
					} else {
						throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
							 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
							 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
							 		"error.global.mesage", 
							 		"No se ha obtenido un preparedStatement en DaoVivienda.consultar para la sentencia solicitada con identificador: " + tipoConsulta + " .");
					}
					
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
						 		ConstantesCodigosExcepciones.CODIGO_SENTENCIA_SOLICITADA_NO_EXISTE)), 
						 		"error.global.mesage", 
						 		"DaoSolicitudInformes.consultar. No existe la sentencia solicitada con identificador: " + tipoConsulta + " .");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoSolicitudInformes.consultar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoSolicitudInformes.consultar\n" + e.getMessage());
		} 

		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoSolicitudInformes.consultar");
		return listaSolicitudes;
	}
	
	
	
	public static final int insertar(DatosSolicitudInformeActionForm datosSolicitudInforme) throws ExcepcionEjecutarSentancia {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();

		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_SOLICITUD);

				if (null != pstmt) {
					pstmt.setLong(1, datosSolicitudInforme.getIdSolicitudInforme());
					pstmt.setString(2, datosSolicitudInforme.getDatosCliente().getUser());
					pstmt.setLong(3, datosSolicitudInforme.getDatosVivienda().getIdVivienda());
					pstmt.setInt(4, datosSolicitudInforme.getIdTipoInforme());

					iResultado = pstmt.executeUpdate();
					if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
						conn.commit();
						iResultado = Constantes.RESULTADO_OK;
					} else {
						conn.rollback();
						iResultado = Constantes.RESULTADO_NOOK;
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoSolicitudInformes.insertar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoSolicitudInformes.insertar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_INFORMES.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoSolicitudInformes.insertar\n" + e.getMessage());
		} 
		
		ConexionBD.cerrarConexiones(conn, pstmt, "DaoSolicitudInformes.insertar");
		return iResultado;
	}

}

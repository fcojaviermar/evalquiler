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

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.vivienda.CriteriosBusquedaViviendaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoVivienda {

	public final static int CONSULTA_VIVIENDA 		 = 1;
	public final static int CONTAR_VIVIENDAS 		 = 2;
	public final static int ULTIMO_ID_VIVIENDA		 = 3;
	
	private final static String SELECT_CONTAR_VIVIENDAS = "SELECT COUNT(*) AS NUMEROVIVIENDAS FROM VIVIENDA";
		
	private final static String SELECCIONAR_ULTIMO_IDVIVIENDA = "SELECT MAX(IDVIVIENDA) AS MAX_ID_VIVIENDA FROM VIVIENDA";
	
	private final static String CONSULTAR_VIVIENDA_POR_PK = "SELECT IDVIVIENDA, IDTIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, PUERTA, " +
															"CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO " +
															"FROM VIVIENDA " +
															"WHERE IDVIVIENDA = ?";

	private final static String INSERTAR_VIVIENDA		  = "INSERT INTO VIVIENDA " +
															"(IDVIVIENDA, IDTIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, " +
															"PUERTA, CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO) " +
															"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private final static String CONSULTAR_VIVIENDA_POR_NIF_PROPIETARIO = "SELECT IDVIVIENDA, IDTIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, " +
																		 "ESCALERA, PLANTA, PUERTA, CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, " +
																		 "NIFPROPIETARIO " +
																		 "FROM VIVIENDA " +
																		 "WHERE PROVINCIA = ? AND PAIS = ? ";
	private final static String AND_NOMBREVIA = "AND NOMBREVIA LIKE ? ";
	private final static String AND_IDTIPOVIA = "AND IDTIPOVIA = ? ";
	private final static String AND_NUMEROVIA = "AND NUMEROVIA = ? ";
	private final static String AND_BLOQUE = "AND BLOQUE = ? ";
	private final static String AND_PORTAL = "AND PORTAL = ? ";
	private final static String AND_ESCALERA = "AND ESCALERA = ? ";
	private final static String AND_PLANTA = "AND PLANTA = ? ";
	private final static String AND_PUERTA = "AND PUERTA = ? ";
	private final static String AND_CODIGOPOSTAL = "AND CODIGOPOSTAL = ? ";
	private final static String AND_MUNICIPIO = "AND MUNICIPIO = ? ";
	private final static String AND_NIFPROPIETARIO = "AND NIFPROPIETARIO = ?";

	public static final Collection<DatosViviendaActionForm> consultarPorPk(final long idVivienda) throws ExcepcionEjecutarSentancia {
		Collection<DatosViviendaActionForm> listaVivienda = null;
		DatosViviendaActionForm vivienda = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_VIVIENDA_POR_PK);
				if (null != pstmt) {
					pstmt.setLong(1, idVivienda);
					rs = pstmt.executeQuery() ; 
					listaVivienda = new ArrayList<DatosViviendaActionForm>();
					while(rs.next()) {
						vivienda = new DatosViviendaActionForm();
						vivienda.setIdVivienda(rs.getLong("IDVIVIENDA"));
						vivienda.setIdTipoVia(rs.getInt("IDTIPOVIA"));
						vivienda.setNombreVia(rs.getString("NOMBREVIA"));
						vivienda.setNumeroVia(rs.getInt("NUMEROVIA"));
						vivienda.setBloque(rs.getString("BLOQUE"));
						vivienda.setPortal(rs.getInt("PORTAL"));
						vivienda.setEscalera(rs.getString("ESCALERA"));
						vivienda.setPlanta(rs.getString("PLANTA"));
						vivienda.setPuerta(rs.getString("PUERTA"));
						vivienda.setCodigoPostal(rs.getInt("CODIGOPOSTAL"));
						vivienda.setMunicipio(rs.getInt("MUNICIPIO"));
						vivienda.setProvincia(rs.getInt("PROVINCIA"));
						vivienda.setPais(rs.getInt("PAIS"));
						vivienda.setNifPropietario(rs.getString("NIFPROPIETARIO"));
						listaVivienda.add(vivienda);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoVivienda.consultarPorPk.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoVivienda.consultarPorPk.");				
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoVivienda.consultarPorPk\n" + e.getMessage());
		} 
		
		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoVivienda.consultarPorPk");
		return listaVivienda;
	}
	
	
	public static final int insertar(DatosViviendaActionForm vivienda) throws ExcepcionEjecutarSentancia {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_VIVIENDA);

				if (null != vivienda) {
					pstmt.setLong(1, vivienda.getIdVivienda());
					pstmt.setInt(2, vivienda.getIdTipoVia());
					pstmt.setString(3, vivienda.getNombreVia());
					pstmt.setInt(4, vivienda.getNumeroVia());
					pstmt.setString(5, vivienda.getBloque());
					pstmt.setInt(6, vivienda.getPortal());
					pstmt.setString(7, vivienda.getEscalera());
					pstmt.setString(8, vivienda.getPlanta());
					pstmt.setString(9, vivienda.getPuerta());
					pstmt.setInt(10, vivienda.getCodigoPostal());
					pstmt.setInt(11, vivienda.getMunicipio());
					pstmt.setInt(12, vivienda.getProvincia());
					pstmt.setInt(13, vivienda.getPais());
					pstmt.setString(14, vivienda.getNifPropietario());
					
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
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoVivienda.insertar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoVivienda.insertar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoVivienda.insertar\n" + e.getMessage());
		} 
		
		ConexionBD.cerrarConexiones(conn, pstmt, "DaoVivienda.insertar");
		return iResultado;
	}
	

	
	public static final Collection<DatosViviendaActionForm> consultar(final ActionForm vivienda, final int tipoConsulta) 
		throws ExcepcionEjecutarSentancia {
		Collection<DatosViviendaActionForm> listaVivienda = null;
		DatosViviendaActionForm viviendaAux = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		final String sentenciaEjecutar = obtenerSentencia(tipoConsulta, (CriteriosBusquedaViviendaActionForm)vivienda);
		Connection conn = ConexionBD.getConnection();
		
		try {
			if (null != conn) {
				if (tipoConsulta == CONSULTA_VIVIENDA) {
					pstmt = conn.prepareStatement(sentenciaEjecutar);
					pstmt = prepararWhere((CriteriosBusquedaViviendaActionForm)vivienda, pstmt, tipoConsulta);
					if (null != pstmt) {
						rs = pstmt.executeQuery() ; 
						listaVivienda = new ArrayList<DatosViviendaActionForm>();
						
						while(rs.next()) {
							viviendaAux = new DatosViviendaActionForm();
							viviendaAux.setIdVivienda(rs.getLong("IDVIVIENDA"));
							viviendaAux.setIdTipoVia(rs.getInt("IDTIPOVIA"));
							viviendaAux.setNombreVia(rs.getString("NOMBREVIA"));
							viviendaAux.setNumeroVia(rs.getInt("NUMEROVIA"));
							viviendaAux.setBloque(rs.getString("BLOQUE"));
							viviendaAux.setPortal(rs.getInt("PORTAL"));
							viviendaAux.setEscalera(rs.getString("ESCALERA"));
							viviendaAux.setPlanta(rs.getString("PLANTA"));
							viviendaAux.setPuerta(rs.getString("PUERTA"));
							viviendaAux.setCodigoPostal(rs.getInt("CODIGOPOSTAL"));
							viviendaAux.setMunicipio(rs.getInt("MUNICIPIO"));
							viviendaAux.setProvincia(rs.getInt("PROVINCIA"));
							viviendaAux.setPais(rs.getInt("PAIS"));
							viviendaAux.setNifPropietario(rs.getString("NIFPROPIETARIO"));
							listaVivienda.add(viviendaAux);
						}
					} else {
						throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
							 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
							 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
							 		"error.global.mesage", 
							 		"No se ha obtenido un preparedStatement en DaoVivienda.consultar para la sentencia solicitada con identificador: " + tipoConsulta + " .");
					}
					
				} else if (tipoConsulta == CONTAR_VIVIENDAS) {
					pstmt = conn.prepareStatement(sentenciaEjecutar);
					if (null != pstmt) {
						rs = pstmt.executeQuery() ;
						listaVivienda = new ArrayList<DatosViviendaActionForm>();
						while(rs.next()) {
							viviendaAux = new DatosViviendaActionForm();
							viviendaAux.setIdVivienda(rs.getLong("NUMEROVIVIENDAS"));
							listaVivienda.add(viviendaAux);
						}
					} else {
						throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
							 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
							 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
							 		"error.global.mesage", 
							 		"No se ha obtenido un preparedStatement en DaoVivienda.consultar para la sentencia solicitada con identificador: " + tipoConsulta + " .");
					}
					
				} else if (tipoConsulta == ULTIMO_ID_VIVIENDA) {
					pstmt = conn.prepareStatement(sentenciaEjecutar);
					if (null != pstmt) {
						rs = pstmt.executeQuery() ; 
						while(rs.next()) {
							listaVivienda = new ArrayList<DatosViviendaActionForm>();
							viviendaAux = new DatosViviendaActionForm();
							viviendaAux.setIdVivienda(rs.getLong("MAX_ID_VIVIENDA"));
							listaVivienda.add(viviendaAux);
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
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
						 		ConstantesCodigosExcepciones.CODIGO_SENTENCIA_SOLICITADA_NO_EXISTE)), 
						 		"error.global.mesage", 
						 		"DaoVivienda.consultar. No existe la sentencia solicitada con identificador: " + tipoConsulta + " .");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoVivienda.consultar.");			
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_VIVIENDA.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoVivienda.consultar\n" + e.getMessage());
		}
		
		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoVivienda.consultar");		
		return listaVivienda;
	}
	

	private final static PreparedStatement prepararWhere(final CriteriosBusquedaViviendaActionForm vivienda, PreparedStatement pstmt, 
														 final int sentencia) throws SQLException {
		switch (sentencia) {
			case 1: pstmt.setInt(1, vivienda.getProvincia());
					pstmt.setInt(2, vivienda.getPais());  
					int i=3;
					if (vivienda.tieneInfoNombreVia()) { 
						pstmt.setString(i, vivienda.getNombreViaLike());
						i = i + 1;
					}
					if (vivienda.tieneIdTipoVia()) { 
						pstmt.setInt(i, vivienda.getIdTipoVia());
						i = i + 1;
					}
					if (vivienda.tieneNumeroVia()) { 
						pstmt.setInt(i, vivienda.getNumeroVia());
						i = i + 1;
					}
					if (vivienda.tieneBloque()) { 
						pstmt.setString(i, vivienda.getBloqueLike());
						i = i + 1;
					}
					if (vivienda.tienePortal()) { 
						pstmt.setInt(i, vivienda.getPortal());
						i = i + 1;
					}
					if (vivienda.tieneEscalera()) { 
						pstmt.setString(i, vivienda.getEscaleraLike());
						i = i + 1;
					}
					if (vivienda.tienePlanta()) { 
						pstmt.setInt(i, vivienda.getPlanta());
						i = i + 1;
					}
					if (vivienda.tienePuerta()) { 
						pstmt.setString(i, vivienda.getPuertaLike());
						i = i + 1;
					}
					if (vivienda.tieneCodigoPostal()) { 
						pstmt.setInt(i, vivienda.getCodigoPostal());
						i = i + 1;
					}
					if (vivienda.tieneMunicipio()) { 
						pstmt.setInt(i, vivienda.getMunicipio());
						i = i + 1;
					}
					if (vivienda.tieneNifPropietario()) { 
						pstmt.setString(i, vivienda.getNifPropietarioLike());
						i = i + 1;
					}
					break;
			default:break; 
		}
		return pstmt;
	}

	
	private final static String obtenerSentencia(final int sentencia, final CriteriosBusquedaViviendaActionForm vivienda) {
		String sentenciaEjecutar ="";
		switch (sentencia) {
			case CONSULTA_VIVIENDA: sentenciaEjecutar = CONSULTAR_VIVIENDA_POR_NIF_PROPIETARIO;
					if (vivienda.tieneInfoNombreVia()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_NOMBREVIA);
					if (vivienda.tieneIdTipoVia()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_IDTIPOVIA);
					if (vivienda.tieneNumeroVia()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_NUMEROVIA);
					if (vivienda.tieneBloque()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_BLOQUE);
					if (vivienda.tienePortal()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_PORTAL);
					if (vivienda.tieneEscalera()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_ESCALERA);
					if (vivienda.tienePlanta()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_PLANTA);
					if (vivienda.tienePuerta()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_PUERTA);
					if (vivienda.tieneCodigoPostal()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_CODIGOPOSTAL);
					if (vivienda.tieneMunicipio()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_MUNICIPIO);
					if (vivienda.tieneNifPropietario()) 
						sentenciaEjecutar = sentenciaEjecutar.concat(AND_NIFPROPIETARIO);
					break;
			case CONTAR_VIVIENDAS: sentenciaEjecutar = SELECT_CONTAR_VIVIENDAS;
					break;
			case ULTIMO_ID_VIVIENDA: sentenciaEjecutar = SELECCIONAR_ULTIMO_IDVIVIENDA;
					break;
			default:break; 
		}
		return sentenciaEjecutar;
	}	
}

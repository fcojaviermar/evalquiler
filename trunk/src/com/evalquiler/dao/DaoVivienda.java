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

	

	private final static String CONSULTAR_VIVIENDA 		  = "SELECT IDVIVIENDA, IDTIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, " +
															"PUERTA, CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO " +
															"FROM VIVIENDA " +
															"WHERE IDTIPOVIA = ? AND NOMBREVIA = ? AND NUMEROVIA = ? AND BLOQUE = ? " +
															"AND PORTAL = ? AND ESCALERA = ? AND PLANTA = ? AND PUERTA = ? AND CODIGOPOSTAL = ? " +
															"AND MUNICIPIO = ? AND PROVINCIA = ? AND PAIS = ? AND NIFPROPIETARIO = ?";	
	
	public static final Collection<DatosViviendaActionForm> consultarPorPk(final long idVivienda) {
		Collection<DatosViviendaActionForm> listaVivienda = new ArrayList<DatosViviendaActionForm>();
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
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()) ;
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Se ha producido un error cerrando rs: ".concat(e.getMessage())) ;
			}
			try {
				if (null != pstmt) {
					pstmt.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando pstmt: ".concat(e.getMessage())) ;
			}
			
			try {
				if (null != conn) {
					conn.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando conn: ".concat(e.getMessage())) ;
			}			
			
			return listaVivienda;
		}
	}
	
	
	public static final int insertar(DatosViviendaActionForm vivienda) {
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
						System.out.println("Se ha insertado el cliente.");
						conn.commit();
						iResultado = Constantes.RESULTADO_OK;
					} else {
						System.out.println("No se ha insertado el cliente.");
						iResultado = Constantes.RESULTADO_NOOK;
					}
				} else {

				}
			} else {

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()) ;
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		} finally {
			try {
				if (null != pstmt) {
					pstmt.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando pstmt: ".concat(e.getMessage())) ;
			}
			
			try {
				if (null != conn) {
					conn.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando conn: ".concat(e.getMessage())) ;
			}			
			
			return iResultado;
		}
	}
	

	public static final Collection<DatosViviendaActionForm> consultar(final ActionForm vivienda, final int sentencia) {
		Collection<DatosViviendaActionForm> listaVivienda = null;
		DatosViviendaActionForm viviendaAux = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		final String sentenciaEjecutar = obtenerSentencia(sentencia, (CriteriosBusquedaViviendaActionForm)vivienda);
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(sentenciaEjecutar);
				if (null != pstmt) {
					if (sentencia == CONSULTA_VIVIENDA) {
    					pstmt = prepararWhere((CriteriosBusquedaViviendaActionForm)vivienda, pstmt, sentencia);
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
					} else if (sentencia == CONTAR_VIVIENDAS) {
						pstmt = conn.prepareStatement(SELECCIONAR_ULTIMO_IDVIVIENDA);
						if (null != pstmt) {
							rs = pstmt.executeQuery() ;
							listaVivienda = new ArrayList<DatosViviendaActionForm>();
							while(rs.next()) {
								viviendaAux = new DatosViviendaActionForm();
								viviendaAux.setIdVivienda(rs.getLong("NUMEROVIVIENDAS"));
								listaVivienda.add(viviendaAux);
							}
						} else {
							System.out.println("No se ha podido obtener un pstmt valido.") ;
						}
					} else if (sentencia == ULTIMO_ID_VIVIENDA) {
						pstmt = conn.prepareStatement(SELECCIONAR_ULTIMO_IDVIVIENDA);
						if (null != pstmt) {
							rs = pstmt.executeQuery() ; 
							while(rs.next()) {
								listaVivienda = new ArrayList<DatosViviendaActionForm>();
								viviendaAux = new DatosViviendaActionForm();
								viviendaAux.setIdVivienda(rs.getLong("MAX_ID_VIVIENDA"));
								listaVivienda.add(viviendaAux);
							}
						} else {
							System.out.println("No se ha podido obtener un pstmt valido.") ;
						}

					} else {
						//Error
					}

				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()) ;
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Se ha producido un error cerrando rs: ".concat(e.getMessage())) ;
			}
			try {
				if (null != pstmt) {
					pstmt.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando pstmt: ".concat(e.getMessage())) ;
			}
			
			try {
				if (null != conn) {
					conn.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando conn: ".concat(e.getMessage())) ;
			}			
			
			return listaVivienda;
		}
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

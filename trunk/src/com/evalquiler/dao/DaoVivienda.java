/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoVivienda {
	
	private final static String CONTAR_VIVIENDAS = "SELECT COUNT(*) AS NUMEROVIVIENDAS FROM VIVIENDA";
	
	private final static String CONSULTAR_VIVIENDA_POR_PK = "SELECT IDVIVIENDA, TIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, PUERTA, " +
															"CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO " +
															"FROM VIVIENDA WHERE IDVIVIENDA = ?";

	private final static String INSERTAR_VIVIENDA		  = "INSERT INTO VIVIENDA " +
															"(IDVIVIENDA, TIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, " +
															"PUERTA, CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO) " +
															"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private final static String CONSULTAR_VIVIENDA 		  = "SELECT IDVIVIENDA, TIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, PUERTA, " +
															"CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO " +
															"FROM VIVIENDA WHERE TIPOVIA = ? AND NOMBREVIA = ? AND NUMEROVIA = ? AND BLOQUE = ? " +
															"AND PORTAL = ? AND ESCALERA = ? AND PLANTA = ? AND PUERTA = ? AND CODIGOPOSTAL = ?" +
															"AND MUNICIPIO = ? AND PROVINCIA = ? AND PAIS = ? AND NIFPROPIETARIO = ?";
	
	private final static String CONSULTAR_VIVIENDA_POR_NIF_PROPIETARIO 		  
														  = "SELECT IDVIVIENDA, TIPOVIA, NOMBREVIA, NUMEROVIA, BLOQUE, PORTAL, ESCALERA, PLANTA, PUERTA, " +
														    "CODIGOPOSTAL, MUNICIPIO, PROVINCIA, PAIS, NIFPROPIETARIO " +
														    "FROM VIVIENDA WHERE TIPOVIA = ? AND NOMBREVIA = ? AND NUMEROVIA = ? AND BLOQUE = ? " +
														    "AND PORTAL = ? AND ESCALERA = ? AND PLANTA = ? AND PUERTA = ? AND CODIGOPOSTAL = ?" +
														    "AND MUNICIPIO = ? AND PROVINCIA = ? AND PAIS = ? AND NIFPROPIETARIO = ?";
	
	public static final ArrayList<DatosViviendaActionForm> consutarPorPk(final long idVivienda) {
		ArrayList<DatosViviendaActionForm> listaVivienda = new ArrayList<DatosViviendaActionForm>();
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
						vivienda.setTipoVia(rs.getInt("TIPOVIA"));
						vivienda.setNombreVia(rs.getString("NOMBREVIA"));
						vivienda.setNumeroVia(rs.getInt("NUMEROVIA"));
						vivienda.setBloque(rs.getString("BLOQUE"));
						vivienda.setPortal(rs.getInt("PORTAL"));
						vivienda.setEscalera(rs.getString("ESCALERA"));
						vivienda.setPlanta(rs.getInt("PLANTA"));
						vivienda.setPuerta(rs.getString("PUERTA"));
						vivienda.setCodigoPostal(rs.getInt("CODIGOPOSTAL"));
						vivienda.setMunicipio(rs.getInt("MUNICIPIO"));
						vivienda.setProvincia(rs.getInt("PROVINCIA"));
						vivienda.setPais(rs.getInt("PAIS"));
						vivienda.setNifPropietario(rs.getString("NIFPROPIETARIO"));
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
					pstmt.setInt(2, vivienda.getTipoVia());
					pstmt.setString(3, vivienda.getNombreVia());
					pstmt.setInt(4, vivienda.getNumeroVia());
					pstmt.setString(5, vivienda.getBloque());
					pstmt.setInt(6, vivienda.getPortal());
					pstmt.setString(7, vivienda.getEscalera());
					pstmt.setInt(8, vivienda.getPlanta());
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
						iResultado = 0;
					} else {
						System.out.println("No se ha insertado el cliente.");
						iResultado = 1;
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
	
	private final static String obtenerSentencia(final int sentencia) {
		String sentenciaEjecutar ="";
		switch (sentencia) {
			case 1: sentenciaEjecutar = CONSULTAR_VIVIENDA;
					break;
			case 2: sentenciaEjecutar = CONSULTAR_VIVIENDA_POR_NIF_PROPIETARIO;
					break;
			default:break; 
		}
		return sentenciaEjecutar;
	}
	
	private final static PreparedStatement prepararWhere(final DatosViviendaActionForm vivienda, PreparedStatement pstmt, 
														 final int sentencia) throws SQLException {
		switch (sentencia) {
			case 1: pstmt.setLong(1, vivienda.getIdVivienda());
					break;
			case 2: pstmt.setInt(1, vivienda.getTipoVia());
			    	pstmt.setString(2, vivienda.getNombreVia());
			    	pstmt.setInt(3, vivienda.getNumeroVia());
			    	pstmt.setString(4, vivienda.getBloque());
			    	pstmt.setInt(5, vivienda.getPortal());
			    	pstmt.setString(6, vivienda.getEscalera());
			    	pstmt.setInt(7, vivienda.getPlanta());
			    	pstmt.setString(8, vivienda.getPuerta());
			    	pstmt.setInt(9, vivienda.getCodigoPostal());
			    	pstmt.setInt(10, vivienda.getMunicipio());
			    	pstmt.setInt(11, vivienda.getProvincia());
			    	pstmt.setInt(12, vivienda.getPais());
			    	pstmt.setString(13, vivienda.getNifPropietario());
					break;
			default:break; 
		}
		return pstmt;
	}
	
	public static final ArrayList<DatosViviendaActionForm> consultar(final DatosViviendaActionForm vivienda, final int sentencia) {
		ArrayList<DatosViviendaActionForm> listaVivienda = new ArrayList<DatosViviendaActionForm>();
		DatosViviendaActionForm viviendaAux = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		final String sentenciaEjecutar = obtenerSentencia(sentencia);
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(sentenciaEjecutar);
				if (null != pstmt) {
					pstmt = prepararWhere(vivienda, pstmt, sentencia);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						viviendaAux = new DatosViviendaActionForm();
						viviendaAux.setIdVivienda(rs.getLong("IDVIVIENDA"));
						viviendaAux.setTipoVia(rs.getInt("TIPOVIA"));
						viviendaAux.setNombreVia(rs.getString("NOMBREVIA"));
						viviendaAux.setNumeroVia(rs.getInt("NUMEROVIA"));
						viviendaAux.setBloque(rs.getString("BLOQUE"));
						viviendaAux.setPortal(rs.getInt("PORTAL"));
						viviendaAux.setEscalera(rs.getString("ESCALERA"));
						viviendaAux.setPlanta(rs.getInt("PLANTA"));
						viviendaAux.setPuerta(rs.getString("PUERTA"));
						viviendaAux.setCodigoPostal(rs.getInt("CODIGOPOSTAL"));
						viviendaAux.setMunicipio(rs.getInt("MUNICIPIO"));
						viviendaAux.setProvincia(rs.getInt("PROVINCIA"));
						viviendaAux.setPais(rs.getInt("PAIS"));
						viviendaAux.setNifPropietario(rs.getString("NIFPROPIETARIO"));
						listaVivienda.add(viviendaAux);
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
	

	public static final long contar() {
		long numeroViviendas = 0;
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONTAR_VIVIENDAS);
				if (null != pstmt) {
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						numeroViviendas = rs.getLong("NUMEROVIVIENDAS");
					}
				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				//Se debería lanzar una excepción para saber que no se ha obtenido una conexión válida.
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
			
			return numeroViviendas;
		}
	}

	
}

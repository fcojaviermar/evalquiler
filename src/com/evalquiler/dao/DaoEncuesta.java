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

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoEncuesta {
	
	private final static String CONSULTAR_ENCUESTA_POR_PK = "";
	private final static String CONSULTAR_ENCUESTA_POR_PARA_QUIEN_ES = "";

	
	public static final Collection<DatosEncuestaActionForm> consultarPorPk(final String idEncuesta) {
		Collection<DatosEncuestaActionForm> datosEncuesta = new ArrayList<DatosEncuestaActionForm>();
		DatosEncuestaActionForm encuesta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTA_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idEncuesta);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						encuesta = new DatosEncuestaActionForm();
						datosEncuesta.add(encuesta);
					}
				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				datosEncuesta = null;
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
			
			return datosEncuesta;
		}
	}

	
	public static final Collection<DatosEncuestaActionForm> consultar(final String paraQuienEs) {
		Collection<DatosEncuestaActionForm> datosEncuesta = new ArrayList<DatosEncuestaActionForm>();
		DatosEncuestaActionForm encuesta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTA_POR_PARA_QUIEN_ES);
				if (null != pstmt) {
					pstmt.setString(1, paraQuienEs);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						encuesta = new DatosEncuestaActionForm();
						
						datosEncuesta.add(encuesta);
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
			
			return datosEncuesta;
		}
	}
	
	
}

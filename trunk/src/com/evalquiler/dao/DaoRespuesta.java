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

import com.evalquiler.actionforms.encuesta.RespuestasPreguntaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoRespuesta {
	
	private final static String CONSULTAR_RESPUESTA_POR_PK = "";
	private final static String CONSULTAR_RESPUESTA_POR_ID_PREGUNTA = "";

	
	public static final Collection<RespuestasPreguntaActionForm> consultarPorPk(final String idRespuesta) {
		Collection<RespuestasPreguntaActionForm> respuestasPregunta = new ArrayList<RespuestasPreguntaActionForm>();
		RespuestasPreguntaActionForm respuesta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_RESPUESTA_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idRespuesta);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						respuesta = new RespuestasPreguntaActionForm();
						respuestasPregunta.add(respuesta);
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
			
			return respuestasPregunta;
		}
	}

	
	public static final Collection<RespuestasPreguntaActionForm> consultar(final String idPregunta) {
		Collection<RespuestasPreguntaActionForm> respuestasPregunta = new ArrayList<RespuestasPreguntaActionForm>();
		RespuestasPreguntaActionForm respuesta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_RESPUESTA_POR_ID_PREGUNTA);
				if (null != pstmt) {
					pstmt.setString(1, idPregunta);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						respuesta = new RespuestasPreguntaActionForm();
						
						respuestasPregunta.add(respuesta);
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
			
			return respuestasPregunta;
		}
	}
	
	
}

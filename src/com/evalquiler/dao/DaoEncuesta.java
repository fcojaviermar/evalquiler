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
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.RespuestasPreguntaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoEncuesta {
	
	private final static String CONSULTAR_ENCUESTA_COMPLETA_POR_PK = "SELECT A.IDENCUESTA, A.TITULO, C.IDPREGUNTA, C.DESCRIPCION AS DESC_PREG, E.IDRESPUESTA, " +
																	 "E.DESCRIPCION AS DESC_RESP " + 
																	 "FROM ENCUESTA A, PREGUNTAS_ENCUESTA B, PREGUNTA C, RESPUESTAS_PREGUNTA D, RESPUESTA E " +
																	 "WHERE A.IDENCUESTA = ? AND A.IDENCUESTA = B.IDENCUESTA AND B.IDPREGUNTA = C.IDPREGUNTA " +
																	 "AND C.IDPREGUNTA = D.IDPREGUNTA AND D.IDRESPUESTA = E.IDRESPUESTA";
	private final static String CONSULTAR_ENCUESTA_POR_PARA_QUIEN_ES = "";

	
	public static final Collection<DatosEncuestaActionForm> consultarPorPk(final int idEncuesta) {
		Collection<DatosEncuestaActionForm> datosEncuesta = new ArrayList<DatosEncuestaActionForm>();
		DatosEncuestaActionForm 	 encuesta  = null;
		RespuestasPreguntaActionForm respuesta = null;
		PreguntasEncuestaActionForm  pregunta  = null;
		int idPregunta 	  = 0;
		int idEncuestaAux = 0;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTA_COMPLETA_POR_PK);
				if (null != pstmt) {
					pstmt.setInt(1, idEncuesta);
					rs = pstmt.executeQuery() ;
					
					while(rs.next()) {
						respuesta = new RespuestasPreguntaActionForm();
						respuesta.setIdRespuesta(rs.getInt("IDRESPUESTA"));
						respuesta.setDescripcion(rs.getString("DESC_RESP"));
						
						int idPreguntaAux = rs.getInt("IDPREGUNTA");
						if (idPregunta != idPreguntaAux) {
							//Cada vez que se cambia de pregunta, excepto la primera vez que se entra hay que añadir la pregunta a la encuesta.
							if (0 != idPregunta) {
								if (null == encuesta.getPreguntas()) {
									encuesta.setPreguntas(new ArrayList<PreguntasEncuestaActionForm>());
								}
								encuesta.getPreguntas().add(pregunta);
							}
							pregunta = new PreguntasEncuestaActionForm();
							pregunta.setIdPregunta(idPreguntaAux);
							pregunta.setDescripcion(rs.getString("DESC_PREG"));

							if (null == pregunta.getRespuestas()) {
								pregunta.setRespuestas(new ArrayList<RespuestasPreguntaActionForm>());
							}
							pregunta.getRespuestas().add(respuesta);
							idPregunta = idPreguntaAux;
						} else {
							pregunta.getRespuestas().add(respuesta);
							idPregunta = idPreguntaAux;
						}

						if (idEncuesta != idEncuestaAux) {
							encuesta = new DatosEncuestaActionForm();
							encuesta.setIdEncuesta(rs.getInt("IDENCUESTA"));
							encuesta.setTitulo(rs.getString("TITULO"));
							idEncuestaAux = rs.getInt("IDENCUESTA");
						}
					}
					
					if (null != pregunta) {
						encuesta.getPreguntas().add(pregunta);
					}
					if (null != encuesta) {
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

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

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.RespuestasPreguntaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.NoRecuperadaEncuestaExcepcion;
import com.evalquiler.excepciones.encuesta.NoRecuperadasPreguntasParaEncuestaExcepcion;


/**
 * @author cachorro
 *
 */
public class DaoEncuesta {
	
		private final static String CONSULTAR_ENCUESTA_POR_PARA_QUIEN_ES = "SELECT A.IDENCUESTA, A.TITULO, B.IDPREGUNTA, B.DESCRIPCION AS DESC_PREG, C.IDRESPUESTA, " +
																	   "C.DESCRIPCION AS DESC_RESP " +
																	   "FROM ENCUESTA A, PREGUNTA B, RESPUESTA C, PREGUNTAS_ENCUESTA D " +
																	   "WHERE A.IDTIPOUSUARIO = ? AND A.IDENCUESTA = D.IDENCUESTA AND B.IDPREGUNTA = D.IDPREGUNTA " +
																	   "AND C.IDRESPUESTA = D.IDRESPUESTA";

	public final static String CONSULTAR_PARA_QUIEN_ES_ENCUESTA = "1";
	
	
	public static final Collection<DatosEncuestaActionForm> consultar(ActionForm objetoIn, final String tipoConsulta) 
		throws ExcepcionEjecutarSentancia, NoRecuperadaEncuestaExcepcion, NoRecuperadasPreguntasParaEncuestaExcepcion {
		
		UtilidadesFicheros.escribir("DaoEncuesta.consultar");
		Collection<DatosEncuestaActionForm> datosEncuesta	= null;
		DatosEncuestaActionForm 			encuesta 		= null;
		RespuestasPreguntaActionForm 		respuesta 		= null;
		PreguntasEncuestaActionForm  		pregunta  		= null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection 		  conn  = null;
		int idPregunta 	  = 0;
		int idEncuestaAux = 0;
		int idEncuesta    = 0;
		
		try {
			if (tipoConsulta.equals(CONSULTAR_PARA_QUIEN_ES_ENCUESTA)) {
				conn = ConexionBD.getConnection();
				
    			if (null != conn) {
    				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTA_POR_PARA_QUIEN_ES);
    				
    				if (null != pstmt) {
    					pstmt.setInt(1, ((DatosUsuarioActionForm)objetoIn).getIdTipoUsuario());
    					rs = pstmt.executeQuery() ; 
    					datosEncuesta = new ArrayList<DatosEncuestaActionForm>();
    					
    					while(rs.next()) {
    						idEncuesta = rs.getInt("IDENCUESTA");
    						if (idEncuesta != idEncuestaAux) {
    							encuesta = new DatosEncuestaActionForm();
    							encuesta.setIdEncuesta(rs.getInt("IDENCUESTA"));
    							encuesta.setTitulo(rs.getString("TITULO"));
    							idEncuestaAux = encuesta.getIdEncuesta();
    							encuesta.setPreguntas(new ArrayList<PreguntasEncuestaActionForm>());
    							UtilidadesFicheros.escribir("Hay encuesta");
    						}

    						int idPreguntaAux = rs.getInt("IDPREGUNTA");
    						if (idPregunta != idPreguntaAux) {
    							//Cada vez que se cambia de pregunta, excepto la primera vez que se entra hay que añadir la pregunta a la encuesta.
    							if (null != pregunta) {
    								encuesta.getPreguntas().add(pregunta);
    							}
    							pregunta = new PreguntasEncuestaActionForm();
    							pregunta.setIdPregunta(idPreguntaAux);
    							pregunta.setDescripcion(rs.getString("DESC_PREG"));
    							
//    							if (null == pregunta.getRespuestas()) {
    								pregunta.setRespuestas(new ArrayList<RespuestasPreguntaActionForm>());
//    							}
    							idPregunta = idPreguntaAux;
    							
    						} 
    						
    						respuesta = new RespuestasPreguntaActionForm();
    						respuesta.setIdRespuesta(rs.getInt("IDRESPUESTA"));
    						respuesta.setDescripcion(rs.getString("DESC_RESP"));
							pregunta.getRespuestas().add(respuesta);    						

    					}
    					if (null != respuesta) {
//    						pregunta.getRespuestas().add(respuesta);
        					if (null != pregunta) {
        						encuesta.getPreguntas().add(pregunta);
            					if (null != encuesta) {
            						datosEncuesta.add(encuesta);
            					} 
        					} 
    					} else {
    						//Ha habido algún problema porque la última respuesta no puede ser nula.
    					}
    				} else {
    					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
    						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
    						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
    						 		"error.global.mesage", 
    						 		"No se ha obtenido un preparedStatement en DaoEncuesta.consultar.");
    				}
    			} else {
    				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
    					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
    					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
    					 		"error.global.mesage", 
    					 		"No se ha obtenido una conexi�n en DaoEncuesta.consultar.");
    			}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"El tipo de sentencia que se quiere ejecutar no existe: " + tipoConsulta);
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
												 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
												 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
												 "error.global.mesage", 
												 "DaoEncuesta.consultarPorPk\n" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
				 		ConstantesCodigosExcepciones.CODIGO_EXCEPTION)), 
				 "error.global.mesage", 
				 "Exception: DaoEncuesta.consultarPorPk\n" + e.getMessage() + "\n");
			
		} 

		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoEncuesta.consultar");
		return datosEncuesta;

	}
	
	
}

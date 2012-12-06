/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.evalquiler.combo.ComboProvincia;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoProvincia {
	
	private final static String CONSULTAR_PROVINCIAS = "SELECT IDPROVINCIA, DESCRIPCION FROM PROVINCIA";
	
	public static final ComboProvincia consultar() throws ExcepcionEjecutarSentancia {
		ElementoComboProvincia provincia = null;
		ComboProvincia comboProvinca  	 = null;
		PreparedStatement 	   pstmt 	 = null;
		ResultSet 		  	   rs 		 = null;
		Connection conn = ConexionBD.getConnection();
		
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_PROVINCIAS);
				if (null != pstmt) {

					rs = pstmt.executeQuery() ; 
					comboProvinca = new ComboProvincia();
					while(rs.next()) {
						provincia = new ElementoComboProvincia(rs.getString("IDPROVINCIA"), 
															   rs.getString("DESCRIPCION"));
						
						comboProvinca.add(provincia);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoProvincia.consultar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexion en DaoProvincia.consultar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoProvincia.consultar\n" + e.getMessage());
		} 

		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoProvincia.consultar");
		return comboProvinca;
	}
	
	
}

/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoMunicipio {
	
	private final static String CONSULTAR_PROVINCIAS = "SELECT IDMUNICIPIO, DESCRIPCION FROM MUNICIPIO " +
													   "WHERE IDPROVINCIA = ?";
	
	public static final ComboMunicipio consultar(final String idProvinciaIn) throws ExcepcionEjecutarSentancia {
		ElementoComboMunicipio municipio = null;
		ComboMunicipio comboMunicipio  	 = null;
		PreparedStatement 	   pstmt 	 = null;
		ResultSet 		  	   rs 		 = null;
		Connection conn = ConexionBD.getConnection();
		
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_PROVINCIAS);
				if (null != pstmt) {
					pstmt.setString(1, idProvinciaIn);
					rs = pstmt.executeQuery() ; 
					comboMunicipio = new ComboMunicipio();
					while(rs.next()) {
						municipio = new ElementoComboMunicipio(rs.getString("IDMUNICIPIO"), 
															   rs.getString("DESCRIPCION"));
						
						comboMunicipio.add(municipio);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoMunicipio.consultar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexion en DaoMunicipio.consultar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoMunicipio.consultar\n" + e.getMessage());
		} 

		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoMunicipio.consultar");
		return comboMunicipio;
	}
	
	
}

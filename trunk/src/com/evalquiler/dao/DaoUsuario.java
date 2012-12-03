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

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoUsuario {
	
	private final static String CONSULTAR_USUARIO_POR_PK = "SELECT IDUSUARIO, PASSWORD, IDTIPODOCUMENTO, NIFCIF, EMAIL, IDTIPOUSUARIO, FECHAALTA " +
														   "FROM USUARIO WHERE IDUSUARIO = ?";
	private final static String INSERTAR_USUARIO = "INSERT INTO USUARIO (IDUSUARIO, PASSWORD, IDTIPODOCUMENTO, NIFCIF, EMAIL, IDTIPOUSUARIO, FECHAALTA) " +
												   "VALUES (?, ?, ?, ?, ?, ?, SYSDATE())";
	
	public static final Collection<DatosUsuarioActionForm> consutarPorPk(final String idUsuario) throws ExcepcionEjecutarSentancia {
		Collection<DatosUsuarioActionForm> listaUsuario = null;
		DatosUsuarioActionForm usuario = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_USUARIO_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idUsuario);
					rs = pstmt.executeQuery() ; 
					listaUsuario = new ArrayList<DatosUsuarioActionForm>();
					while(rs.next()) {
						usuario = new DatosUsuarioActionForm();
						usuario.setUser(rs.getString("IDUSUARIO"));
						usuario.setPassword(rs.getString("PASSWORD"));
						usuario.setIdTipoDocumento(rs.getInt("IDTIPODOCUMENTO"));
						usuario.setNifcif(rs.getString("NIFCIF"));
						usuario.setEmail(rs.getString("EMAIL"));
						usuario.setIdTipoUsuario(rs.getInt("IDTIPOUSUARIO"));
						
						listaUsuario.add(usuario);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoUsuario.consultarPorPk.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoUsuario.consultarPorPk.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoUsuario.consultarPorPk\n" + e.getMessage());
		}
		
		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoUsuario.consultarPorPk");
		return listaUsuario;

	}
	
	
	public static final int insertar(DatosUsuarioActionForm usuario) throws ExcepcionEjecutarSentancia {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_USUARIO);

				if (null != usuario) {
					pstmt.setString(1, usuario.getUser());
					pstmt.setString(2, usuario.getPassword());
					pstmt.setInt(3, usuario.getIdTipoDocumento());
					pstmt.setString(4, usuario.getNifcif());
					pstmt.setString(5, usuario.getEmail());
					pstmt.setInt(6, usuario.getIdTipoUsuario());

					iResultado = pstmt.executeUpdate();

					if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
						System.out.println("Se han insertado registros.");
						conn.commit();
						iResultado = Constantes.RESULTADO_OK;
					} else {
						System.out.println("No se han insertado registros.");
						iResultado = Constantes.RESULTADO_NOOK;
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoUsuario.insertar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoUsuario.insertar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_USUARIO.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoUsuario.insertar\n" + e.getMessage());
		} 
		
		ConexionBD.cerrarConexiones(conn, pstmt, "DaoUsuario.insertar");
		return iResultado;

	}

}

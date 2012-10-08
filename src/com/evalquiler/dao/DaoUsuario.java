/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoUsuario {
	
	private final static String CONSULTAR_USUARIO_POR_PK = "SELECT IDUSUARIO, PASSWORD FROM USUARIO WHERE IDUSUARIO = ?";
	private final static String INSERTAR_USUARIO = "INSERT INTO USUARIO (IDUSUARIO, PASSWORD, TIPODOCUMENTO, NIFCIF, EMAIL, FECHAALTA) " +
												   "VALUES (?, ?, ?, ?, ?, SYSDATE())";
	
	public static final ArrayList<DatosInicioSesionActionForm> consutarPorPk(final String idUsuario) {
		ArrayList<DatosInicioSesionActionForm> listaUsuario = new ArrayList<DatosInicioSesionActionForm>();
		DatosInicioSesionActionForm usuario = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				System.out.println("Obtenida conexion");
				pstmt = conn.prepareStatement(CONSULTAR_USUARIO_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idUsuario);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						usuario = new DatosInicioSesionActionForm();
						usuario.setUser(rs.getString("IDUSUARIO"));
						usuario.setPassword(rs.getString("PASSWORD"));
						listaUsuario.add(usuario);
					}

					System.out.println("Datos obtenidos");
					System.out.println("Usuario: " + usuario.getUser());
					System.out.println("Psw: " + usuario.getPassword());
				} else {
					System.out.println("No se ha podido obtener una conexi�n v�lida. pstmt") ;
				}
			} else {
				listaUsuario = null;
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
			
			return listaUsuario;
		}
	}
	
	
	public static final int insertar(DatosUsuarioActionForm usuario) {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_USUARIO);

				if (null != usuario) {
					pstmt.setString(1, usuario.getUser());
					pstmt.setString(2, usuario.getPassword());
					pstmt.setString(3, usuario.getId());
					pstmt.setString(4, usuario.getNifcif());
					pstmt.setString(5, usuario.getEmail());

					iResultado = pstmt.executeUpdate();

					if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
						System.out.println("Se han insertado registros.");
						conn.commit();
						iResultado = 0;
					} else {
						System.out.println("No se han insertado registros.");
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

}

package com.evalquiler.comun.constantes;

public abstract class ConstantesCodigosExcepciones {

	public final static String INFORMACION 	= "I";
	public final static String AVISO 		= "W";
	public final static String ERROR 		= "E";
	
	public final static String FUNCIONALIDAD_GENERAL  	= "G";
	public final static String FUNCIONALIDAD_CLIENTE  	= "C";
	public final static String FUNCIONALIDAD_USUARIO  	= "U";
	public final static String FUNCIONALIDAD_ENCUESTA 	= "E";
	public final static String FUNCIONALIDAD_VIVIENDA 	= "V";
	public final static String FUNCIONALIDAD_INFORMES 	= "I";
	public final static String FUNCIONALIDAD_PROVINCIAS = "P";
	public final static String FUNCIONALIDAD_MUNICIPIOS = "M";
	
	public final static String CODIGO_ERROR_NO_EJECUCION_SENTENCIA 		 = "0000";
	public final static String CODIGO_REGISTRO_NO_EXISTE 				 = "0001";
	public final static String CODIGO_REGISTRO_REPETIDO  				 = "0002";
	public final static String CODIGO_REGISTRO_NO_GUARDADO 				 = "0003";
	public final static String CODIGO_REGISTRO_NO_SELECCIONADO 			 = "0004";
	public final static String CODIGO_NINGUN_REGISTRO_CON_ESOS_CRITERIOS = "0005";
	public final static String CODIGO_REGISTRO_YA_EXISTE 				 = "0006";
	public final static String CODIGO_SENTENCIA_SOLICITADA_NO_EXISTE	 = "0007";
	public final static String CODIGO_REGISTRO_ENCONTRADOS_EXCEDE_LIMITE = "0008";
	public final static String CODIGO_REGISTRO_NO_ACTUALIZADO 			 = "0009";
	public final static String CODIGO_NUMERO_REGISTROS_ERRONEOS 		 = "0010";
	public final static String CODIGO_VARIABLE_ENTORNO_NO_ENCONTRADA	 = "0011";
	public final static String CODIGO_DATOS_INCORRECTOS	 				 = "0012";
	
	//CODIGOS PARA IDENTIFICAR EXCEPCIONES JAVA
	public final static String CODIGO_SQL_EXCEPTION 				 	 = "1000";
	public final static String CODIGO_EXCEPTION 				 	 	 = "1001";

	
	//CODIGOS DE ERROR SQL
	public final static int ENTRADA_DUPLICADA 							 = 1062;
}
